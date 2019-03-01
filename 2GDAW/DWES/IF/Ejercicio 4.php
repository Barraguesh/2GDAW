<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <title>Ejercicio 4</title>
    </head>

    <body>
        Introduce las horas trabajadas:
        <form action="Ejercicio 4.php" method="get">
            <input type="text" name="horas"><br />
            <input type="submit" value="Enviar">
        </form>
        <?php
        if (isset($_GET["horas"])) {
            if ($_GET["horas"] > 40) {
                $horasOrdinarias = 40 * 12;
                $horasExtra = $_GET["horas"] - 40;
                echo "<br/> El salario correspondiente es: ", $horasOrdinarias + ($horasExtra * 16);
            } else {
                echo "<br/> El salario correspondiente es: ", $_GET["horas"] * 12;
            }
        }
    ?>
    </body>

</html>