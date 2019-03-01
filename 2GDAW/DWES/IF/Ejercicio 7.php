<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <title>Ejercicio 7</title>
    </head>

    <body>
        <form action="Ejercicio 7.php" method="get">
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
            echo "<br/> La media es: ", ($_GET["nota1"] + $_GET["nota2"] + $_GET["nota3"]) / 3;
        }
    ?>
    </body>

</html>