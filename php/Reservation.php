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
    $ResNum = $_GET['RID'];
    $StudentID = $_GET['SID'];
    $FoodID = $_GET['FID'];

    

    $query_insert = "INSERT INTO Reservation(ID,ResID,StudentID,MenuID) VALUES(NULL,'$ResNum','$StudentID','$FoodID')";
    $query_exec = mysql_query($query_insert) or die(mysql_error());
    
    echo $result;

?>
