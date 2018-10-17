<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Test</title>
</head>
<body>
    <?php 
        if(isset($_GET["euros"])) {
            echo $_GET["euros"]," euros son ", $_GET["euros"] * 166.386," pesetas.";
        }
    ?>
</body>
</html>