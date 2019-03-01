/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6;

import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class Ejercicio6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Comparador de fecha v1.0");
        int diacomprobado = 0;
        int anocomprobado = 0;
        
        int x = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuántas fechas desea introducir?"));
        for (int i=0; i<x;i++){
            String mes = JOptionPane.showInputDialog(null, "Introduzca el  numero de mes (mm)");
            int mes1 = Integer.parseInt(mes);
            int mescomprobado = ControlMes(mes1);
            String dia = JOptionPane.showInputDialog(null, "Introduzca el día (dd)");
            int dia1 = Integer.parseInt(dia);
            if (mescomprobado==1){
                diacomprobado = ControlDia1(dia1);
            }
            if (mescomprobado==2){
                diacomprobado = ControlDia2(dia1);
            }
            if (mescomprobado==3){
                diacomprobado = ControlDia3(dia1);
            }
            int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca el año (aaaa)"));            
            if (ano<=2017) anocomprobado = 2;
            anocomprobado = ControlAno(ano);
            if (anocomprobado==0){
                int diacomprobado2 = ControlDia4(dia1);
            }
            if (diacomprobado==1 && mescomprobado==1 && anocomprobado==2 || diacomprobado==2 && mescomprobado==2 && anocomprobado==2 || diacomprobado==3 && mescomprobado==3 && anocomprobado==1 || diacomprobado==4 && mescomprobado==3 && anocomprobado==2){
                System.out.println("La fecha " + dia1 + "/" + mes1 + "/" + ano + " es correcta");
            }else{
                System.out.println("La fecha " + dia1 + "/" + mes1 + "/" + ano + " es incorrecta");
            }
        }
    }
        public static int ControlDia1(int a){
            int control = 0;
            if (a<=31) if (0<a) control = 1;
            return control;
            }
        public static int ControlDia2(int a){
            int control = 0;
            if (a<=30) if (0<a) control = 2;
            return control;
            }
        public static int ControlDia3(int a){
            int control = 0;
            if (a<=29) {
                if (0<a) control = 3;
            }else{
                control = 0;
            }
            return control;
            }
        public static int ControlDia4(int a){
            int control = 0;
            if (a<=28) if (0<a) control = 4;
            return control;
            }
        public static int ControlMes(int a){
         int control = 0;
         switch (a){
            case 1:
                control = 1;
            break;
            case 2:
                control = 3;
            break;
            case 3:
                control = 1;
            break;
            case 4:
                control = 2;
            break;
            case 5:
                control = 1;
            break;
            case 6:
                control = 2;
            break;
            case 7:
                control = 1;
            break;
            case 8:
                control = 1;
            break;
            case 9:
                control = 2;
            break;
            case 10:
                control = 1;
            break;
            case 11:
                control = 2;
            break;
            case 12:
                control = 1;
            break;  
         }
         return control;
         }
        public static int ControlAno(int a){
        int control = 0;
            if(a % 4 == 0 && a % 100 != 0 || a % 400 == 0){
                control = 1;
            }
            return control;
        }
    
}
