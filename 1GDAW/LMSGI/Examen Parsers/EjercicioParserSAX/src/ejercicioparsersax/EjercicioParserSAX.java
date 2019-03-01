/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioparsersax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author widemos
 */
public class EjercicioParserSAX {

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

        SAXParserFactory spf = SAXParserFactory.newInstance();

        try {
            SAXParser sp = spf.newSAXParser();
            sp.parse("../centros-salud.xml", new ParserSAX(lista));
        } catch (SAXException | ParserConfigurationException | IOException se) {
            System.err.println("ERROR: No se ha podido procesar el archivo XML...");
        }

        for (CentroSalud centroSalud : lista) {
            System.out.println(centroSalud);
        }

    }

}
