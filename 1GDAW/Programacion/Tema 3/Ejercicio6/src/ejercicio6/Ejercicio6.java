/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6;

import static java.lang.Math.PI;
import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class Ejercicio6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String radio = JOptionPane.showInputDialog(null, "Introduzca el radio de su circunferencia");
        int Radio = Integer.parseInt(radio);
        double resultado = PI * Radio * Radio;
        System.out.println("El área es: " + resultado);
    }
    
}
