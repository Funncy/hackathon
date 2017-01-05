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
    
$ID = $_POST['ID'];
$Password =$_POST['Password'];  
  
  
$query_search = "select * from Student where ID = '".$ID."' AND Password = '".$Password. "'";
    $query_exec = mysql_query($query_search) or die(mysql_error());
    $rows = mysql_num_rows($query_exec);
     
    if($rows == 0) { 
        echo "No Such User Found"; 
    }
    else  {
        echo "User Found"; 
    }
  
  
mysql_close($localhost);  
?> 