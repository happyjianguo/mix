# -*- coding: utf-8 -*-

import Queue
import logging
import os
import threading
import time
import random
import signal
import multiprocessing
import gipc
import sys


class MysqlTaskManager(object):
    _IDLE_TIME = 2  # sec
    RETRY_INTERVAL = 4 * _IDLE_TIME

    #: `fetch_unsent_tx_ids` overhead during ``RETRY_INTERVAL``
    #: (~500 ms, ceiling to 1 sec)
    #: added to ``RETRY_INTERVAL`` when used to retrieve tasks which already
    #: sent and not succeeded in the period to retry
    _SKEW = 1

    def __init__(self, logger_name=None, pool_size=4):
        self._logger_name = logger_name
        self.logger = logging.getLogger(logger_name or __name__)

        self.pool_size = pool_size
        self.pool_class = ProcessPool
        self.pool = None

    def fetch_unsent_tx_ids(self):
        time.sleep(random.random())
        return [x for x in range(4)]

    def close(self):
        if self.pool:
            self.pool.stop_all()

    def __handle_sigterm_sigint(self, signum, frame):
        print('handling signal: ', signum)
        self.close()
        # restore original signal handler
        signal.signal(signum, signal.SIG_DFL)
        print('imploding...')
        os.kill(os.getpid(), signum)

    def transmit_tx(self, Worker):
        signal.signal(signal.SIGTERM, self.__handle_sigterm_sigint)
        signal.signal(signal.SIGINT, self.__handle_sigterm_sigint)

        self.pool = pool = \
            self.pool_class(Worker, self.pool_size, self._logger_name)

        loop_counter = 0
        while True:
            try:
                loop_counter += 1
                a = time.time()
                tx_ids = self.fetch_unsent_tx_ids()
                b = time.time()
                pool.add_tasks(tx_ids)
                print("{} tasks : {} added".format(b - a, tx_ids))

                time.sleep(self._IDLE_TIME)
            except Queue.Full:
                print("task queue full !")
            except Exception as e:
                self.logger.exception(e)
                time.sleep(self._IDLE_TIME)


class ProcessPool(object):
    MAX_LOAD = 2048

    RUN = 0
    CLOSE = 1

    def __init__(self, worker_class, pool_size=4, logger_name=None):
        self.logger = logging.getLogger(logger_name or "logger_pool")
        print("initing pool...")
        self.worker = worker_class()

        self._state = self.RUN
        self.taskqueue = multiprocessing.Queue(pool_size * self.MAX_LOAD)
        self.processes = pool_size
        self._pool = []
        self._repopulate_pool()

        self._start_maintainer()

    def _start_maintainer(self):
        self._maintainer = threading.Thread(target=self._maintainer_thread)
        self._maintainer.daemon = True
        self._maintainer._state = self.RUN
        self._maintainer.start()

    def _maintainer_thread(self):
        print "_maintainer_thread enter"
        thread = threading.current_thread()
        print "thread._state:", thread._state
        while thread._state == self.RUN:
            if self._join_exited_workers():
                self._repopulate_pool()
            time.sleep(0.1)

        qsize = self.taskqueue.qsize()
        if qsize:
            print("queue remaining tasks {}".format(qsize))

        while True:
            try:
                self.taskqueue.get_nowait()
            except Queue.Empty:
                break

        for _ in range(self.processes):
            self.taskqueue.put(None)

        print("Graceful exiting...")

    def _join_exited_workers(self):
        print "_join_exited_workers enter"
        cleaned = False
        for i in reversed(range(len(self._pool))):
            worker = self._pool[i]
            print "worker.exitcode:", worker.exitcode
            if worker.exitcode is not None:
                # worker exited
                print('cleaning up worker ', i)
                worker.join()
                cleaned = True
                del self._pool[i]
        return cleaned

    def _pool_worker(self):
        # worker process ignore ctrl+c
        signal.signal(signal.SIGINT, signal.SIG_IGN)
        signal.signal(signal.SIGTERM, signal.SIG_DFL)
        print "_pool_worker enter"

        while True:
            try:
                tx_id = self.taskqueue.get()
                print "_pool_worker.tx_id:", tx_id
            except (EOFError, IOError):
                break

            if tx_id is None:
                break

            print("get task: {}".format(tx_id))
            try:
                self.worker.do_work(tx_id)
            except Exception:
                print("process {} faild".format(tx_id))

    def _repopulate_pool(self):
        for i in range(self.processes - len(self._pool)):
            w = gipc.start_process(target=self._pool_worker,
                                   daemon=True)
            self._pool.append(w)

    def add_tasks(self, tx_ids):
        if self._state != self.RUN:
            print("pool closed, skip {}".format(tx_ids))
            return

        for tx_id in tx_ids:
            self.taskqueue.put(tx_id, True, 1)

    def stop_all(self):
        self.close()
        self.join()

    def close(self):
        if self._state == self.RUN:
            self._state = self.CLOSE
            self._maintainer._state = self.CLOSE

    def join(self):
        assert self._state != self.RUN

        self._maintainer.join()
        for p in self._pool:
            p.join()
