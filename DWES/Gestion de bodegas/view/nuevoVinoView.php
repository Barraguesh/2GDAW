<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Gestion de bodegas</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </head>

    <body>
        <?php include_once "menu.php"?>
        <div class="container" style="margin-top: 5%;">
            <header style="text-align:center;">
                <h1>Nuevo vino</h1>
            </header>
            <div class="mt-5 row">
                <form class="offset-3 col-6" action="index.php" method="get">
                    Nombre<br />
                    <input type="text" name="nombre" autofocus><br />
                    Descripcion<br>
                    <input type="text" name="descripcion"><br />
                    Anno<br>
                    <input type="text" name="anno"><br />
                    Alcohol<br>
                    <input type="text" name="alcohol"><br>
                    Tipo<br>
                    <input type="text" name="tipo"><br><br>
                    <input type="text" name="ver" value="<?php echo $_GET["ver"]?>" class="d-none">
                    <input type="text" name="action" value="nuevo" class="d-none"><br />
                    <input type='text' name='controller' value='vino' class='d-none'>
                    <input type="submit" value="Añadir vino">
                </form>
            </div>
        </div>
    </body>

</html>