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
public class Asignatura {
    private String nombre;
    private Profesor p;
    private ArrayList <Alumno> a;

    public Asignatura() {}
   
    public Asignatura(String nombre) {
        this.nombre = nombre;
        a=new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Profesor getP() {
        return p;
    }

    public void setP(Profesor p) {
        this.p = p;
    }

    public ArrayList<Alumno> getA() {
        return a;
    }

    public void setA(ArrayList<Alumno> a) {
        this.a = a;
    }
    public void addA(Alumno ab){
        if(a==null)
            this.a=new ArrayList();
        this.a.add(ab);
    }
}
