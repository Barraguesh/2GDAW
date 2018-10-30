function panelCarrito(abrir, recarga, quitarRelleno) {
    if (localStorage.getItem("carritoAbierto") == "true") {
        document.getElementById("panelCarrito").classList.add("mostrarPanel");
        localStorage.setItem("carritoAbierto", true);
    } else if (abrir == true) {
        document.getElementById("panelCarrito").classList.add("mostrarPanel");
        localStorage.setItem("carritoAbierto", true);
    }
    if (abrir == false && recarga != true) {
        document.getElementById("panelCarrito").classList.remove("mostrarPanel");
        localStorage.setItem("carritoAbierto", false);
    }
    if (quitarRelleno == true && localStorage.getItem("quitarRelleno") == "true") {
        document.getElementById("relleno").style.display = "none";
        localStorage.setItem("quitarRelleno", true);
    } else {
        document.getElementById("relleno").style.display = "block";
    }
}

function tramitarPedido() {
    localStorage.clear();
    localStorage.setItem("quitarRelleno", false);
}