<?php
    session_start();
    if (!isset($_SESSION["impares"])) {
        $_SESSION["impares"] = 0;
    }
    if (!isset($_SESSION["cantidadImpares"])) {
        $_SESSION["cantidadImpares"] = 0;
    }
    if (!isset($_SESSION["cantidadNumeros"])) {
        $_SESSION["cantidadNumeros"] = 0;
    }
    if (!isset($_SESSION["parMayor"])) {
        $_SESSION["parMayor"] = 0;
    }
?>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <title>Ejercicio 2</title>
    </head>

    <body>
        <form action="Ejercicio 2.php" method="GET">
            <input type="text" name="numero">
            <input type="submit" value="Enviar">
        </form>
        <?php
            if (isset($_GET["numero"])) {
                if ($_GET["numero"] >= 0 && $_GET["numero"] % 2 != 0) {
                    $_SESSION["impares"] = $_SESSION["impares"] + $_GET["numero"];
                    $_SESSION["cantidadImpares"]++;
                    $_SESSION["cantidadNumeros"]++;
                } elseif ($_GET["numero"] >= 0 && $_GET["numero"] % 2 == 0 && $_GET["numero"] > $_SESSION["parMayor"]) {
                    $_SESSION["parMayor"] = $_GET["numero"];
                    $_SESSION["cantidadNumeros"]++;
                } else {
                    echo "<br/>Media impares: ", $_SESSION["impares"] / $_SESSION["cantidadImpares"];
                    echo "<br/>Par mayor: ", $_SESSION["parMayor"];
                    echo "<br/>Total numeros: ", $_SESSION["cantidadNumeros"];
                }
            }
        ?>
    </body>

</html>