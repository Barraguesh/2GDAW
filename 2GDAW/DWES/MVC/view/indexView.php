<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Empleados</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </head>

    <body>
        <?php include_once "menu.php"?>
        <div class="container" style="margin-top: 5%;">
            <header>
                <h1>Gestion empleados</h1>
            </header>
            <div class="mt-5">
                <div class="row">
                    <div class="col-lg-8">
                        <table class="table table-striped table-responsive-sm mb-5">
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Apellidos</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Telefono</th>
                                    <th scope="col"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <?php
                                    foreach ($empleados as $key => $value) {
                                        echo "<tr>";
                                        echo "<th scope='row'>", $key+1,"</th>";
                                        echo "<td>", $value->getNombre(), "</td>";
                                        echo "<td>", $value->getApellidos(), "</td>";
                                        echo "<td>", $value->getEmail(), "</td>";
                                        echo "<td>", $value->getTelefono(), "</td>";
                                        echo "<form action='index.php' method='get'>
                                                <td><button type='submit' class='btn-danger' name='eliminar' value=", $key+1, "'>Eliminar</button></td>
                                                <input type='text' name='action' value='eliminar' class='d-none'>
                                                </form>";
                                        echo "</tr>";
                                    }
                                    ?>
                            </tbody>
                        </table>
                    </div>
                    <div class="offset-lg-1 col-lg-3">
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