<html><head><body>
<?php
    $ID = $_GET['ID'];
    
    echo "<script>var o = document.viewForm;
    o.type1.value =".$ID.";
    o.action=\"http://m.sejong.ac.kr/front/cafeteria.do\";
    o.submit();</script>";

?>

</body></head></html>
