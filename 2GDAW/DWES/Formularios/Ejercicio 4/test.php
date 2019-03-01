<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Test</title>
</head>
<body>
    <?php 
        if(isset($_GET["numero1"])) {
            echo "Suma: ", $_GET["numero1"] + $_GET["numero2"],"<br/>";
            echo "Resta: ", $_GET["numero1"] - $_GET["numero2"],"<br/>";
            echo "Multiplicacion: ", $_GET["numero1"] * $_GET["numero2"],"<br/>";
            echo "Division: ", $_GET["numero1"] / $_GET["numero2"];
        }
    ?>
</body>
</html>