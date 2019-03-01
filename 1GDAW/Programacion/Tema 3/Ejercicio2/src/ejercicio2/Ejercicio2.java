/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class Ejercicio2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String numero1 = JOptionPane.showInputDialog(null, "Introduce un numero");
        String numero2 = JOptionPane.showInputDialog(null, "Introduce un segundo numero");
        int Numero1 = Integer.parseInt(numero1);
        int Numero2 = Integer.parseInt(numero2);
        int resultado = Numero1 + Numero2;
        System.out.println("La suma es: " + resultado);
        
    }
    
}
