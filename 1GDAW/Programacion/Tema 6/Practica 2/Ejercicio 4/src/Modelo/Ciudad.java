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
public class Ciudad {
        
        private String codigo_ciudad;
        private String nombre;
        private ArrayList <Vuelo> vuelo;

        public Ciudad(String codigo_ciudad, String nombre, ArrayList<Vuelo> vuelo) {
                this.codigo_ciudad = codigo_ciudad;
                this.nombre = nombre;
                this.vuelo = vuelo;
        }

        public String getCodigo_ciudad() {
                return codigo_ciudad;
        }

        public void setCodigo_ciudad(String codigo_ciudad) {
                this.codigo_ciudad = codigo_ciudad;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public ArrayList<Vuelo> getVuelo() {
                return vuelo;
        }

        public void setVuelo(ArrayList<Vuelo> vuelo) {
                this.vuelo = vuelo;
        }
        
        public void Agregar_nuevo(){}
        
        public Ciudad Obtener(Ciudad ciudad){
                return ciudad;
        }
        
}
