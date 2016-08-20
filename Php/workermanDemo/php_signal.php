<?php
include_once './signal_fun.php';
tlog('im start run');
declare(ticks=1);

// 开启一个信号监控
pcntl_signal(SIGTERM, 'signal_handler');

$myids = array();
while(1) {
  for ($i = 0; $i < 5; ++$i) {
    $mypid =pcntl_fork();		// 开启一个子进程，子进程和父进程同时从此处向下执行
    if ($mypid < 0) {			// 子进程启动失败
      tlog('fork error!');
    } elseif ($mypid == 0) {	// 子进程中，读到的进程id为0
      tlog('im child!');
      sleep(1000);			// 子进程挂起
      exit;
    } else {					// 父进程读到子进程的pid
      $myids[] = $mypid;
      sleep(1);
    }
  }

  sleep(10);
  if ($myids) {
    foreach ($myids as $key => $pid) {
      tlog('kill '. $pid);

      posix_kill($pid, SIGTERM);			// 传递信号，kill 子进程

      unset($myids[$key]);

      sleep(2);
    }
  }
}
