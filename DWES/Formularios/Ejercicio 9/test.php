<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Test</title>
</head>
<body>
    <?php 
        if(isset($_GET["altura"]) && $_GET["radio"]) {
            echo "El volumen es: ", 1 / 3 * pi() * ($_GET["radio"] * $_GET["radio"]) * $_GET["altura"];
        }
    ?>
</body>
</html>