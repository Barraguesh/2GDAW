<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <title>Ejercicio 4</title>
    </head>

    <body>
        <?php
            for ($i=0; $i < 100; $i++) {
                $numeros[$i] = rand(0, 20);
                echo $numeros[$i]," ";
            }
            echo "<br/ >";
        ?>
        <form action="Ejercicio 4.php" method="get">
            <input type="text" name="numero" /><br />
            <input type="submit" value="Guardar numero"/ >
        </form>
    </body>

</html>