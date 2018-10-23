window.onload = function rellenarCampos() {
    let elemento = document.getElementById("usuario");
    elemento.value = "Usuario";
    elemento = document.getElementById("password");
    elemento.value = "Password";
}

function borrarCampos(elementoId) {
    let elemento = document.getElementById(elementoId);
    elemento.value = "";
}

function bloqueado() {
    window.close();
}