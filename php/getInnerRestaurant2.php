<?php
 $hostname_localhost ="localhost";
    $database_localhost ="gywns41";
    $username_localhost ="gywns41";
    $password_localhost ="tmdgml11";
    $localhost = mysql_connect($hostname_localhost,$username_localhost,$password_localhost)
    or
    trigger_error(mysql_error(),E_USER_ERROR);
  
    mysql_select_db($database_localhost, $localhost);
    
    $query_search = "select * from InnerRestaurant where ID = {$ID}";
    $query_exec = mysql_query($query_search) or die(mysql_error());


?>