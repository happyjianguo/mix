# python多进程类

## 运行

`python cmd.py`

## 多线程运行结果:

```
initing pool...
_pool_worker enter
_maintainer_thread enter
thread._state: 0
_join_exited_workers enter
worker.exitcode: None
worker.exitcode: None
_pool_worker enter
test: 0
test: 1
test: 2
test: 3
_pool_worker.tx_id: 0
get task: 0
0.00142812728882 tasks : [0, 1, 2, 3] added
_pool_worker.tx_id: 1
get task: 1
_join_exited_workers enter
worker.exitcode: None
worker.exitcode: None
_join_exited_workers enter
worker.exitcode: None
worker.exitcode: None
_join_exited_workers enter
worker.exitcode: None
worker.exitcode: None
_join_exited_workers enter
worker.exitcode: None
worker.exitcode: None
EosTxWorker do_work: 0, time: 1456972562.27
_pool_worker.tx_id: 2
get task: 2
EosTxWorker do_work: 1, time: 1456972562.31
_pool_worker.tx_id: 3
get task: 3
_join_exited_workers enter
worker.exitcode: None
worker.exitcode: None
^C('handling signal: ', 2)
Graceful exiting...
EosTxWorker do_work: 3, time: 1456972562.97
_pool_worker.tx_id: None
EosTxWorker do_work: 2, time: 1456972563.24
_pool_worker.tx_id: None
imploding...
```