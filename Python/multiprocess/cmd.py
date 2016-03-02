#!/usr/bin/env python
# -*- coding: utf-8 -*-

import sys
import time
import random
from tx_task import MysqlTaskManager


class EosTxWorker():
    def do_work(self, tx_id):
        time.sleep(random.random())
        print "EosTxWorker do_work: {}, time: {}".format(tx_id, time.time())


if __name__ == "__main__":
    manager = MysqlTaskManager('eos.txdaemon', pool_size=2)
    manager.transmit_tx(EosTxWorker)
