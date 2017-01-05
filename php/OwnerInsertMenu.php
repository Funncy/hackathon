
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
    $ResID = $_GET['ResID'];
    $Price = $_GET['Price'];
    $FoodName = $_GET['FoodName'];
    if($FoodName!=null){
    $query_insert = "INSERT INTO Menu(ID,ResNum,Name,Price,Score,Image) VALUES(NULL,'$ResID','$FoodName','$Price','0','')";
    $query_exec = mysql_query($query_insert) or die(mysql_error());
    }

?>
