<?php

require_once './Workerman/Autoloader.php';

use Workerman\Worker;
use Workerman\Lib\Timer;

$task = new Worker();

$task->onWorkerStart = function($task){
  $time_interval = 2.5;
  $timer_id = Timer::add($time_interval,function(){
    echo "Timer run\n";
  });
};

Worker::runAll();