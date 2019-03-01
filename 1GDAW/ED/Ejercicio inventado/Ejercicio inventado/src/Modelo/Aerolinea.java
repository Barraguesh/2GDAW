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
public class Aerolinea {
    
    private int cod_aerolinea;
    private String nombre;
    private String pais;

    public Aerolinea(int cod_aerolinea, String nombre, String pais) {
        this.cod_aerolinea = cod_aerolinea;
        this.nombre = nombre;
        this.pais = pais;
    }

    public int getCod_aerolinea() {
        return cod_aerolinea;
    }

    public void setCod_aerolinea(int cod_aerolinea) {
        this.cod_aerolinea = cod_aerolinea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }    
    
}
