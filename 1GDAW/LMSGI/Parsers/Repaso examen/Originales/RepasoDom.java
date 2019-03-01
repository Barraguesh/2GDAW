
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

/**
 *
 * @author widemos
 */
public class RepasoDom {

    private List<MiClase> clase;

    private Document dom;
    
    private int vControl;

    public RepasoDom(List<MiClase> clase) {
        this.clase = clase;
        
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

    public void crearFicheroXML(){
    
    
    };
    
    public void leerDatos() {

        
        
    }
    
        private MiClase getClase(Element claseE) {
        
           
            
            MiClase claseO = new MiClase();
           
           return claseO;
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

    public void anyadirDatos(MiClase c) {


    }

    private Element crearElementoCentro(MiClase c) {

        Element cE = dom.createElement("");
        return cE;

    }
    
    public void eliminarElemento(){
        
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
