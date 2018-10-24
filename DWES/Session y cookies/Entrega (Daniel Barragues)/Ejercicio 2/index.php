<!-- @Author: Daniel Barragues -->
<?php
    session_start();
    if (!isset($_SESSION["productos"])) {
        $miBand3 = ["id"=>001, "nombre"=>"Mi Band 3","descripcion"=>"blah","precio"=>29];
        $amazfitPace = ["id"=>002, "nombre"=>"Amazfit Pace","descripcion"=>"blah","precio"=>110];
        $amazfitStratos = ["id"=>003, "nombre"=>"Amazfit Stratos","descripcion"=>"blah","precio"=>140];
        $bip = ["id"=>004, "nombre"=>"Bip","descripcion"=>"blah","precio"=>80];
        $_SESSION["productos"] = ["miBand3"=>$miBand3,"amazfitPace"=>$amazfitPace,"amazfitStratos"=>$amazfitStratos,"bip"=>$bip];
    }
    if (!isset($_SESSION["carritoCompraSession"])) {
        $_SESSION["carritoCompraSession"] = ["miBand3"=>0,"amazfitPace"=>0,"amazfitStratos"=>0,"bip"=>0];
    }
?>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <title>Amazonias - Tu web favorita de compras</title>
        <link rel="stylesheet" href="style.css">
        <script src="js.js"></script>
    </head>

    <body>
        <h1>Amazonias Shopping</h1>
        <img class="carrito" onclick="mostrarPanel();" src="media/carrito.png">
        <div id="panelCarrito">
            <?php
                if (isset($_POST["submit"])) {
                    $carritoCompra = $_SESSION["carritoCompraSession"];
                    $carritoCompra[$_POST["submit"]] = $carritoCompra[$_POST["submit"]] + 1;
                    $_SESSION["carritoCompraSession"] = $carritoCompra;
                    $total = 0;
                    foreach ($carritoCompra as $key => $value) {
                        $productos = $_SESSION["productos"];
                        $producto = $productos[$key];
                        echo "<p><strong>", $producto["nombre"],"</strong>, ", $value, " unidades. Total: ", $carritoCompra[$key] * $producto["precio"],"</p>";
                    }
                }
            ?>
            <button class="cerrarPanel" onclick="ocultarPanel();">Cerrar carro</button>
        </div>
        <div class="contenedor">
            <?php
                $i =0;
                $productos = $_SESSION["productos"];
                foreach ($productos as $key => $value) {
                    echo "<div class='producto'>";
                    echo "<h2>", $value["nombre"], "</h2>";
                    echo "<img class='fotoProducto' src='media/", $key, ".jpg'><br/>";
                    echo "<p>", $value["descripcion"], "</p>";
                    echo "<form action='index.php' method='POST'>
                        <button class='botonCompra' name='submit' type='submit' value='", $key, "'>Añadir al carrito</button>
                    </form>";
                    echo "</div>";
                    $i++;
                }
            ?>
        </div>
    </body>

</html>