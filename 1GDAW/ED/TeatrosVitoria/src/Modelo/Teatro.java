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
public class Teatro {
        
        private int Codigo;
        private String Nombre;
        private String Direccion;
        private boolean Abierto;
        private ArrayList <Actuacion> Actuaciones;


        public Teatro(int Codigo, String Nombre, String Direccion, boolean Abierto) {
                this.Codigo = Codigo;
                this.Nombre = Nombre;
                this.Direccion = Direccion;
                this.Abierto = Abierto;
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

        public String getDireccion() {
                return Direccion;
        }

        public void setDireccion(String Direccion) {
                this.Direccion = Direccion;
        }

        public boolean isAbierto() {
                return Abierto;
        }

        public void setAbierto(boolean Abierto) {
                this.Abierto = Abierto;
        }
        
        public ArrayList<Actuacion> getActuaciones() {
                return Actuaciones;
        }

        public void setActuaciones(Actuacion A) {
                this.Actuaciones.add(A);
        }
        
}
