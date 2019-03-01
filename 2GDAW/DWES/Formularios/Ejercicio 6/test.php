<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Test</title>
</head>
<body>
    <?php 
        if(isset($_GET["base"]) && isset($_GET["altura"])) {
            echo "Area del triángulo: ", $_GET["base"] * $_GET["altura"] / 2;
        }
    ?>
</body>
</html>