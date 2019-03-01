/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class Ejercicio7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Comparador de notas v1.0");
        double sumanotastotales = 0;
        double x = 0;   
        double mediaalumno = 0;
        String nombre;
        
            do {
                nombre = JOptionPane.showInputDialog(null, "Introduzca el nombre del alumno");
                for (int i = 1; i<7;i++){
                    double nota = Double.parseDouble(JOptionPane.showInputDialog(null, "Nota asignatura " + i));
                    mediaalumno = mediaalumno + nota;
                }
                double notamediaalumno = mediaalumno/6;
                System.out.println("El alumno " + nombre + " tiene una nota media de " + notamediaalumno);
                sumanotastotales = sumanotastotales + notamediaalumno;
                x++;
            }
            while (Continuar()==0);
            
        double mediatotal = sumanotastotales/x;
        System.out.println("La media de notas de los alumnos es " + mediatotal);
    }
    public static int Continuar (){
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea continuar?");
        return respuesta;
    }
}
