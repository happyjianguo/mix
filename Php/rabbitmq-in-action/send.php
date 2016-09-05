<?php

require_once __DIR__ . '/vendor/autoload.php';
use PhpAmqpLib\Connection\AMQPConnection;
use PhpAmqpLib\Message\AMQPMessage;

$conn = new AMQPConnection('localhost', 5672, 'guest', 'guest');
$ch = $conn->channel();
$ch->queue_declare('hello', false, false, false, false);
$msg = new AMQPMessage('hello, world');
$ch->basic_publish($msg, '', 'hello');

$ch->close();
$conn->close();