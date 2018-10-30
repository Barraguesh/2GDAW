<!-- @Author: Daniel Barragues -->
<?php
    /* Inicia la sesion y guarda los productos en el array, tambien crea la sesion del carrito de compra y de favoritos */
    session_start();
    if (!isset($_SESSION["productos"])) {
        $miBand3 = [
            "id"=>001,
            "nombre"=>"Mi Band 3",
            "descripcion"=>"Ya está aquí la nueva pulsa de Xiaomi. Nuevo hardware, más batería y más precisa.",
            "precio"=>29];
        $amazfitPace = [
            "id"=>002,
            "nombre"=>"Amazfit Pace",
            "descripcion"=>"Para corredores natos. El mejor SmartWatch de la mejor compañía.",
            "precio"=>110];
        $amazfitStratos = [
            "id"=>003,
            "nombre"=>"Amazfit Stratos",
            "descripcion"=>"Si pides un diseño más premium, más precisión y estimación de VO2 este SmartWatch es para tí.",
            "precio"=>140];
        $bip = [
            "id"=>004,
            "nombre"=>"Bip",
            "descripcion"=>"¿Necesitas una batería que dura más de 1 mes, GPS y un monitor de actividad? Esta pulsera es para tí.",
            "precio"=>80];
        $_SESSION["productos"] = [
            "miBand3"=>$miBand3,
            "amazfitPace"=>$amazfitPace,
            "amazfitStratos"=>$amazfitStratos,
            "bip"=>$bip];
    }
    if (!isset($_SESSION["carritoCompraSession"])) {
        $_SESSION["carritoCompraSession"] = [
            "miBand3"=>0,
            "amazfitPace"=>0,
            "amazfitStratos"=>0,
            "bip"=>0];
    }
    if (!isset($_SESSION["favoritos"])) {
        $_SESSION["favoritos"] = [];
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
        <img class="carrito" onclick="panelCarrito(true)" src="media/carrito.png">
        <div class="panelCarrito" id="panelCarrito">
            <p id="relleno">No hay nada en tu carrito</p>
            <?php
                /* Añade al carrito los productos comprados e imprime los que hay en el carrito si hay más de 0 unidades */
                if (isset($_POST["submit"])) {
                    $carritoCompra = $_SESSION["carritoCompraSession"];
                    $carritoCompra[$_POST["submit"]] = $carritoCompra[$_POST["submit"]] + 1;
                    $_SESSION["carritoCompraSession"] = $carritoCompra;
                    $total = 0;
                    foreach ($carritoCompra as $key => $value) {
                        if ($value > 0) {
                            $productos = $_SESSION["productos"];
                            $producto = $productos[$key];
                            echo "<p><strong>", $producto["nombre"],"</strong>, <span id='unidadesProducto'>", $value, "</span> unidades. Total: ", $carritoCompra[$key] * $producto["precio"],"€</p>";
                            $total = $total + $carritoCompra[$key] * $producto["precio"];
                        }
                    }
                    echo "<br/>Total: ", $total,"€";
                }
            ?>
            <br /><br />
            <button class="btnCerrarPanel" onclick="panelCarrito(false)">Cerrar carro</button>
            <form action="index.php" method="post">
                <button class="btnTramitarPedido" type="submit" name="tramitarPedido" onclick="tramitarPedido()">Tramitar pedido</button>
            </form>
            <?php
                if (isset($_POST["tramitarPedido"])) {
                    unset($_SESSION["carritoCompraSession"]);
                }
            ?>
        </div>
        <div class="favoritos">
            <?php
                /* Añade a favoritos si no existe ese mismo producto en favoritos */
                if (isset($_POST["favorito"])) {
                    $contador = 0;
                    foreach ($_SESSION["favoritos"] as $key) {
                        if($_POST["favorito"] == $key) {
                            $contador++;
                        }
                    }
                    if ($contador < 1) {
                        array_push($_SESSION["favoritos"], $_POST["favorito"]); 
                        echo "Añadido a favoritos<br/>";
                        echo "En favoritos esta: ", print_r($_SESSION["favoritos"]);
                    }
                }
            ?>
        </div>
        <div class="contenedor">
            <?php
                /* Imprime todos los productos guardados en el array productos de sesion */
                $i =0;
                $productos = $_SESSION["productos"];
                foreach ($productos as $key => $value) {
                    echo "<div class='producto'>";
                    echo "<h2>", $value["nombre"], "</h2>";
                    echo "<img class='fotoProducto' src='media/", $key, ".jpg'><br/>";
                    echo "<p>", $value["descripcion"], "</p>";
                    echo "<form action='index.php' method='POST'>
                            <button class='botonCompra' onclick='panelCarrito(null,null,true)' name='submit' type='submit' value='", $key, "'>Añadir al carrito</button>
                        </form>";
                        echo "<form action='index.php' method='POST'>
                                <button class='botonFavoritos' name='favorito' type='submit' value='", $key, "'>Añadir a favoritos</button>
                            </form>";
                    echo "</div>";
                    $i++;
                }
            ?>
        </div>
    </body>
    <script>
        window.onload = function mantenerCarrito() {
            panelCarrito(false, true);
        }
    </script>

</html>