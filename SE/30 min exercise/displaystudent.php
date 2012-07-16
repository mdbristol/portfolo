<html>

<head>
<title>ITEC 471 - GRADEBOOK </title>
</head>

<body>
<center><img src="http://assets.lifehack.org/wp-content/files/2007/09/20070921-notebook.jpg"></center>
<h2><center> Itec 471 Gradebook </h2>

<?php

  $dbhost = 'localhost';
  $dbuser = 'team18';
  $dbpass = 'team_18';
  $dbname = 'team18';

  require_once( 'DB.php' );

  $db = DB::connect( "mysql://$dbuser:$dbpass@$dbhost/$dbname" );

  $db->setFetchMode(DB_FETCHMODE_ASSOC);

  $sql = 'SELECT * FROM students';
  //$sql = 'SELECT Avg(hw1) as Average FROM students Group by firstname, lastname'; 
  $demoResult = $db->query($sql);

  while ($demoRow = $demoResult->fetchRow()) {
     echo $demoRow['firstname'] . ' ' . $demoRow['lastname'] . ' ';
     echo $demoRow['hw1'] . ' ';
     echo $demoRow['hw2'] . ' ' . $demoRow['hw3'] . ' ' ; 
	 echo $demoRow['hw1' + 'hw2' + 'hw3' /3] . ' ' '<br>';
  }


?>
   </center>
   

</body>

</html>