<?php

$data = file('145035182953188.txt');
$data2 = array();

//1、创建画布
$im = imagecreatetruecolor(1000,1000);//新建一个真彩色图像，默认背景是黑色，返回图像标识符。另外还有一个函数 imagecreate 已经不推荐使用。

//2、绘制所需要的图像
$red = imagecolorallocate($im,255,0,0);//创建一个颜色，以供使用
//循环在页面上输出文件里写的坐标值
foreach ($data as $key => $value) {
	$location = explode(' ', $value);
	imageellipse($im, (int)$location[0], (int)$location[1], 5, 5,$red);//画一个圆。参数说明：第二，第三为圆形的中心坐标；第四第五为宽和高，不一样时为椭圆；$red为圆形的颜色（框颜色）
}

//3、输出图像
header("content-type: image/png");
imagepng($im, "test.png");//输出到页面。如果有第二个参数[,$filename],则表示保存图像

//4、销毁图像，释放内存
imagedestroy($im);