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
public class Obra {
        
        private int Codigo;
        private String Nombre;
        private String Director;
        private ArrayList <Actuacion> Actuaciones;

        public Obra(int Codigo, String Nombre, String Director) {
                this.Codigo = Codigo;
                this.Nombre = Nombre;
                this.Director = Director;
                Actuaciones = new ArrayList();
        }

        public int getCodigo() {
                return Codigo;
        }

        public void setCodigo(int Codigo) {
                this.Codigo = Codigo;
        }

        public String getNombre() {
                return Nombre;
        }

        public void setNombre(String Nombre) {
                this.Nombre = Nombre;
        }

        public String getDirector() {
                return Director;
        }

        public void setDirector(String Director) {
                this.Director = Director;
        }

        public ArrayList<Actuacion> getActuaciones() {
                return Actuaciones;
        }

        public void setActuaciones(Actuacion A) {
                this.Actuaciones.add(A);
        }
        
}
