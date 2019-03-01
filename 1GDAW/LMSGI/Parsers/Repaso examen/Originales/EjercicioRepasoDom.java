
package repasodom;

import java.util.ArrayList;
import java.util.List;

public class EjercicioRepasoDom {


    public static void main(String[] args) {

        List<MiClase> lista = new ArrayList<>();

        RepasoDom parser = new RepasoDom(lista);
        
        parser.crearFicheroXML();
        
        parser.guardarFichero();
        
        parser.leerDatos();

        for (MiClase clase : lista) {
            System.out.println(clase);
        }

        MiClase nuevo = new MiClase();

        parser.anyadirDatos(nuevo);

        parser.guardarFichero();
        
        parser.eliminarElemento();
        
        parser.guardarFichero();

    }

}

