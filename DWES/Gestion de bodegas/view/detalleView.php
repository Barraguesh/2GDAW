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
                <h1>Panel de gestion: bodega</h1>
            </header>
            <div class="mt-5">
                <div class="row">
                    <div class="col-lg-5">
                        <form>

                        </form>
                    </div>
                    <div class="offset-lg-2 col-lg-5">
                        <form action="index.php" method="get">
                            Nombre<br />
                            <input type="text" name="nombre" autofocus><br />
                            Apellidos<br />
                            <input type="text" name="apellidos"><br />
                            Email<br />
                            <input type="email" name="email"><br />
                            Telefono<br />
                            <input type="text" name="telefono"><br />
                            <input type="text" name="action" value="alta" class="d-none"><br />
                            <input type="submit" value="Enviar">
                        </form>
                    </div>
                </div>
            </div>
    </body>

</html>