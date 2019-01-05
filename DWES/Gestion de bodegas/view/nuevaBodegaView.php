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
                <h1>Nueva bodega</h1>
            </header>
            <div class="mt-5 row">
                <form class="offset-3 col-6" action="index.php" method="get">
                    Nombre<br />
                    <input type="text" name="nombre" autofocus><br />
                    Localizacion<br>
                    <input type="text" name="localizacion" placeholder="Ejemplo (Provincia)"><br />
                    Email<br>
                    <input type="email" name="email"><br />
                    Telefono<br>
                    <input type="text" name="telefono"><br />
                    Persona de contacto<br>
                    <input type="text" name="contacto"><br>
                    Fundación<br>
                    <input type="text" name="fundacion"><br><br>
                    ¿Tiene restaurante?<br>
                    <input type="radio" name="restaurante" value="1">Si<br>
                    <input type="radio" name="restaurante" value="0">No<br><br>
                    ¿Tiene hotel?<br>
                    <input type="radio" name="hotel" value="1">Si<br>
                    <input type="radio" name="hotel" value="0">No<br>
                    <input type="text" name="action" value="nueva" class="d-none"><br />
                    <input type="submit" value="Añadir bodega">
                </form>
            </div>
        </div>
    </body>

</html>