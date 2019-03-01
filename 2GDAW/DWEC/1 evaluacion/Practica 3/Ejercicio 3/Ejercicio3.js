function GuardarDatos() {
    localStorage.setItem("Nombre",document.getElementById("name").value.toString());
    localStorage.setItem("Color",document.getElementById("color").value.toString());
    localStorage.setItem("Provincia",document.getElementById("provincia").value.toString());
    alert("Ya sabemos quien eres, sal de la web y vuelve a entrar, rellenaremos las cajas por ti");
}

function ExposeDatos(){
    document.getElementById("name").value = localStorage.getItem("Nombre");
    document.getElementById("color").value = localStorage.getItem("Color");
    document.getElementById("provincia").value = localStorage.getItem("Provincia");
}
