#!/usr/bin/env python
# -*- coding: utf-8 -*-

import sys
import time
import random
from tx_task import MysqlTaskManager
import threading
import Queue


class EosTxWorker():

    def do_work(self, tx_id):
        time.sleep(random.random())
        print "EosTxWorker do_work: {}, time: {}".format(tx_id, time.time())


class ShardMysqlTaskManager(MysqlTaskManager):

    def fetch_unsent_tx_ids(self):
        queue = Queue.Queue()
        tx_ids = []
        threads = []
        for i in range(4):
            thread = threading.Thread(target=test, args=(queue, i))
            thread.setDaemon(True)
            thread.start()
            threads.append(thread)

        for t in threads:
            t.join()

        while not queue.empty():
            tx_ids.append(queue.get())
        return tx_ids


def test(queue, i):
    print "test:", i
    queue.put(i)


if __name__ == "__main__":
    manager = ShardMysqlTaskManager('eos.txdaemon', pool_size=2)
    manager.transmit_tx(EosTxWorker)
