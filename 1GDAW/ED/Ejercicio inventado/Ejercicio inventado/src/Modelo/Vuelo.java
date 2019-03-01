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
public class Vuelo {
    private int cod_vuelo;
    private int metros_avion;
    private String modelo_del_avion;
    private int numero_de_asientos;

        public Vuelo(int cod_vuelo, int metros_avion, String modelo_del_avion, int numero_de_asientos) {
                this.cod_vuelo = cod_vuelo;
                this.metros_avion = metros_avion;
                this.modelo_del_avion = modelo_del_avion;
                this.numero_de_asientos = numero_de_asientos;
        }
    
        public Vuelo(){}
    public int getCod_vuelo() {
        return cod_vuelo;
    }

    public void setCod_vuelo(int cod_vuelo) {
        this.cod_vuelo = cod_vuelo;
    }

    public int getMetros_avion() {
        return metros_avion;
    }

    public void setMetros_avion(int metros_avion) {
        this.metros_avion = metros_avion;
    }

    public String getModelo_del_avion() {
        return modelo_del_avion;
    }

    public void setModelo_del_avion(String modelo_del_avion) {
        this.modelo_del_avion = modelo_del_avion;
    }

    public int getNumero_de_asientos() {
        return numero_de_asientos;
    }

    public void setNumero_de_asientos(int numero_de_asientos) {
        this.numero_de_asientos = numero_de_asientos;
    }
}


