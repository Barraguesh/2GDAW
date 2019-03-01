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
public class Alumno extends Persona{

    private String dni;
    private ArrayList <Asignatura> a;

    public Alumno() {}
    
    public Alumno(String nombre,String dni) {
        super(nombre);
        this.dni=dni;
        a=new ArrayList();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public ArrayList<Asignatura> getA() {
        return a;
    }

    public void setA(ArrayList<Asignatura> a) {
        this.a = a;
    }
    public void addA(Asignatura as){
        if(a==null)
            a=new ArrayList();
        this.a.add(as);
    }
 
}
