<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Test</title>
</head>
<body>
    <?php 
        if(isset($_GET["numero1"]) && isset($_GET["numero2"])) {
            echo "La suma es ", $_GET["numero1"] + $_GET["numero2"];
        }
    ?>
</body>
</html>