<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <title>Ejercicio 2</title>
    </head>

    <body>

        <?php
            $i = 0;
            while ($i < 100) {
                $cociente = $i / 5;
                $resto = $i - (5 * intval($cociente));
                if ($resto == 0) {
                    echo $i,"<br/>";
                }
                $i++;
            }
        ?>
    </body>

</html>