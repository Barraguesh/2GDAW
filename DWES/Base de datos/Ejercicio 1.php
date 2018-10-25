<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <title>Ejercicio 1</title>
        <style>
            hr {
                width: 100px;
                float: left;
            }
        </style>
    </head>

    <body>
        <?php
            try {
                $conexion = new PDO("mysql:host=localhost;dbname=banco;charset=utf8", "root", "");
            } catch (PDOException $e) {
                echo "No se ha podido establecer conexión con el servidor de bases de datos.<br>";
                die("Error: " . $e->getMessage());
            }
            $consulta = $conexion->query("SELECT DNI, Nombre, Direccion, Telefono FROM cliente");
            echo "Consulta a la base de datos:<br/><hr><br/>";
            while ($cliente = $consulta->fetchObject()) {
                echo $cliente->DNI,"<br/>";
                echo $cliente->Nombre,"<br/>";
                echo $cliente->Direccion,"<br/>";
                echo $cliente->Telefono,"<br/>";
                echo "<hr><br/>";
            }
            ?>
        <form action="Ejercicio 1.php" method="post">
            <input type="text">
            <input type="submit" name="DNI" value="Consulta el DNI">
        </form>
        <?php
            if (isset($_POST['DNI'])) {
                // Comprueba si ya existe un cliente con el DNI introducido
                $DNI = $_POST['DNI'];
                $consulta = $conexion->query("SELECT DNI FROM cliente WHERE DNI='$DNI'");
                if ($consulta->rowCount() > 0) {
                    echo "Ese usuario esta en la tabla";
                } else {
                    $insercion = "INSERT INTO cliente (dni, nombre, direccion, telefono) VALUES ('$_POST[DNI]','Insertado','Test','Test')";
                    $conexion->exec($insercion);
                    echo "Cliente dado de alta correctamente.";
                }
            }
            ?>

    </body>

</html>