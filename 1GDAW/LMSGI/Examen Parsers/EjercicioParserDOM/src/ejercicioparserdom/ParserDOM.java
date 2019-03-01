/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioparserdom;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author widemos
 */
public class ParserDOM {

    private List<CentroSalud> centros;

    private Document dom;

    public ParserDOM(List<CentroSalud> centros) {
        this.centros = centros;

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse("../centros-salud.xml");
        } catch (ParserConfigurationException | SAXException | IOException pce) {
            System.err.println("ERROR: No se ha podido procesar el archivo XML...");
        }

    }
    
    /**
     * Ejercicio 2
     *
     * Completar aquí el código para volcar el árbol DOM a objetos Java.
     */
    public void leerDatos() {
        Element raiz = dom.getDocumentElement();
        NodeList centrosaludE = raiz.getElementsByTagName("row");
        if(centrosaludE != null && centrosaludE.getLength() > 0){
            for(int i=0; i<centrosaludE.getLength(); i++){
                CentroSalud centrosaludO = getCentroSalud((Element) centrosaludE.item(i));
                centros.add(centrosaludO);
            }
        }     
    }
    
    private CentroSalud getCentroSalud(Element centroE) {
            CentroSalud centrosaludO;
            String nombre = "";
            String direccion = "";
            String cp = "";
            String localidad = "";
            String provincia = "";
            String servicios = "";
                      
            NodeList nombreE = centroE.getElementsByTagName("documentname");
            if (nombreE != null && nombreE.getLength() > 0){
                 nombre = nombreE.item(0).getTextContent();
            }
           
            NodeList direccionE = centroE.getElementsByTagName("sanidadstreet");
            if (direccionE != null && direccionE.getLength() > 0){
                 direccion = direccionE.item(0).getTextContent();
            }
            
            NodeList cpE = centroE.getElementsByTagName("sanidadpostalcode");
            if (cpE != null && cpE.getLength() > 0){
                 cp = cpE.item(0).getTextContent();
            }
            
            NodeList locE = centroE.getElementsByTagName("sanidadtown");
            if (locE != null && locE.getLength() > 0){
                 localidad = locE.item(0).getTextContent();
            }
            
            NodeList provE = centroE.getElementsByTagName("sanidadprovince");
            if (provE != null && provE.getLength() > 0){
                 provincia = provE.item(0).getTextContent();
            }
            
            NodeList servE = centroE.getElementsByTagName("sanidadservicewallet");
            if (servE != null && servE.getLength() > 0){
                 servicios = servE.item(0).getTextContent();
            }
           
           centrosaludO = new CentroSalud(nombre, direccion, cp, localidad, provincia, servicios);
           
           return centrosaludO;
    }

    private String getTextValue(Element ele, String tagName) {
        String textVal = null;

        NodeList nl = ele.getElementsByTagName(tagName);
        if (nl != null && nl.getLength() > 0) {
            Element el = (Element) nl.item(0);
            textVal = el.getFirstChild().getNodeValue();
        }

        return textVal;
    }

    
     /**
     * Ejercicio 3
     *
     * Completar aquí el código para añadir un nuevo CentroSalud al árbol
     * DOM.
     * @param cs
     */
    
    public void anyadirDatos(CentroSalud cs) {
        Element raiz = dom.getDocumentElement();
        Element centrosalud = crearElementoCentro(cs);
        raiz.appendChild(centrosalud);

    }

    private Element crearElementoCentro(CentroSalud cs) {
        Element CentroSaludE = dom.createElement("row");
        CentroSaludE.setAttribute("cod", "424");
        
        Element nombreE = dom.createElement("documentname");
        Text nombreT = dom.createTextNode(cs.getNombre());
        nombreE.appendChild(nombreT);
        CentroSaludE.appendChild(nombreE);
        
        Element direccionE = dom.createElement("sanidadstreet");
        Text direccionT = dom.createTextNode(cs.getDireccion());
        direccionE.appendChild(direccionT);
        CentroSaludE.appendChild(direccionE);
        
        Element cpE = dom.createElement("sanidadpostalcode");
        Text cpT = dom.createTextNode(cs.getCp());
        cpE.appendChild(cpT);
        CentroSaludE.appendChild(cpE);

        Element locE = dom.createElement("sanidadtown");
        Text locT = dom.createTextNode(cs.getLocalidad());
        locE.appendChild(locT);
        CentroSaludE.appendChild(locE);
        
        Element provE = dom.createElement("sanidadprovince");
        Text provT = dom.createTextNode(cs.getProvincia());
        provE.appendChild(provT);
        CentroSaludE.appendChild(provE);
        
        Element servE = dom.createElement("sanidadservicewallet");
        Text servT = dom.createTextNode(cs.getServicios());
        servE.appendChild(servT);
        CentroSaludE.appendChild(servE);
        
        return CentroSaludE;        
    }

    public void guardarFichero() {
        try {
            OutputFormat format = new OutputFormat(dom);
            format.setIndenting(true);
            XMLSerializer serializer = new XMLSerializer(new FileOutputStream(new File("../mis-centros-salud.xml")), format);
            serializer.serialize(dom);
        } catch (IOException ie) {
            System.err.println("ERROR: No se ha podido escribir el archivo XML...");
        }
    }

}