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
                        <form class="offset-3 col-6" action="index.php" method="get">
                            Nombre<br />
                            <input type="text" name="nombre" autofocus value="<?php echo $bodega[0]; ?>"><br />
                            Localizacion<br>
                            <input type="text" name="localizacion" value="<?php echo $bodega[1]; ?>"><br />
                            Email<br>
                            <input type="email" name="email" value="<?php echo $bodega[2]; ?>"><br />
                            Telefono<br>
                            <input type="text" name="telefono" value="<?php echo $bodega[3]; ?>"><br />
                            Persona de contacto<br>
                            <input type="text" name="contacto" value="<?php echo $bodega[4]; ?>"><br>
                            Fundación<br>
                            <input type="text" name="fundacion" value="<?php echo $bodega[5]; ?>"><br><br>
                            ¿Tiene restaurante?<br>
                            <input type="radio" name="restaurante" value="1" <?php if($bodega[6] == 1) {echo "checked='checked'";}?>>Si<br>
                            <input type="radio" name="restaurante" value="0" <?php if($bodega[6] == 0){echo "checked='checked'";}?>>No<br><br>
                            ¿Tiene hotel?<br>
                            <input type="radio" name="hotel" value="1" <?php if($bodega[7] == 1) {echo "checked='checked'";}?>>Si<br>
                            <input type="radio" name="hotel" value="0" <?php if($bodega[7] == 0) {echo "checked='checked'";}?>>No<br>
                            <input type="text" name="action" value="nueva" class="d-none"><br />
                            <input type="submit" value="Cambiar bodega">
                        </form>
                    </div>
                    <div class="offset-lg-2 col-lg-5">
                        <table class="table table-striped table-responsive-sm mb-5">
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Tipo</th>
                                    <th scope="col"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <?php
                                foreach ($vinos as $key => $value) {
                                    echo "<tr>";
                                    echo "<th scope='row'>", $key+1,"</th>";
                                    echo "<td>", $value->getNombre(), "</td>";
                                    echo "<td>", $value->getTipo(), "</td>";
                                    echo "<td class='container' style='width: 45%;'><div class='row' style='justify-content: space-evenly;'><form class='col-2' action='index.php' method='get'>
                                            <button class='btn btn-default' name='ver' value=", $key+1, "'>Ver</button>
                                            <input type='text' name='controller' value='vino' class='d-none'>
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