<?php
define('STEP', '25');

$url = 'https://movie.douban.com/top250';
  function curl_request($url){
        $curl   = curl_init();
        curl_setopt($curl, CURLOPT_SSL_VERIFYPEER, false);
        curl_setopt($curl, CURLOPT_URL, $url);
        curl_setopt($curl, CURLOPT_FOLLOWLOCATION, 1);
        curl_setopt($curl, CURLOPT_TIMEOUT, 10);
        curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
        $data = curl_exec($curl);
        curl_close($curl);
        return $data;
}
$sum = 0;
$pattern ='/v:average\">(.*)<\/span/';
for ($i=0; $i <7 ; $i++) {
  $start      = $i*STEP;
  $filter     = $i+1;
  $temp_url   = $url.'?start='.$start."&filter=".$filter;
  $temp_data  = curl_request($temp_url);
  preg_match_all($pattern, $temp_data, $arr);
  if ($i==6) {
  $temp_arr   =   array_slice($arr['1'], 0,16);
  $sum        += array_sum($temp_arr);
  }
  else{
  $sum        += array_sum($arr['1']);
}
}

echo $sum;