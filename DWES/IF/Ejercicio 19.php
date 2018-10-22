<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <title>Ejercicio 19</title>
    </head>

    <body>
        <form action="Ejercicio 19.php" method="get">
            Introduce el número:
            <input type="text" name="numero"><br />
            <input type="submit" value="Enviar">
        </form>
        <?php
        if (isset($_GET["numero"])) {
            $arrayNumero = str_split($_GET["numero"]);
            for ($i=0; $i < sizeof($arrayNumero); $i++) {
                $x = sizeof($arrayNumero) - 1 - $i;
                $arrayVuelto[$i] = $arrayNumero[$x];
            }
            if ($arrayNumero == $arrayVuelto) {
                echo "Es capicúa";
            } else {
                echo "No es capicúa";
            }
        }
    ?>
    </body>

</html>