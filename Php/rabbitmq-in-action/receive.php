<?php
require_once __DIR__ . '/vendor/autoload.php';
use PhpAmqpLib\Connection\AMQPConnection;

$conn = new AMQPConnection('localhost', 5672, 'guest', 'guest');
$ch = $conn->channel();

$ch->queue_declare('hello', false, false, false, false);

echo "To exit press Ctrl + C, \n";

$cb = function ($msg) {
  echo $msg->body, "\n";
};

$ch->basic_consume('hello', '', false, false, false, false, $cb);

while (count($ch->callbacks)) {
  $ch->wait();
}

$ch->close();
$conn->close();