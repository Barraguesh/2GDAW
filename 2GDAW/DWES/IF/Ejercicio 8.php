<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <title>Ejercicio 8</title>
    </head>

    <body>
        <form action="Ejercicio 8.php" method="get">
            Introduce la primera nota:
            <input type="text" name="nota1"><br />
            Introduce la segunda nota:
            <input type="text" name="nota2"><br />
            Introduce la tercera nota:
            <input type="text" name="nota3"><br />
            <input type="submit" value="Enviar">
        </form>
        <?php
        if (isset($_GET["nota1"]) && isset($_GET["nota2"]) && isset($_GET["nota3"])) {
            $media = ($_GET["nota1"] + $_GET["nota2"] + $_GET["nota3"]) / 3;
            if ($media < 5) {
                echo "Insuficiente";
            } elseif ($media == 5) {
                echo "Suficiente";
            } elseif ($media == 6) {
                echo "Bien";
            } elseif ($media == 7 || $media == 8) {
                echo "Notable";
            } elseif ($media > 8) {
                echo "Sonbresaliente";
            }
        }
    ?>
    </body>

</html>