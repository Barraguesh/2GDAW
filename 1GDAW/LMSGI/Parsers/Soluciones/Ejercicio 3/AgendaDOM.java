
package ejemploparsers;

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

public class AgendaDOM {
    List misContactos;
    Document dom;
    
    //Constructor
    AgendaDOM(){
    
        misContactos = new ArrayList();
        
        cargarContactos();
        
    }
    
    public void ejecutar() {
        System.out.println("Comenzando... ");
        //Volcamos el fichero xml en memoria como arbol de DOM
        parsearFicheroXML();
        //Creamos los elementos y los agregamos al arbol de DOM
        crearArbolDOM();
        //Escribimos el arbol DOM en el fichero XML
        escribirFicheroXML();
        System.out.println("Fichero modificado correctamente...");
    }

    private void escribirFicheroXML() {

        try {
            //Configuramos el formato de salida del fichero
            OutputFormat format = new OutputFormat(dom);
            format.setIndenting(true);

            //to generate a file output use fileoutputstream instead of system.out
            XMLSerializer serializer = new XMLSerializer(
                    new FileOutputStream(new File("../agenda.xml")), format);

            serializer.serialize(dom);

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
    
private void crearArbolDOM() {

        //Cogemos la referencia al elemento raiz <agenda>
        Element raizAgenda = dom.getDocumentElement();

        //Recorremos los contactos del arrayList y los convertimos en elementos
        //DOM y los agregamos a la raiz <agenda>
        Iterator it = misContactos.iterator();
        while (it.hasNext()) {
            Contacto c = (Contacto) it.next();
            //Obtenemos la información y la pegamos para cada uno de los contactos
            Element contactoEle = crearElementoContacto(c);
            raizAgenda.appendChild(contactoEle);
        }

    }

    private Element crearElementoContacto(Contacto c) {

        Element contactoEle = dom.createElement("contacto");

        //Crear elemento nombre y su texto, luego lo asociamos al elemento contacto
        Element nomEle = dom.createElement("nombre");
        Text nomText = dom.createTextNode(c.getNombre());
        nomEle.appendChild(nomText);
        contactoEle.appendChild(nomEle);

        //Crear elemento apellido y su texto, luego lo asociamos al elemento contacto
        Element apeEle = dom.createElement("apellidos");
        Text apeText = dom.createTextNode(c.getApellidos());
        apeEle.appendChild(apeText);
        contactoEle.appendChild(apeEle);
        
        //Crear elemento email y su texto, luego lo asociamos al elemento contacto
        Element emailEle = dom.createElement("email");
        Text emailText = dom.createTextNode(c.getEmail());
        emailEle.appendChild(emailText);
        contactoEle.appendChild(emailEle);
        
        //Crear elemento telefono y su texto, luego lo asociamos al elemento contacto
        Element telEle = dom.createElement("telefono");
        Text telText = dom.createTextNode(c.getTelefono());
        telEle.appendChild(telText);
        contactoEle.appendChild(telEle);

        return contactoEle;

    }
    
    private void parsearFicheroXML() {
        //Creamos el DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            //Using factory get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();

            //parse using builder to get DOM representation of the XML file
            dom = db.parse("../agenda.xml");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    private void cargarContactos() {
        misContactos.add(new Contacto("Marcos", "Garcia de Godos", "mgarciadegodos@egibide.org", "652453214"));        
        misContactos.add(new Contacto("Laura", "Navarro Garces", "lnavarro@egibide.org", "658475214"));
    }
    
    public static void main(String args[]) {

        //create an instance
        AgendaDOM agenda = new AgendaDOM();

        //run the example
        agenda.ejecutar();
    }
    
    
}
