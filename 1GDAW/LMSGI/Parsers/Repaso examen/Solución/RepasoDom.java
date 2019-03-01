
package repasodom;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class RepasoDom {

    private List<Concesionario> concesionarios;

    private Document dom;
    
    private int vControl;

    public RepasoDom(List<Concesionario> concesionarios) {
        this.concesionarios = concesionarios;
        
        vControl = 0;
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.newDocument();
            //dom = db.parse("../MiDocumento.xml");
        } catch (ParserConfigurationException pce) {
            System.err.println("ERROR: No se ha podido procesar el archivo XML...");
        }

    }

    public List<Concesionario> getConcesionarios() {
        return this.concesionarios;
    }

    public void crearFicheroXML(){
    
        Element raiz = dom.createElement("concesionarios");
        dom.appendChild(raiz);
        
        //A partir de un objeto de la clase Concesionario obtenemos un Elemento
        for (Concesionario concesionarioO : concesionarios) {
            Element concesionarioE = crearElementoConcesionario(concesionarioO);
            raiz.appendChild(concesionarioE);
        }
        
        
    
    };
    
    public void leerDatos() {
        
        Element raiz = dom.getDocumentElement();
        NodeList concesionariosE = raiz.getElementsByTagName("concesionario");
        
        if(concesionariosE != null && concesionariosE.getLength() > 0){
            for(int i=0; i>concesionariosE.getLength(); i++){
                Concesionario concesionarioO = getConcesionario((Element) concesionariosE.item(i));
                concesionarios.add(concesionarioO);
            }
        }
        for (Concesionario concesionario : concesionarios) {
            System.out.println(concesionario.toString());
        }
    }
    
        private Concesionario getConcesionario(Element concesionarioE) {
            
           Concesionario concesionarioO;
           Integer codigo;
           String nombre = "";
           String direccion = "";
           ArrayList<Coche> coches = new ArrayList<>();
           
           codigo = Integer.parseInt(concesionarioE.getAttribute("cod"));
           
           NodeList nombreE = concesionarioE.getElementsByTagName("nombre");
           if (nombreE != null && nombreE.getLength() > 0){
                nombre = nombreE.item(0).getTextContent();
            }
           
           NodeList direccionE = concesionarioE.getElementsByTagName("direccion");
           if (direccionE != null && direccionE.getLength() > 0){
                direccion = direccionE.item(0).getTextContent();
            }
           
           NodeList cochesE = concesionarioE.getElementsByTagName("coche");
           if (cochesE != null && cochesE.getLength() > 0){
               for (int x = 0; x < cochesE.getLength(); x++){
                   Coche cocheO = getCoche((Element) cochesE.item(x));
                   coches.add(cocheO);
               }
            }
           
           concesionarioO = new Concesionario(codigo, nombre, direccion, coches);
           
           return concesionarioO;
    }
        
            private Coche getCoche(Element cocheE) {
                Coche cocheO = new Coche();
                
                String color  = "";
                String marca = "";
                String modelo = "";
                Integer potencia = 0;
                
                color = cocheE.getAttribute("color");
                
                NodeList marcaE = cocheE.getElementsByTagName("marca");
                if (marcaE != null && marcaE.getLength() > 0){
                    marca = marcaE.item(0).getTextContent();
                }
                
                NodeList modeloE = cocheE.getElementsByTagName("modelo");
                if (modeloE != null && modeloE.getLength() > 0){
                    modelo = marcaE.item(0).getTextContent();
                    Element modeloEP = (Element) modeloE.item(0);
                    potencia = Integer.parseInt(modeloEP.getAttribute("potencia"));
                }
                
                cocheO = new Coche(color, marca, modelo, potencia);
                
                return cocheO;
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
    
    private Integer getIntValue(Element ele, String tagName){
    
        Integer i = Integer.parseInt(getTextValue(ele, tagName));
        return i;
    }

    public void anyadirDatos(Concesionario c) {
        
        Element raiz = dom.getDocumentElement();
        
        Element concesionario = crearElementoConcesionario(c);
        
        raiz.appendChild(concesionario);

    }

    private Element crearElementoConcesionario(Concesionario c) {
        Element concesionarioE = dom.createElement("concesionario");
        concesionarioE.setAttribute("cod", c.getCodigo().toString());
        
        Element nombreE = dom.createElement("nombre");
        Text nombreT = dom.createTextNode(c.getNombre());
        nombreE.appendChild(nombreT);
        concesionarioE.appendChild(nombreE);
        
        Element direccionE = dom.createElement("direccion");
        Text direccionT = dom.createTextNode(c.getDireccion());
        direccionE.appendChild(direccionT);
        concesionarioE.appendChild(direccionE);
        
        for (Coche cocheO: c.getCoches()){
            Element cocheE = crearElementoCoche(cocheO);
            concesionarioE.appendChild(cocheE);
        }

        return concesionarioE;
    }
    
        private Element crearElementoCoche(Coche cocheO) {
            Element cocheE = dom.createElement("coche");
            cocheE.setAttribute("color", cocheO.getColor());
            
            Element marcaE = dom.createElement("marca");
            Text marcaT = dom.createTextNode(cocheO.getMarca());
            marcaE.appendChild(marcaT);
            cocheE.appendChild(marcaE);
            
            Element modeloE = dom.createElement("modelo");
            modeloE.setAttribute("potencia", cocheO.getPotencia().toString());
            Text modeloT = dom.createTextNode(cocheO.getModelo());
            modeloE.appendChild(modeloT);
            cocheE.appendChild(modeloE);
            
            return cocheE;
    }
    
    public void eliminarElemento(){
        
        Element raiz = dom.getDocumentElement();
       /* Eliminar un concesionario
        NodeList nConcesionarios = raiz.getElementsByTagName("concesionario");
        if (nConcesionarios != null && nConcesionarios.getLength() > 0)
            for(int j = 0; j < nConcesionarios.getLength(); j++){
                Element concesionarioE = (Element) nConcesionarios.item(j);
                if(concesionarioE.getAttribute("cod").equalsIgnoreCase("2")){
                    raiz.removeChild(concesionarioE);
                }
            }
*/
       //Eliminar el coche de modelo megane del concesionario 2
       NodeList nConcesionarios = raiz.getElementsByTagName("concesionario");
        if (nConcesionarios != null && nConcesionarios.getLength() > 0)
            for(int j = 0; j < nConcesionarios.getLength(); j++){
                Element concesionarioE = (Element) nConcesionarios.item(j);
                if(concesionarioE.getAttribute("cod").equalsIgnoreCase("2")){
                    NodeList nCoches = concesionarioE.getElementsByTagName("coche");
                    if (nCoches != null && nCoches.getLength()>0){
                        for(int k = 0; k < nCoches.getLength(); k++){
                            Element cocheE = (Element) nCoches.item(k);
                            NodeList nModelo = cocheE.getElementsByTagName("modelo");
                            if (nModelo != null && nModelo.getLength()>0){
                                Element modeloE = (Element) nModelo.item(0);
                                if(modeloE.getTextContent().toString().equalsIgnoreCase("Megane"))
                                    concesionarioE.removeChild(cocheE);
                            }
                        }
                    }
                }
            }
        }

    public void guardarFichero() {
        try {
            OutputFormat format = new OutputFormat(dom);
            format.setIndenting(true);
            switch (vControl){
                case 0:{
                 XMLSerializer serializer = new XMLSerializer(new FileOutputStream(new File("../MiDocumento.xml")), format);
                 serializer.serialize(dom);
                 vControl++; 
                 break;
                }
                case 1:{
                 XMLSerializer serializer = new XMLSerializer(new FileOutputStream(new File("../MiDocumentoNuevo.xml")), format);
                 serializer.serialize(dom);
                 vControl++;
                 break;
                }
                case 2:{
                 XMLSerializer serializer = new XMLSerializer(new FileOutputStream(new File("../MiDocumentoModificado.xml")), format);
                 serializer.serialize(dom);
                 break;
                }
            }
        } catch (IOException ie) {
            System.err.println("ERROR: No se ha podido escribir el archivo XML...");
        }
    }




}
