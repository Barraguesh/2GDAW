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
public class Actuacion {
        
        private int Codigo;
        private String Horario;
        private boolean EntradasLibres;

        public Actuacion(int Codigo, String Horario, boolean EntradasLibres) {
                this.Codigo = Codigo;
                this.Horario = Horario;
                this.EntradasLibres = EntradasLibres;
        }

        public int getCodigo() {
                return Codigo;
        }

        public void setCodigo(int Codigo) {
                this.Codigo = Codigo;
        }

        public String getHorario() {
                return Horario;
        }

        public void setHorario(String Horario) {
                this.Horario = Horario;
        }

        public boolean isEntradasLibres() {
                return EntradasLibres;
        }

        public void setEntradasLibres(boolean EntradasLibres) {
                this.EntradasLibres = EntradasLibres;
        }
        
}
