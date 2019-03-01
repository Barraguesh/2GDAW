<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <title>Ejercicio 12</title>
    </head>

    <body>
        <form action="Ejercicio 12.php" method="get">
            1. ¿Cuál es el lenguage más odiado?
            <select name="pregunta1">
                <option value="a">A) Java</option>
                <option value="b">B) JavaScript</option>
                <option value="c">C) PHP</option>
                <option value="d">D) JSON</option>
            </select><br />
            2. ¿Java influyó a JavaScript en el nombre?
            <select name="pregunta2">
                <option value="a">A) No</option>
                <option value="b">B) No, no pero le ayudo en la fama</option>
                <option value="c">C) Si</option>
                <option value="d">D) JavaScript y Java son iguales</option>
            </select><br />
            3. ¿Quien nos enseña JS?
            <select name="pregunta3">
                <option value="a">A) Nieves</option>
                <option value="b">B) Jon</option>
                <option value="c">C) Blanca</option>
                <option value="d">D) El Cristo colgado en la pared</option>
            </select><br />
            4. ¿Qué significa JS?
            <select name="pregunta4">
                <option value="a">A) Java</option>
                <option value="b">B) JavaScript</option>
                <option value="c">C) Node.js</option>
                <option value="d">D) JSON</option>
            </select><br />
            5. ¿Quién es el mejor programador?
            <select name="pregunta5">
                <option value="a">A) Todos</option>
                <option value="b">B) Ninguno</option>
                <option value="c">C) Alejandro, porque es su cumple</option>
                <option value="d">D) Alllah</option>
            </select><br />
            6. ¿En españa se programa mucho?
            <select name="pregunta6">
                <option value="a">A) Si, viva España</option>
                <option value="b">B) No, caca</option>
                <option value="c">C) Independentzia</option>
                <option value="d">D) 01001</option>
            </select><br />
            7. ¿Si JS es JavaScript, cuantos dedos tengo en la mano?
            <select name="pregunta7">
                <option value="a">A) 5</option>
                <option value="b">B) Casi 5</option>
                <option value="c">C) 6</option>
                <option value="d">D) 10</option>
            </select><br />
            8. ¿Allah es grande?
            <select name="pregunta8">
                <option value="a">A) Si</option>
                <option value="b">B) Allauh Bakbar</option>
                <option value="c">C) Puede</option>
                <option value="d">D) Seguramente</option>
            </select><br />
            9. ¿Este test ha perdido el sentido?
            <select name="pregunta9">
                <option value="a">A) Claro</option>
                <option value="b">B) Claro que si guapi</option>
                <option value="c">C) Por supuesto</option>
                <option value="d">D) Todas son correctas</option>
            </select><br />
            10. ¿Te alegras de haber acabado ya el test?
            <select name="pregunta10">
                <option value="a">A) No</option>
                <option value="b">B) Joder, si</option>
                <option value="c">C) Nope</option>
                <option value="d">D) No de no</option>
            </select><br /><br />
            <input type="submit" value="Corregir test">
        </form>
        <?php
        if (isset($_GET["pregunta1"])) {
            $nota = 0;
            $respUsu = [$_GET["pregunta1"], $_GET["pregunta2"], $_GET["pregunta3"], $_GET["pregunta4"], $_GET["pregunta5"], $_GET["pregunta6"], $_GET["pregunta7"], $_GET["pregunta8"], $_GET["pregunta9"], $_GET["pregunta10"]];
            $respuestas = ["a", "c", "a", "b", "a", "a", "d", "b", "b", "c"];
            for ($i=0; $i < 10; $i++) {
                if ($respuestas[$i] == $respUsu[$i]) {
                    $nota++;
                }
            }
            echo "<br/><br/>Nota: ", $nota;
        }
    ?>
    </body>

</html>