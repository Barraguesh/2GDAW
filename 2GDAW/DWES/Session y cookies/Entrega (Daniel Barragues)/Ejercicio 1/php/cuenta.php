<!-- @Author: Daniel Barragues -->
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <title>Egibide - Intranet</title>
        <link rel="stylesheet" type="text/css" href="../style.css" />
    </head>

    <body>
        <div id="box">
            <img src="../media/logo_egibide.png">
            <?php
                session_start();
                echo "<h1>Bienvenido ", $_SESSION["nombreUsuario"],", su cuenta está correcta</h1>";
            ?>
        </div>
    </body>

</html>