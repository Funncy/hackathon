<?php
header("Content-Type: text/html; charset=UTF-8");
 $hostname_localhost ="localhost";
    $database_localhost ="gywns41";
    $username_localhost ="gywns41";
    $password_localhost ="tmdgml11";
    $localhost = mysql_connect($hostname_localhost,$username_localhost,$password_localhost)
    or
    trigger_error(mysql_error(),E_USER_ERROR);
    
    $ID = $_GET['ID'];
    
    mysql_select_db($database_localhost, $localhost);
    
    $query_search = "select * from Reservation where ResID ='$ID'";
    $query_exec = mysql_query($query_search) or die(mysql_error());
while($row = mysql_fetch_array($query_exec,MYSQL_ASSOC)){
    echo $row['ID'];
      echo ",";
       echo $row['StudentID'];
      echo ",";
      $temp = $row['MenuID'];
      $query_search2= "select * from Menu where ID ='$temp'";
      $query_exec2 = mysql_query($query_search2) or die(mysql_error());
      $row2 = mysql_fetch_assoc($query_exec2);
      
      echo  $row2['Name'];
      echo ",";
     
}

?>