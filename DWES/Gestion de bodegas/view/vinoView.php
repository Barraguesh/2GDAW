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
            <header>
                <h1>Panel de gestion: vino</h1>
            </header>
            <div class="mt-5">
                <div class="row">
                    <div class="offset-lg-1 col-lg-5">
                        <form class="offset-3 col-6" action="index.php" method="get">
                            Nombre<br />
                            <input type="text" name="nombre" autofocus value="<?php echo $vino[0]; ?>"><br />
                            Descripcion<br>
                            <input type="text" name="localizacion" value="<?php echo $vino[1]; ?>"><br />
                            Año<br>
                            <input type="email" name="email" value="<?php echo $vino[2]; ?>"><br />
                            Alcohol<br>
                            <input type="text" name="telefono" value="<?php echo $vino[3]; ?>"><br />
                            Tipo<br>
                            <input type="text" name="contacto" value="<?php echo $vino[4]; ?>"><br>
                            <input type="text" name="action" value="nueva" class="d-none"><br />
                            <input type="submit" value="Cambiar vino">
                        </form>
                    </div>
                </div>
            </div>
    </body>

</html>