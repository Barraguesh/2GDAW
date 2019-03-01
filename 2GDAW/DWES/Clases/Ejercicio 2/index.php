<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Ejercicio 2</title>
</head>
<body>
    <?php
        include_once "Vehiculo.php";

        $coche = new Vehiculo("Fiat");

        echo $coche->saberMarca();

    ?>
</body>
</html>