/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioparserdom;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author widemos
 */
public class EjercicioParserDOM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * Fuente de los datos: Open Data Euskadi
         * http://opendata.euskadi.eus/catalogo/-/centros-de-salud-publicos-en-euskadi/
         *
         */
        List<CentroSalud> lista = new ArrayList<>();

        ParserDOM parser = new ParserDOM(lista);

        parser.leerDatos();

        for (CentroSalud centroSalud : lista) {
            System.out.println(centroSalud);
        }

        CentroSalud nuevo = new CentroSalud(
                "Ficticio",
                "Calle Falsa 123",
                "00000",
                "Evergreen Terrace",
                "Springfield",
                "Se pueden hacer a la idea..."
        );

        parser.anyadirDatos(nuevo);

        parser.guardarFichero();

    }

}
