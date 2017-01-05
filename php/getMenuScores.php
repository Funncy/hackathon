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
    $MenuID = $_GET['ID'];
  

    $query_search = "select * from MenuRating where MenuID ='$MenuID'";
    $query_exec = mysql_query($query_search) or die(mysql_error());
$total=0;
$count=0;
    while($row = mysql_fetch_assoc($query_exec)){ 
       $total = $total + $row['Score'];
       $count++;
    }
    if($count!=0)
    $result = $total/$count;
    else
    $result =0;
    
     $query_update = "UPDATE Menu SET Score = '$result' WHERE ID = '$MenuID'";;
     $query_exec = mysql_query($query_update) or die(mysql_error());
    
    echo $result;

?>
