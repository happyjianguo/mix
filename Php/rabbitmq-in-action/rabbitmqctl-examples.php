<?php

require_once __DIR__ . '/vendor/autoload.php';

use PhpAmqpLib\Connection\AMQPStreamConnection;
use PhpAmqpLib\Message\AMQPMessage;
use PhpAmqpLib\Connection\AMQPConnection;

define('HOST', 'localhost');
define('PORT', 5672);
define('USER', 'guest');
define('PASS', 'guest');


$conn = new AMQPConnection(HOST, PORT, USER, PASS);
$channel = $conn->channel();

$channel->exchange_declare('logs-exchange',
  'topic', false, true, false);
$channel->queue_declare('msg-inbox-errors',
  false, true, false, false);
$channel->queue_declare('msg-inbox-logs',
  false, true, false, false);
$channel->queue_declare('all-logs', false,
  true, false, false);
$channel->queue_bind('msg-inbox-errors',
  'logs-exchange', 'error.msg-inbox');
$channel->queue_bind('msg-inbox-logs',
  'logs-exchange', '*.msg-inbox');