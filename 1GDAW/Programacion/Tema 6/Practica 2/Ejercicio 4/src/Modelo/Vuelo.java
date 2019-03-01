/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/** 
 *
 * @author danie
 */
public class Vuelo {
        
        private int numero_de_vuelo;
        private String hora_de_salida;
        private String hora_de_llegada;
        private String lugar_de_origen;
        private String lugar_de_destino;
        private Date fecha_de_salida;
        private Date fecha_de_regreso;
        private String tipo_de_vuelo;
        private ArrayList <Asiento> asiento;
        private Avion avion;
        private Pasajero pasajero;
        private Ciudad ciudad;
        private Piloto piloto;

        public Vuelo(int numero_de_vuelo, String hora_de_salida, String hora_de_llegada, String lugar_de_origen, String lugar_de_destino, Date fecha_de_salida, Date fecha_de_regreso, String tipo_de_vuelo, ArrayList<Asiento> asiento, Avion avion, Pasajero pasajero, Ciudad ciudad, Piloto piloto) {
                this.numero_de_vuelo = numero_de_vuelo;
                this.hora_de_salida = hora_de_salida;
                this.hora_de_llegada = hora_de_llegada;
                this.lugar_de_origen = lugar_de_origen;
                this.lugar_de_destino = lugar_de_destino;
                this.fecha_de_salida = fecha_de_salida;
                this.fecha_de_regreso = fecha_de_regreso;
                this.tipo_de_vuelo = tipo_de_vuelo;
                this.asiento = asiento;
                this.avion = avion;
                this.pasajero = pasajero;
                this.ciudad = ciudad;
                this.piloto = piloto;
        }

        public int getNumero_de_vuelo() {
                return numero_de_vuelo;
        }

        public void setNumero_de_vuelo(int numero_de_vuelo) {
                this.numero_de_vuelo = numero_de_vuelo;
        }

        public String getHora_de_salida() {
                return hora_de_salida;
        }

        public void setHora_de_salida(String hora_de_salida) {
                this.hora_de_salida = hora_de_salida;
        }

        public String getHora_de_llegada() {
                return hora_de_llegada;
        }

        public void setHora_de_llegada(String hora_de_llegada) {
                this.hora_de_llegada = hora_de_llegada;
        }

        public String getLugar_de_origen() {
                return lugar_de_origen;
        }

        public void setLugar_de_origen(String lugar_de_origen) {
                this.lugar_de_origen = lugar_de_origen;
        }

        public String getLugar_de_destino() {
                return lugar_de_destino;
        }

        public void setLugar_de_destino(String lugar_de_destino) {
                this.lugar_de_destino = lugar_de_destino;
        }

        public Date getFecha_de_salida() {
                return fecha_de_salida;
        }

        public void setFecha_de_salida(Date fecha_de_salida) {
                this.fecha_de_salida = fecha_de_salida;
        }

        public Date getFecha_de_regreso() {
                return fecha_de_regreso;
        }

        public void setFecha_de_regreso(Date fecha_de_regreso) {
                this.fecha_de_regreso = fecha_de_regreso;
        }

        public String getTipo_de_vuelo() {
                return tipo_de_vuelo;
        }

        public void setTipo_de_vuelo(String tipo_de_vuelo) {
                this.tipo_de_vuelo = tipo_de_vuelo;
        }

        public ArrayList<Asiento> getAsiento() {
                return asiento;
        }

        public void setAsiento(ArrayList<Asiento> asiento) {
                this.asiento = asiento;
        }

        public Avion getAvion() {
                return avion;
        }

        public void setAvion(Avion avion) {
                this.avion = avion;
        }

        public Pasajero getPasajero() {
                return pasajero;
        }

        public void setPasajero(Pasajero pasajero) {
                this.pasajero = pasajero;
        }

        public Ciudad getCiudad() {
                return ciudad;
        }

        public void setCiudad(Ciudad ciudad) {
                this.ciudad = ciudad;
        }

        public Piloto getPiloto() {
                return piloto;
        }

        public void setPiloto(Piloto piloto) {
                this.piloto = piloto;
        }
        
        public void Reservar(){}
        
        public void Modificar(){}
        
        public void Eliminar(){}
        
        public Vuelo Buscar(Vuelo vuelo){
                return vuelo;
        }
           
}
