/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio13;

import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class Ejercicio13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int apto;
        int contadorAptos = 0;
        int contadorNoAptos = 0;
        String sexo1 = "niño";       
        System.out.println("Comparador baloncesto v1.0");
        for (int x = 0; x<5; x++){
            String nombre = JOptionPane.showInputDialog(null, "Teclea el nombre del candidato");
            String peso = JOptionPane.showInputDialog(null, "Teclea el peso del candidato ");
            int peso1 = Integer.parseInt(peso);
            String estatura = JOptionPane.showInputDialog(null, "Teclea la estatura del candidato en cm");
            int estatura1 = Integer.parseInt(estatura);
            String edad = JOptionPane.showInputDialog(null, "Teclea la edad del candidato");
            String sexo = JOptionPane.showInputDialog(null, "Indica si es niño o niña");
            if (sexo.equals(sexo1))
                apto = ComparadorChico(peso1, estatura1);
            else 
                apto = ComparadorChica(peso1, estatura1);
            if (apto == 1){
                System.out.println(nombre + " de " + edad + " años, es un candidato apto.");
                contadorAptos++;
            }else{
                System.out.println(nombre + " de " + edad + " años, no es un candidato apto.");
                contadorNoAptos++;
            }
        }
        System.out.println("Hay " + contadorAptos + " aptos.");
        System.out.println("Hay " + contadorNoAptos + " no aptos.");
    }
    public static int ComparadorChico(int peso1, int estatura1) {
        int apto = 0;
        if (estatura1 > 1.7 && peso1 > 70)
            apto = 1;
        return apto;
    }    
    public static int ComparadorChica(int peso1, int estatura1){
        int apto = 0;
        if (estatura1 > 160 && peso1 > 60)
            apto = 1;
        return apto;
    }
}
