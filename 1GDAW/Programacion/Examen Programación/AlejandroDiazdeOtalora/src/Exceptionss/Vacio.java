/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptionss;

/**
 *
 * @author 1gprogexa17
 */
public class Vacio extends Exception{

    private String dato;
    
    private javax.swing.JLabel err;
    public Vacio(String dato, javax.swing.JLabel err) {
        this.dato=dato;
        this.err=err;
    }
    public void dato(){
        err.setVisible(true);
    }
}
