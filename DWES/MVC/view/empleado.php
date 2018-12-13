<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Empleados</title>
    </head>

    <body>
        <div>
            
        </div>
        <div>
            <form action="controller/EmpleadoController.php" method="get">
                Nombre<br />
                <input type="text" name="nombre" autofocus><br />
                Apellidos<br />
                <input type="text" name="appelidos"><br />
                Email<br />
                <input type="email" name="email"><br />
                Telefono<br />
                <input type="text" name="telefono"><br />
                <input type="submit" value="Enviar">
            </form>
        </div>
    </body>

</html>