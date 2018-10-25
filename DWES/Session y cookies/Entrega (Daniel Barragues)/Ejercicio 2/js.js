function panelCarrito(abrir) {
    if (localStorage.getItem("carritoAbierto") == "true" || abrir == true) {
        document.getElementById("panelCarrito").classList.add("mostrarPanel");
        localStorage.setItem("carritoAbierto", true);
    } else {
        document.getElementById("panelCarrito").classList.remove("mostrarPanel");
        localStorage.setItem("carritoAbierto", false);
    }
}

function quitarRelleno() {
    document.getElementById("relleno").style.display = "none";
    localStorage.setItem("rellenoQuitado", true);
}

function ponerRelleno() {
    document.getElementById("relleno").style.display = "none";
    localStorage.setItem("rellenoQuitado", true);
}

window.close = function borrarLocal() {
    localStorage.clear();
}