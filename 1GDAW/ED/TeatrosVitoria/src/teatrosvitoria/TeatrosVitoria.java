/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teatrosvitoria;
import Modelo.*;

/**
 *
 * @author danie
 */
public class TeatrosVitoria {

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
                // TODO code application logic here
                
                Teatro T1 = new Teatro(001, "Principal", "San prudiencio 32", true);
                Teatro T2 = new Teatro(002, "Federico Garcia Lorca", "Senda de los Echanove 3", false);
                Teatro T3 = new Teatro(003, "Beñat Etxepare", "Plaza Zuberoa 1", true);
                
                Actuacion A1 = new Actuacion(1, "Sabado 15/02/2018 a las 22:00h", false);
                Actuacion A2 = new Actuacion(2, "Jueves 26/02/2018 a las 20:00h", true);
                Actuacion A3 = new Actuacion(3, "Domingo 29/02/2018 a las 17h", true);
                Actuacion A4 = new Actuacion(4, "02 de marzo a las 22:00h", false);
                Actuacion A5 = new Actuacion(5, "03 de marzo a las 22:00h", false);
                Actuacion A6 = new Actuacion(6, "04 de marzo a las 22:00h", true);
                Actuacion A7 = new Actuacion(7, "05 de marzo a las 22:00h", true);
                Actuacion A8 = new Actuacion(8, "12 de marzo a las 20:00h", false);
                Actuacion A9 = new Actuacion(9, "13 de marzo a las 20:00h", false);
                Actuacion A10 = new Actuacion(10, "18 de marzo a las 17:00h", true);
                Actuacion A11 = new Actuacion(11, "12 de abril a las 21:00h", false);
                Actuacion A12 = new Actuacion(12, "13 de abril a las 21:00h", true);
                Actuacion A13 = new Actuacion(13, "14 de abril a las 21:00h", true);
                                
                
                Obra Incendio = new Obra(1, "Incendio","Mario Gas");
                        Incendio.setActuaciones(A1);
                        Incendio.setActuaciones(A2);
                        Incendio.setActuaciones(A3);
                        T1.setActuaciones(A1);
                        T3.setActuaciones(A2);
                        T2.setActuaciones(A3);
                
                Obra Cartas = new Obra( 2, "Cartas de amor", "David Serrano");
                        Cartas.setActuaciones(A4);
                        Cartas.setActuaciones(A5);
                        Cartas.setActuaciones(A6);
                        Cartas.setActuaciones(A7);
                        T1.setActuaciones(A4);
                        T1.setActuaciones(A5);
                        T1.setActuaciones(A6);
                        T1.setActuaciones(A7);
                        Cartas.setActuaciones(A8);
                        Cartas.setActuaciones(A9);
                        T3.setActuaciones(A8);
                        T3.setActuaciones(A9);
                        Cartas.setActuaciones(A10);
                        T2.setActuaciones(A10);
                
                Obra Todo = new Obra(3, "Todo el tiempo del mundo", "Pablo Messiez");
                        Todo.setActuaciones(A11);
                        Todo.setActuaciones(A12);
                        Todo.setActuaciones(A13);
                        T1.setActuaciones(A11);
                        T1.setActuaciones(A12);
                        T1.setActuaciones(A13);
                
                Director Mario = new Director("71712233S", "Mario", "Gas", "Española");
                Director David = new Director("44647483J", "David", "Serrano", "Española");
                Director Pablo = new Director("44561288F", "Pablo", "Messiez", "Argentina");

        }
        
}
