/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio12;

import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class Ejercicio12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Calcular consumo v1.0");
        double importe = 0;
        String consumo = JOptionPane.showInputDialog(null, "Teclea tu consumo mensual");
        int consumo1 = Integer.parseInt(consumo);
        
        if (consumo1 < 300){
            importe = consumo1 * 0.04;
        } else {
            if (consumo1 > 500){
                importe = 300 * 0.03 + (consumo1 - 300) * 0.02;
                if (consumo1 > 800){
                    importe = importe - importe * 1.25/100;
                }
            } else { 
                importe = consumo1 * 0.03;
            }
        }
        System.out.println("Su importe a abonar es: " + importe + "$");
    }
    
}
