/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class Avion {
        
        private String aerolinea;
        private String codigo_de_avion;
        private int numero_de_asientos;
        private String compartimentos;
        
        private ArrayList <Vuelo> vuelo;

        public Avion(String aerolinea, String codigo_de_avion, int numero_de_asientos, String compartimentos, ArrayList<Vuelo> vuelo) {
                this.aerolinea = aerolinea;
                this.codigo_de_avion = codigo_de_avion;
                this.numero_de_asientos = numero_de_asientos;
                this.compartimentos = compartimentos;
                this.vuelo = vuelo;
        }

        public String getAerolinea() {
                return aerolinea;
        }

        public void setAerolinea(String aerolinea) {
                this.aerolinea = aerolinea;
        }

        public String getCodigo_de_avion() {
                return codigo_de_avion;
        }

        public void setCodigo_de_avion(String codigo_de_avion) {
                this.codigo_de_avion = codigo_de_avion;
        }

        public int getNumero_de_asientos() {
                return numero_de_asientos;
        }

        public void setNumero_de_asientos(int numero_de_asientos) {
                this.numero_de_asientos = numero_de_asientos;
        }

        public String getCompartimentos() {
                return compartimentos;
        }

        public void setCompartimentos(String compartimentos) {
                this.compartimentos = compartimentos;
        }

        public ArrayList<Vuelo> getVuelo() {
                return vuelo;
        }

        public void setVuelo(ArrayList<Vuelo> vuelo) {
                this.vuelo = vuelo;
        }
        
        public void Asignar_a_vuelo(){}
        
        public Avion Obtener(Avion avion){
                return avion;
        }
        
        public void Cancelar_vuelo(){}
        
}
