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
public class Director {
        
        private String DNI;
        private String Nombre;
        private String Apellido;
        private String Nacionalidad;

        public Director(String DNI, String Nombre, String Apellido, String Nacionalidad) {
                this.DNI = DNI;
                this.Nombre = Nombre;
                this.Apellido = Apellido;
                this.Nacionalidad = Nacionalidad;
        }

        public String getDNI() {
                return DNI;
        }

        public void setDNI(String DNI) {
                this.DNI = DNI;
        }

        public String getNombre() {
                return Nombre;
        }

        public void setNombre(String Nombre) {
                this.Nombre = Nombre;
        }

        public String getApellido() {
                return Apellido;
        }

        public void setApellido(String Apellido) {
                this.Apellido = Apellido;
        }

        public String getNacionalidad() {
                return Nacionalidad;
        }

        public void setNacionalidad(String Nacionalidad) {
                this.Nacionalidad = Nacionalidad;
        }
        
}
