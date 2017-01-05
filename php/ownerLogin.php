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
    
$ID = $_GET['ID'];
$Password =$_GET['Password'];  
  
  
$query_search = "select * from Owner where OwnerID = '".$ID."' AND Password = '".$Password. "'";
    $query_exec = mysql_query($query_search) or die(mysql_error());
    $rows = mysql_num_rows($query_exec);
     
     while($row = mysql_fetch_assoc($query_exec)){ 
       echo $row['ResID'];
    }
  
  
mysql_close($localhost);  
?> 