<!-- @Author: Daniel Barragues -->
<?php
    session_start();
    if (!isset($_SESSION["login"])) {
        $_SESSION["login"] = false;
    }
    if (!isset($_SESSION["nombreUsuario"])) {
        $_SESSION["nombreUsuario"] = null;
    }
    if (!isset($_SESSION["contador"])) {
        $_SESSION["contador"] = 0;
    }
    if (!isset($_SESSION["verificacion"])) {
        $_SESSION["verificacion"] = true;
    }

    if ($_SESSION["login"] == true) {
        header('Location: ./cuenta.php');
    } else {
        if ($_SESSION["contador"] > 1) {
            header('Location: ../html/bloqueado.html');
        } else {
            $_SESSION["contador"]++;

            $diccionario = ["admin"=>"admin", "Daniel"=>"12345Abcde", "Mikel"=>"12345Abcde"];

            if (isset($_POST["user"]) && isset($_POST["password"])) {
                $usuario = $_POST["user"];
                $password = $_POST["password"];

                foreach ($diccionario as $usu => $contraseña) {
                    if ($usuario == $usu && $password == $contraseña) {
                        $_SESSION["login"] = true;
                        $_SESSION["nombreUsuario"] = $usu;
                        header('Location: ./cuenta.php');
                        die();
                    }
                }
                header('Location: ../index.html');
            }
        }
    }
