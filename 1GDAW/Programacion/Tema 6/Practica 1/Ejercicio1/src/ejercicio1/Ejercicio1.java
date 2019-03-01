    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class Ejercicio1 {
    /**4
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
        float radio = Float.parseFloat(JOptionPane.showInputDialog(null, "Introduce el radio"));
        float longitud = Longitud(radio);
        float area = Area(radio);
        float volumen = Volumen(radio);
        String resultado = "La longitud de la circunferencia del radio introducido es " + longitud + "\n" + "El área de la circunferencia del radio introducido es " + area + "\n" + "La longitud de la circunferencia del radio introducido es " + volumen;
        JOptionPane.showMessageDialog(null, resultado);
        }
        catch(Exception x){
            JOptionPane.showMessageDialog(null, "Dato introducido incorrecto, introduzca números.");
        }  
    }
    public static float Longitud(float radio) {
        float longitud = (float) (2 * Math.PI * radio);
        return longitud;
    }  
    public static float Area(float radio){
        float area = (float) (Math.PI * radio * radio);
        return area;
    }
    public static float Volumen(float radio){
        float volumen = (float) (4 * Math.PI * radio * radio * radio/3);
        return volumen;
    }  
}
