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
        <title>Ejercicio 3</title>
    </head>

    <body>
        <form action="Ejercicio 3.php" method="GET">
            <input type="text" name="numero">
            <input type="submit" value="Enviar">
        </form>
        <?php
            if (isset($_GET["numero"])) {
                if ($_SESSION["numeroGuardado"] < 10000) {
                    $_SESSION["numeroGuardado"] = $_SESSION["numeroGuardado"] + $_GET["numero"];
                    $_SESSION["cantidadNumeros"]++;
                } else {
                    echo "<br/>Media: ", $_SESSION["numeroGuardado"] / $_SESSION["cantidadNumeros"];
                    echo "<br/>Contador números: ", $_SESSION["cantidadNumeros"];
                    echo "<br/>Suma total: ", $_SESSION["numeroGuardado"];
                }
            }
        ?>
    </body>

</html>