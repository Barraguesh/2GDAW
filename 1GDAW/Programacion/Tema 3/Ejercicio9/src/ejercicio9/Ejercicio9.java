/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio9;

import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class Ejercicio9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Calificacion nota");
        String nota = JOptionPane.showInputDialog(null, "Introduzca el primer cateto");
        double nota1 = Double.parseDouble(nota);
        if (nota1 < 5){ 
            if (nota1 < 4){
                System.out.println("Nota introducida: " + nota1 + ". Resultado Deficiente");
            }else{
                System.out.println("Nota introducida: " + nota1 + ". Resultado Insuficiente");
            }
        }else{
            if (nota1 >= 9) {
                System.out.println("Nota introducida: " + nota1 + ". Resultado Sobresaliente");
            }else{ 
                if (nota1 >= 7){ 
                    System.out.println("Nota introducida: " + nota1 + ". Resultado Notable");
                }else{
                    if (nota1 >= 6){
                        System.out.println("Nota introducida: " + nota1 + ". Resultado Bien");
                    }else{
                        System.out.println("Nota introducida: " + nota1 + ". Resultado Suficiente");
                    }   
                }
            }
        }
    }
    
}
