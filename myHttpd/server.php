<?php
/**
 * @Author: joshua
 * @Date:   2015-08-29 23:09:15
 * @Last Modified by:   joshua
 * @Last Modified time: 2015-08-29 23:17:41
 */
set_time_limit(0);
$address = '127.0.0.1';
$port = 2009;

if(($sock = socket_create(AF_INET,SOCK_STREAM,SOL_TCP))<0){
	echo "socket_create fail:".socket_strerror($sock)."\n";
}

if(($ret = socket_bind($sock,$address,$port))<0){
	echo "socket_bind fail:".socket_strerror($ret)."\n";
}

if(($ret = socket_listen($sock,4))<0){
	echo "socket_list fail";
}

do{
	if(($msgsock = socket_accept($sock))<0){
		echo "socket_accept fail";
		break;
	}

	$msg = "welcome to server";
	socket_write($msgsock,$msg,strlen($msg));

	echo "message";
	$buf = socket_read($msgsock,8192);
	socket_close($msgsock);

}while(true);
socket_close($sock);
