/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio11;

import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class Ejercicio11 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Numero mayor y menor v1.0");
        String numero1 = JOptionPane.showInputDialog(null, "Introduce un número");
        int numero11 = Integer.parseInt(numero1);
        String numero2 = JOptionPane.showInputDialog(null, "Introduce otro numero");
        int numero22 = Integer.parseInt(numero2);
        String numero3 = JOptionPane.showInputDialog(null, "Introduce un último número");
        int numero33 = Integer.parseInt(numero3);
        
        if  (numero11 > numero22 && numero11 > numero33){
            if (numero22 > numero33){
                System.out.println("El número mayor es: " + numero11 + " y el menor: " + numero33);
            } else {
                System.out.println("El número mayor es: " + numero11 + " y el menor: " + numero22);                
            }
        }
        if (numero22 > numero11 && numero22 > numero33){
            if (numero11 > numero33){
                System.out.println("El número mayor es: " + numero22 + " y el menor: " + numero33);
            } else {
                System.out.println("El número mayor es: " + numero22 + " y el menor: " + numero11);                
            }
        }
        if (numero33 > numero11 && numero33 > numero22){
            if (numero11 > numero22){
                System.out.println("El número mayor es: " + numero33 + " y el menor: " + numero22);
            } else {
                System.out.println("El número mayor es: " + numero33 + " y el menor: " + numero11
                );                
            }
        }
    }
    
}
