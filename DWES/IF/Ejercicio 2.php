<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <title>Ejercicio 4</title>
    </head>

    <body>
        Introduce una hora (0-23):
        <form action="Ejercicio 2.php" method="get">
            <input type="text" name="hora"><br />
            <input type="submit" value="Enviar">
        </form>
        <?php
        if (isset($_GET["hora"])) {
            if ($_GET["hora"] >= 6 && $_GET["hora"] <= 12) {
                echo "<br/>","Buenos dias baby";
            } elseif ($_GET["hora"] >= 13 && $_GET["hora"] <= 20) {
                echo "<br/>","Buenas tardes bebé";
            } elseif ($_GET["hora"] >= 21 || $_GET["hora"] <= 5) {
                echo "<br/>","Buenas noches dorminlón";
            }
        }
    ?>
    </body>

</html>