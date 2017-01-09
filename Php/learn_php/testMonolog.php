<?php
/**
 * monolog test
 * User: joshua
 * Date: 17/1/9
 * Time: 13:57
 */

include_once("vendor/autoload.php");

use Monolog\Handler\StreamHandler;
use Monolog\Logger;

// create a log channel
$log = new Logger('test');
$log->pushHandler(new StreamHandler('/tmp/test.log', Logger::WARNING));

// add records to the log
$log->warning('This is a warning');
$log->error('This is a error');