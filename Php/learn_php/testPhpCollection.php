<?php
/**
 * test phpcollection
 * User: joshua
 * Date: 17/1/9
 * Time: 14:34
 */

include_once("vendor/autoload.php");

use PhpCollection\Sequence;
use PhpCollection\Map;

$seq = new Sequence([0, 2, 3, 2]);
var_dump($seq->get(2)); // int(3)
var_dump($seq->all()); // [0, 2, 3, 2]

// Read Operations
$map = new Map(['name' => 'joshua', 'height' => '170']);
var_dump($map->get('name'));
var_dump($map->get('height'));
