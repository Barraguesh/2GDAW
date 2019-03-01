/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class Ejercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String gradosC = JOptionPane.showInputDialog(null, "Introduzca la temperatura en grados celsius");
        int GradosC = Integer.parseInt(gradosC);
        double gradosF = 1.8 * GradosC + 32;
        System.out.println("La temperatura en grados farenheight es: " + gradosF);
    }
    
}
