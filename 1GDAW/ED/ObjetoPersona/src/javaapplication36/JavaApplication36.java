/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication36;
import javax.swing.JOptionPane;
/**
 *
 * @author Usuario
 */
public class JavaApplication36 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Persona persona1 = new Persona("Marron", "Verde", 1.7, 80);
        Persona persona2=new Persona("Rubio", "Azul", 1.9, 70);
        if(persona1.getAltura()>persona2.getAltura()){
            JOptionPane.showMessageDialog(null, persona1.getAltura()+"\n"+persona1.getPeso()+"\n"+persona1.getColorOjos()+"\n"+persona1.getColorPelo());
        }else{
            JOptionPane.showMessageDialog(null, persona2.getAltura()+"\n"+persona2.getPeso()+"\n"+persona2.getColorOjos()+"\n"+persona2.getColorPelo());
        }
        
    }
    
}
