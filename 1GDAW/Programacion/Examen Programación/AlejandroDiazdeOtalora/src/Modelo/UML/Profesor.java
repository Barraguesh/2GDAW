/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.UML;

import java.util.ArrayList;

/**
 *
 * @author 1gprogexa17
 */
public class Profesor extends Persona{
    private ArrayList <Asignatura> a;

    public Profesor() {}
  
    public Profesor(String nombre) {
        super(nombre);
        a=new ArrayList();
    }

    public ArrayList<Asignatura> getA() {
        return a;
    }

    public void setA(ArrayList<Asignatura> a) {
        this.a = a;
    }
     
}
