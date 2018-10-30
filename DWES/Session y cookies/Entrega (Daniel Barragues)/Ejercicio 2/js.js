/* Mantiene el carrito abierto al recargar la página y quita o pone "No hay nada en tu carrito" cuando se añaden elementos o se compra */
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
    if (quitarRelleno == true || localStorage.getItem("quitarRelleno") == "true") {
        document.getElementById("relleno").style.display = "none";
        localStorage.setItem("quitarRelleno", true);
    } else {
        document.getElementById("relleno").style.display = "block";
    }
}

/* Borra todo lo guardado y guarda que no hay nada en el carrito */
function tramitarPed() {
    localStorage.clear();
    localStorage.setItem("quitarRelleno", false);
}