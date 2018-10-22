<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <title>Ejercicio 1</title>
    </head>

    <body>

        <?php
            for ($i=0; $i < 100; $i++) {
                $cociente = $i / 5;
                $resto = $i - (5 * intval($cociente));
                if ($resto == 0) {
                    echo $i,"<br/>";
                }
            }
        ?>
    </body>

</html>