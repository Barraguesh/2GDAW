class Persona {
    //Constructores
    constructor() {}

    constructor(nombre, edad, DNI, sexo, peso, altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = 0;
        this.sexo = sexo;
        this.peso = 0;
        this.altura = 0;
    }

    constructor(nombre, edad, DNI, sexo, peso, altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = DNI;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    //Setters
    setNombre(nombre) {
        this.nombre = nombre;
    }

    setNombre(edad) {
        this.edad = edad;
    }

    setNombre(sexo) {
        this.sexo = sexo;
    }

    setNombre(peso) {
        this.peso = peso;
    }

    setNombre(altura) {
        this.altura = altura;
    }

    //Metodos
    calcularIMC() {
        var pesoMetros = this.peso / 100;
        var IMC = pesoMetros / Math.pow(this.altura, 2);
        if (IMC < 20) {
            return -1;
        } else if (IMC <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    esMayorEdad() {
        if (this.edad >= 18) {
            return true;
        }
    }

    comprobarSexo() {
        if (this.sexo != "H" || this.sexo != "M") {
            this.sexo = "H";
        }
    }

    toString() {
        
    }

    generaDNI() {

    }
}