
package repasodom;

import java.util.ArrayList;
import java.util.List;

public class EjercicioRepasoDom {


    public static void main(String[] args) {

        //Cargar las listas con la información a volcar en el XML
        ArrayList<Coche> coches = new ArrayList<>();
        
        Coche c1 = new Coche("rojo", "Nissan", "Quasquai", 150);
        coches.add(c1);
        Coche c2 = new Coche("azul", "Renault", "Megane", 130);
        coches.add(c2);
        Coche c3 = new Coche("verde", "Citroen", "CX", 150);
        coches.add(c3);
        
        List<Concesionario> concesionarios = new ArrayList<>();
        Concesionario con1 = new Concesionario(1,"Lucera", "Iturribide", coches);
        concesionarios.add(con1);
        Concesionario con2 = new Concesionario(2,"Egibide", "Pozoa", coches);
        concesionarios.add(con2);
       
        RepasoDom parser = new RepasoDom(concesionarios);
        
        parser.crearFicheroXML();
        
        parser.guardarFichero();
        
        parser.leerDatos();

        Concesionario nuevo = new Concesionario(3, "Arriaga", "Alameda", coches);
        
        concesionarios.add(nuevo);

        parser.anyadirDatos(nuevo);
       
        parser.guardarFichero();
        
        parser.leerDatos();
       
        parser.eliminarElemento();
        
        parser.guardarFichero();

    }

}

