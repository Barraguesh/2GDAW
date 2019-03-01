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
public class Empleado {
    
    private String cod_empleado;
    private String cargo;
    private String nombre;
    private double salario;

    public Empleado(String cod_empleado, String cargo, String nombre, double salario) {
        this.cod_empleado = cod_empleado;
        this.cargo = cargo;
        this.nombre = nombre;
        this.salario = salario;
    }

    public String getCod_empleado() {
        return cod_empleado;
    }

    public void setCod_empleado(String cod_empleado) {
        this.cod_empleado = cod_empleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    static void calcularSalarioMedio(){
        
        
    }
    
    static void calcularNumeroDeEmplePorCargo(){
        
    }
}
