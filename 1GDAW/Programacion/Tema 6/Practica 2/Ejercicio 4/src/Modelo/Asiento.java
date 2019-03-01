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
public class Asiento {
        
        private int numero_de_asiento;
        private boolean estado;
        private String compartimento;
        private Pasajero pasajero;
        private Vuelo vuelo;

        public Asiento(int numero_de_asiento, boolean estado, String compartimento, Pasajero pasajero, Vuelo vuelo) {
                this.numero_de_asiento = numero_de_asiento;
                this.estado = estado;
                this.compartimento = compartimento;
                this.pasajero = pasajero;
                this.vuelo = vuelo;
        }

        public int getNumero_de_asiento() {
                return numero_de_asiento;
        }

        public void setNumero_de_asiento(int numero_de_asiento) {
                this.numero_de_asiento = numero_de_asiento;
        }

        public boolean isEstado() {
                return estado;
        }

        public void setEstado(boolean estado) {
                this.estado = estado;
        }

        public String getCompartimento() {
                return compartimento;
        }

        public void setCompartimento(String compartimento) {
                this.compartimento = compartimento;
        }

        public Pasajero getPasajero() {
                return pasajero;
        }

        public void setPasajero(Pasajero pasajero) {
                this.pasajero = pasajero;
        }

        public Vuelo getVuelo() {
                return vuelo;
        }

        public void setVuelo(Vuelo vuelo) {
                this.vuelo = vuelo;
        }

        public void Reservar(){}
        
        public void Comprar(){}
        
        public boolean Mostrar_disponibilidad(boolean mostrar){
                return mostrar;
        }
        
        public void Desbloquear(){}
        
}
