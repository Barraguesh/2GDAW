/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author danie
 */
public class Pasajero {
    
    private String dni;
    private int edad;
    private String telefono;
    private String direccion;
    private String nacionalidad;

    public Pasajero(String dni, int edad, String telefono, String direccion, String nacionalidad) {
        this.dni = dni;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
        this.nacionalidad = nacionalidad;
    }
    
    public Pasajero (){}
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    static boolean calcularMayorDeEdad(int edad){
        boolean mayoredad = false;
        if (edad > 18){
            mayoredad = true;
        }
        return mayoredad;
    }
}
