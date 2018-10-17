<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Test</title>
</head>
<body>
    <?php 
        if(isset($_GET["horas"])) {
            echo "Salario: ", $_GET["horas"] * 12;
        }
    ?>
</body>
</html>