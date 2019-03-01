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
public class Piloto {
        private String codigo_de_piloto;
        private String nombre;  
        private String apellido;
        private int numero_de_licencia;
        private ArrayList <Vuelo> vuelo;

        public Piloto(String codigo_de_piloto, String nombre, String apellido, int numero_de_licencia, ArrayList <Vuelo> vuelo) {
                this.codigo_de_piloto = codigo_de_piloto;
                this.nombre = nombre;
                this.apellido = apellido;
                this.numero_de_licencia = numero_de_licencia;
                this.vuelo = vuelo;
        }

        public String getCodigo_de_piloto() {
                return codigo_de_piloto;
        }

        public void setCodigo_de_piloto(String codigo_de_piloto) {
                this.codigo_de_piloto = codigo_de_piloto;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public String getApellido() {
                return apellido;
        }

        public void setApellido(String apellido) {
                this.apellido = apellido;
        }

        public int getNumero_de_licencia() {
                return numero_de_licencia;
        }

        public void setNumero_de_licencia(int numero_de_licencia) {
                this.numero_de_licencia = numero_de_licencia;
        }
        
        public void Agregar_nuevo(){}
        
        public void Asignar_nuevo(){}
        
        public void Cancelar_vuelo(){}
        
        public void Modificar(){}
        
        public Piloto Buscar(Piloto piloto){
                return piloto;
        }
        
}
