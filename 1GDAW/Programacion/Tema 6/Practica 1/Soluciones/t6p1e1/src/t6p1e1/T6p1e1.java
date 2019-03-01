
package t6p1e1;

import Modelo.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import Excepciones.*;

public class T6p1e1 {

    public static void main(String[] args) {
        
        /* De momento el método main se encarga de la entrada/salida de datos y
           de crear objetos.*/
        try
        {
            // Entrada
            double r = Double.parseDouble(JOptionPane.showInputDialog("Teclea el radio de la circunferencia"));
            if ( r <= 0)
                throw new DatoNoValido();
            
            // Creación
            Circunferencia c = new Circunferencia();
            c.setRadio(r);
            //  Circunferencia c = new Circunferencia(r);

            // Salida
            DecimalFormat df = new DecimalFormat("#.00");
            JOptionPane.showMessageDialog(null, "Los datos de la circunferencia con radio: " + c.getRadio() + " son:" +
                    "\n\n Longitud: " + df.format(c.getLongitud()) + 
                    "\n Area: " + df.format(c.getArea())+
                    "\n Volumen: " + c.getVolumen());
        }
        catch(NumberFormatException e)
        {
            System.out.println("Problemas, el dato no es numérico");
        }
        catch(DatoNoValido e)
        {
            System.out.println("Problemas, el dato es menor o igual que cero");
        }
        catch(Exception e)
        {
            System.out.println("Problemas " + e.getMessage());
        }
    }
    
}
