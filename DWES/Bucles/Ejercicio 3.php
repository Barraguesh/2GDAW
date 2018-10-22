<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <title>Ejercicio 3</title>
    </head>

    <body>

        <?php
            $i = 0;
            do {
                $cociente = $i / 5;
                $resto = $i - (5 * intval($cociente));
                if ($resto == 0) {
                    echo $i,"<br/>";
                }
                $i++;
            } while ($i < 100)
        ?>
    </body>

</html>