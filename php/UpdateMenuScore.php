<?php
header("Content-Type: text/html; charset=UTF-8");
 $hostname_localhost ="localhost";
    $database_localhost ="gywns41";
    $username_localhost ="gywns41";
    $password_localhost ="tmdgml11";
    $localhost = mysql_connect($hostname_localhost,$username_localhost,$password_localhost)
    or
    trigger_error(mysql_error(),E_USER_ERROR);
    
       mysql_query("set session character_set_connection=utf8;");

mysql_query("set session character_set_results=utf8;");

mysql_query("set session character_set_client=utf8;");
  
    mysql_select_db($database_localhost, $localhost);
    $ID = $_GET['ID'];
    $Score = $_GET['SC'];

    $query_update = "UPDATE MenuRating SET Score = '$Score' WHERE ID = '$ID'";;
    $query_exec = mysql_query($query_update) or die(mysql_error());

?>
