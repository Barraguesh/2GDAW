/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio15;

import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class Ejercicio15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int contadorAprobados = 0;
        
        System.out.println("Comparador de notas v1.0");
        
        String continuar = JOptionPane.showInputDialog(null, "¿Cuántos alumnos desea introducir?");
        int y = Integer.parseInt(continuar);
        
        for (int x = 0; x<y; x++){
            String nota = JOptionPane.showInputDialog(null, "Teclea la de un alumno.");
            int nota1 = Integer.parseInt(nota);
            if (nota1 >= 6){
                contadorAprobados++;
            }
                
        }
        
        System.out.println("Hay " + contadorAprobados + " aprobados.");
        
    }
    
}
