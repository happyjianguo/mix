<?php
// 设置信号处理函数
function signal_handler($signo) {
  switch ($signo) {
    case SIGTERM:
      // 处理SIGTERM信号
      tlog("Caught SIGTERM...exit...\n");
      exit;
      break;
    case SIGHUP:
      //处理SIGHUP信号
      tlog("Caught SIGHUP...\n");
      break;
    case SIGUSR1:
      tlog("Caught SIGUSR1...\n");
      break;
    default:
      // 处理所有其他信号
  }
}

// 写日志
function tlog($message, $print=1) {
  $message = posix_getpid() . '_' . $message . "\n";
  if ($print) {
    echo $message;
  } else {
    error_log(posix_getpid() . '_' . $message . "\n", 3, '/var/www/log.log');
  }
}

function _system($script) {
  return system("/usr/bin/php {$script} >> /tmp/system.log");
}