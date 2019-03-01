/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String D = JOptionPane.showInputDialog(null, "Introduce la diagonal mayor del rombo");
        String d = JOptionPane.showInputDialog(null, "Introduce la diagonal menor");
        double D1 = Double.parseDouble(D);
        double d1 = Double.parseDouble(d);
        double resultado = D1 * d1 / 2;
        System.out.println("El área del rombo es: " + resultado);
    }
    
}
