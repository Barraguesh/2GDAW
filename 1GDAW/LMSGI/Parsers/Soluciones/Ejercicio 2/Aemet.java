package ejemploparsers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;

public class Aemet extends DefaultHandler {

    private List prediccion;
    private String contenido;
    private Dia dia;
    private ArrayList<Periodo> periodos;
    //private Periodo[] periodos;
    private int vControl;
    //private int nPeriodos;
    private String codTemp;
    private String tempSensHum;
    private String descEC;


    public Aemet() {
        prediccion = new ArrayList();
    }
    
    public static void main(String[] args) {

        System.out.println("Ejercicio 2");
        System.out.println("---");

        Aemet a = new Aemet();
        a.ejecutar();
    }

    public void ejecutar() {
        parsearDocumento();
        imprimirDocumento();
    }

    private void parsearDocumento() {

        //creamos una factoría de parsers SAX
        SAXParserFactory spf = SAXParserFactory.newInstance();

        try {

            //instanciamos un nuevo parser SAX a partir de la factroría
            SAXParser sp = spf.newSAXParser();

            //parseamos el fichero xml y enviamos la clase para los call backs
            sp.parse("../aemet.xml", this);

        } catch (SAXException se) {
            se.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    /**
     * Iteramos a través de la lista y mostramos la información por pantalla
     */
    private void imprimirDocumento() {

        System.out.println("Número de días recogidos en la predicción: '" + prediccion.size() + "'.");

        Iterator it = prediccion.iterator();
        while (it.hasNext()) {
            dia = (Dia) it.next();
            System.out.println(dia.toString());
        }
    }

    //Event Handlers
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //inicializamos
        contenido = "";
        if (qName.equalsIgnoreCase("dia")) {
            //creamos un objeto Dia y guardamos su atributo fecha
            dia = new Dia();
            dia.setFecha(attributes.getValue("fecha"));
            vControl = 0;
            //nPeriodos = 0;
            periodos = new ArrayList<Periodo>();
        }
        else if (qName.equalsIgnoreCase("prob_precipitacion")) {
            //nPeriodos += 1;
            codTemp = attributes.getValue("periodo");
            //creamos objetos Periodo
            if (!(codTemp == null)){
                switch(codTemp){
                    case "00-24":{
                        vControl = 0;
                        break;
                    }
                    case "00-12":{
                        vControl = 1;
                        break;
                    }
                    case "12-24":{
                        vControl = 2;
                        break;
                    }
                    case "00-06":{
                        vControl = 3;
                        break;
                    }
                    case "06-12":{
                        vControl = 4;
                        break;
                    }
                    case "12-18":{
                        vControl = 5;              
                        break;
                    }
                    case "18-24":{
                        vControl = 6;                
                        break;
                    }
                }
            } else {
                codTemp = "00-24";
            }
            periodos.add(new Periodo());
            periodos.get(vControl).setCodigo(codTemp);
            //periodos[vControl] = new Periodo();
            //periodos[vControl].setCodigo(codTemp);
        }
        else if (((qName.equalsIgnoreCase("cota_nieve_prov"))||(qName.equalsIgnoreCase("estado_cielo"))||(qName.equalsIgnoreCase("viento"))||(qName.equalsIgnoreCase("racha_max")))) {
            if(qName.equalsIgnoreCase("estado_cielo"))
                if(attributes.getValue("descripcion").equalsIgnoreCase(""))
                    descEC = "Sin descripción";
                else
                    descEC = attributes.getValue("descripcion");  
            codTemp = attributes.getValue("periodo");
            if (!(codTemp == null)){
                switch(codTemp){
                    case "00-24":{
                        vControl = 0;
                        break;
                    }
                    case "00-12":{
                        vControl = 1;
                        break;
                    }
                    case "12-24":{
                        vControl = 2;
                        break;
                    }
                    case "00-06":{
                        vControl = 3;
                        break;
                    }
                    case "06-12":{
                        vControl = 4;
                        break;
                    }
                    case "12-18":{
                        vControl = 5;              
                        break;
                    }
                    case "18-24":{
                        vControl = 6;                
                        break;
                    }
                }  
            }
        } else if (qName.equalsIgnoreCase("temperatura")){
            tempSensHum = "temp";
        } else if (qName.equalsIgnoreCase("sens_termica")){
            tempSensHum = "sens"; 
        } else if (qName.equalsIgnoreCase("humedad_relativa")){
            tempSensHum = "hum";
        } else if (qName.equalsIgnoreCase("dato")) {
            switch (attributes.getValue("hora")) {
                case "06":{
                    vControl = 3;
                    break;
                }
                case "12":{
                    vControl = 4;
                    break;
                }case "18":{
                    vControl = 5;
                    break;
                }case "24":{
                    vControl = 6;
                    break;
                }
            }
        }
    }


    public void characters(char[] ch, int start, int length) throws SAXException {
        contenido = new String(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("dia")) {
            //Previsión para el día completa añadimos el día a la lista
            prediccion.add(dia);
        } else if (qName.equalsIgnoreCase("prob_precipitacion")) {
            if (contenido.equalsIgnoreCase(""))
                contenido = "0";
            periodos.get(vControl).setPrecipitacion(Integer.parseInt(contenido));
            //periodos[vControl].setPrecipitacion(Integer.parseInt(contenido));
        } else if (qName.equalsIgnoreCase("cota_nieve_prov")) {
            if (contenido.equalsIgnoreCase(""))
                contenido = "0";
            periodos.get(vControl).setCotaNieve(Integer.parseInt(contenido));
            //periodos[vControl].setCotaNieve(Integer.parseInt(contenido));
        } else if (qName.equalsIgnoreCase("estado_cielo")) {
            if (contenido.equalsIgnoreCase(""))
                contenido = "0";
            periodos.get(vControl).setDescEstadoCielo(descEC);
            periodos.get(vControl).setEstadoCielo(contenido);
            //periodos[vControl].setDescEstadoCielo(descEC);
            //periodos[vControl].setEstadoCielo(contenido);
        } else if (qName.equalsIgnoreCase("direccion")) {
            periodos.get(vControl).setDirViento(contenido);
            //periodos[vControl].setDirViento(contenido);
        } else if (qName.equalsIgnoreCase("velocidad")) {
            if (contenido.equalsIgnoreCase(""))
                contenido = "0";
            periodos.get(vControl).setVelViento(Integer.parseInt(contenido));
            //periodos[vControl].setVelViento(Integer.parseInt(contenido));
        } else if (qName.equalsIgnoreCase("racha_max")) {
            if (contenido.equalsIgnoreCase(""))
                contenido = "0";
            periodos.get(vControl).setRachaMax(Integer.parseInt(contenido));
            //periodos[vControl].setRachaMax(Integer.parseInt(contenido));
        } else if (qName.equalsIgnoreCase("maxima")){
            if(tempSensHum.equalsIgnoreCase("temp"))
               dia.setTempMax(Integer.parseInt(contenido));
            else if (tempSensHum.equalsIgnoreCase("sens"))
               dia.setSensTermMax(Integer.parseInt(contenido));
            else
               dia.setHumMax(Integer.parseInt(contenido));
        } else if (qName.equalsIgnoreCase("minima")){
            if(tempSensHum.equalsIgnoreCase("temp"))
               dia.setTempMin(Integer.parseInt(contenido));
            else if (tempSensHum.equalsIgnoreCase("sens"))
               dia.setSensTermMin(Integer.parseInt(contenido));
            else
               dia.setHumMin(Integer.parseInt(contenido));
        } else if (qName.equalsIgnoreCase("dato")) {
            if (contenido.equalsIgnoreCase(""))
                contenido = "0";
            if(tempSensHum.equalsIgnoreCase("temp"))
                periodos.get(vControl).setTempPeriodo(Integer.parseInt(contenido));
                //periodos[vControl].setTempPeriodo(Integer.parseInt(contenido));
            else if (tempSensHum.equalsIgnoreCase("sens"))
                periodos.get(vControl).setSensTermPeriodo(Integer.parseInt(contenido));
                //periodos[vControl].setSensTermPeriodo(Integer.parseInt(contenido));
            else
                periodos.get(vControl).setHumRelPeriodo(Integer.parseInt(contenido));
                //periodos[vControl].setHumRelPeriodo(Integer.parseInt(contenido));
        } else if (qName.equalsIgnoreCase("humedad_relativa")){
            //Fin de periodos, los almacenamos en el día
            /*for (int i=0; i < nPeriodos; i++){
                dia.getPeriodos().add(periodos[i]);
            }*/
            Iterator it = periodos.iterator();
            while (it.hasNext()) {
                dia.getPeriodos().add((Periodo) it.next());
            }
        } 
        else if (qName.equalsIgnoreCase("uv_max")){
            dia.setUvMax(Integer.parseInt(contenido));
        } 
    }
}