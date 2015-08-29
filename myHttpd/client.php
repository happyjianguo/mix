<?php
/**
 * @Author: joshua
 * @Date:   2015-08-29 23:18:17
 * @Last Modified by:   joshua
 * @Last Modified time: 2015-08-29 23:21:39
 */

error_reporting(E_ALL);
set_time_limit(0);

echo "TCP/IP Connection";

$service_port = 2009;
$address = '127.0.0.1';

$socket = socket_create(AF_INET,SOCK_STREAM,SOL_TCP);
if($socket < 0){
	echo "error";
}else{
	echo "ok\n";
}
$result = socket_connect($socket, $address, $service_port);

if($result < 0){
	echo socket_strerror($result);
}else{
	echo "ok";
}
$in = "Hello/r/n";
$in .= "我是Chester/r/n";
$out = '';
$out1='';

if(!socket_write($socket, $in, strlen($in)))
{
echo "socket_write() failed: reason: " . socket_strerror($socket) . "/n";
}
else
{
echo "发送到服务器信息成功！<br>";
echo "发送的内容为:<font color='red'>$in</font> <br>";
}
while($out = socket_read($socket, 8192))
{
echo "接收服务器回传信息成功！<br>";
echo "接受的内容为:",$out;
}


echo "关闭SOCKET...<br>";
socket_close($socket);
echo "关闭OK<br>";
