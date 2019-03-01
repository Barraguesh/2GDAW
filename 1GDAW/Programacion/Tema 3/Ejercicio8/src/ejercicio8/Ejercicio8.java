/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio8;

import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class Ejercicio8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Convertidor nota");
        String nota = JOptionPane.showInputDialog(null, "Introduzca la nota");
        double nota1 = Double.parseDouble(nota);
        if (nota1 < 5) {
            System.out.println("Suspenso");
        }
        else{
            System.out.println("Aprobado");
        }
    }
    
}
