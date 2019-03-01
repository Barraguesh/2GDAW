/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class Ejercicio7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Calcular hipotenusa.");
        String cateto1 = JOptionPane.showInputDialog(null, "Introduzca el primer cateto");
        String cateto2 = JOptionPane.showInputDialog(null, "Introduzca el segundo cateto");
        int cateto11 = Integer.parseInt(cateto1);
        int cateto22 = Integer.parseInt(cateto2);
        double hipotenusa = cateto11 * cateto11 + cateto22 * cateto22;
        hipotenusa = (double) Math.sqrt(hipotenusa);
        System.out.println("La hipotenusa es: " + hipotenusa);


    }
    
}
