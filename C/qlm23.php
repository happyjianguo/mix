<?php
header("content-type:text/html;charset=utf8");
$start = 0;
$result = array();

for ($i = 0; $i < 7; $i ++) {
	$url = "https://movie.douban.com/top250?start=". $start ."&filter=";
	$html = file_get_contents($url);
	$matches = array();
	preg_match_all('#<span class="rating_num" property="v:average">([0-9]\.[0-9])</span>#', $html, $matches);
	$result[] = $matches[1];
	$start = $start + 25;	
}

$total_score = 0;
$jishu = 0;
foreach ($result as $key => $value) {
	foreach ($value as $k1 => $v1) {
		if ($jishu < 166) {
			$total_score += $v1;	
		}
		$jishu++;
	}
}

echo "豆瓣目前排名前166的电影的总评分是：" . $total_score;