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
                <h1>Panel de gestion</h1>
            </header>
            <div class="mt-5">
                <div class="row mb-1 ml-1">
                    <form action='index.php' method='get'>
                        <button class='btn btn-primary' name='action' value='nuevaBodegaView'>Nueva bodega</button>
                    </form>
                </div>
                <div class="row">
                    <div class="col-lg-12">
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
                                    foreach ($bodegas as $key => $value) {
                                        echo "<tr>";
                                        echo "<th scope='row'>", $key+1,"</th>";
                                        echo "<td>", $value->getNombre(), "</td>";
                                        echo "<td>", $value->getLocalizacion(), "</td>";
                                        echo "<td>", $value->getEmail(), "</td>";
                                        echo "<td>", $value->getTelefono(), "</td>";
                                        echo "<td class='container' style='width: 18%;'><div class='row' style='justify-content: space-evenly;'><form class='col-2' action='index.php' method='get'>
                                                <button class='btn btn-default' name='ver' value='", $key+1, "'>Ver</button>
                                                <input type='text' name='action' value='bodegaView' class='d-none'>
                                                </form>";
                                        echo "<form class='col-6' action='index.php' method='get'>
                                                <button type='submit' class='btn btn-danger' name='eliminar' value=", $key+1, "'>Eliminar</button>
                                                <input type='text' name='action' value='eliminar' class='d-none'>
                                                </form></div></td>";
                                        echo "</tr>";
                                    }
                                    ?>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
    </body>

</html>