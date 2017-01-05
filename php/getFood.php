<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
<body>
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
    $ResNum = $_GET['ID'];


    $query_search = "select * from Menu where ResNum ='$ResNum' ";
    $query_exec = mysql_query($query_search) or die(mysql_error());

    while($row = mysql_fetch_assoc($query_exec)){ 
       echo $row['ID'];
      echo ",";
       echo $row['Name'];
       echo ",";
       echo $row['Price'];
      echo ",";
       echo $row['Score'];
     echo ",";
}

?>
