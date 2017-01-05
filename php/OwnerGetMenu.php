<?php
header("Content-Type: text/html; charset=UTF-8");
 $hostname_localhost ="localhost";
    $database_localhost ="gywns41";
    $username_localhost ="gywns41";
    $password_localhost ="tmdgml11";
    $localhost = mysql_connect($hostname_localhost,$username_localhost,$password_localhost)
    or 
    trigger_error(mysql_error(),E_USER_ERROR);

  
    mysql_select_db($database_localhost, $localhost);
    $ResID = $_GET['ID'];
  

    $query_search = "select * from Menu where ResNum = '$ResID'";
    $query_exec = mysql_query($query_search) or die(mysql_error());

    while($row = mysql_fetch_array($query_exec,MYSQL_ASSOC)){ 
       echo $row['Name'];
       echo ",";
       echo $row['Price'];
       echo ",";
    }

?>
