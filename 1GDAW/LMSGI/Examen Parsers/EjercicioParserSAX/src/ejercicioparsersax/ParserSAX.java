/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioparsersax;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author widemos
 */
public class ParserSAX extends DefaultHandler {

    private List<CentroSalud> centros;

    private String tempVal;
    //Creamos el objeto para todo el parser
    CentroSalud cs = new CentroSalud();
    
    public ParserSAX(List<CentroSalud> centros) {
        this.centros = centros;
    }
    
    /**
     * Ejercicio 1
     *
     * Completar aquí el código de los eventos para volcar el XML a objetos
     * Java.
     * @throws org.xml.sax.SAXException
     */

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tempVal="";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        tempVal = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("row")){
            if (cs.getServicios() == null){
                cs.setServicios("El centro de salud no tiene servicios");
            }
            if (cs.getProvincia()== null){
                cs.setProvincia("El centro de salud no se encuentra en una provincia");
            }
            centros.add(cs);
            cs = new CentroSalud();
        } else if (qName.equalsIgnoreCase("documentname")) {
            cs.setNombre(tempVal);
        } else if (qName.equalsIgnoreCase("sanidadstreet")){
            cs.setDireccion(tempVal);
        } else if (qName.equalsIgnoreCase("sanidadpostalcode")){
            cs.setCp(tempVal);
        } else if (qName.equalsIgnoreCase("sanidadtown")){
            cs.setLocalidad(tempVal);
        } else if (qName.equalsIgnoreCase("sanidadprovince")){
            cs.setProvincia(tempVal);
        } else if (qName.equalsIgnoreCase("sanidadservicewallet")){
            cs.setServicios(tempVal);
        }
    }
}