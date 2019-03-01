/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String base = JOptionPane.showInputDialog(null, "Introduce la base");
        String altura = JOptionPane.showInputDialog(null, "Introduce la altura");
        int Base = Integer.parseInt(base);
        int Altura = Integer.parseInt(altura);
        int resultado = 2 * Base + 2 * Altura;
        System.out.println("El perímetro de su triangulo es: " + resultado);

    }
    
}
