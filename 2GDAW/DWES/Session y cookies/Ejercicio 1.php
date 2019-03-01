<?php
    session_start();
    if (!isset($_SESSION["numeroGuardado"])) {
        $_SESSION["numeroGuardado"] = 0;
    }
    if (!isset($_SESSION["cantidadNumeros"])) {
        $_SESSION["cantidadNumeros"] = 0;
    }
?>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <title>Ejercicio 1</title>
    </head>

    <body>
        <form action="Ejercicio 1.php" method="GET">
            <input type="text" name="numero">
            <input type="submit" value="Enviar">
        </form>
        <?php
            if (isset($_GET["numero"])) {
                if ($_GET["numero"] >= 0) {
                    $_SESSION["numeroGuardado"] = $_SESSION["numeroGuardado"] + $_GET["numero"];
                    $_SESSION["cantidadNumeros"]++;
                } else {
                    echo "<br/>Media: ", $_SESSION["numeroGuardado"] / $_SESSION["cantidadNumeros"];
                }
            }
        ?>
    </body>

</html>