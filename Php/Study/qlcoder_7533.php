<?php

$chk_string = "7E38890B870934B126F66857ED6B57B9";
$year = 0;
$month = 0;
$day = 0;

for ($year = 1900; $year <= 2020; $year++) {
  for ($month = 1; $month <= 12; $month++) {
    for ($day = 1; $day <= 31; $day++) {
      $str = sprintf("%04d", $year) . sprintf("%02d", $month) . sprintf("%02d", $day);
      if (strtoupper(md5($str)) == $chk_string) {
        echo $str . "\n";
      }
    }
  }
}