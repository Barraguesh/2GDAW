<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <title>Ejercicio 1</title>
    </head>

    <body>
        <?php
            echo "Numero / cuadrado / cubo<br/>";
            for ($i=0; $i < 20; $i++) {
                $numero[$i] = rand(0, 100);
                echo $numero[$i]," / ";
                $cuadrado[$i] = $numero[$i] ** 2;
                echo $cuadrado[$i]," / ";
                $cubo[$i] = $numero[$i] ** 3;
                echo $cubo[$i],"<br/>";
            }
        ?>
    </body>

</html>