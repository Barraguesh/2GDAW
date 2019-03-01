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
public class Productos {
        private String NombreProducto;
        private int Cantidad;
        private double PrecioCompra;
        private double PrecioVenta;

        public Productos(String NombreProducto, int Cantidad, double PrecioCompra, double PrecioVenta) {
                this.NombreProducto = NombreProducto;
                this.Cantidad = Cantidad;
                this.PrecioCompra = PrecioCompra;
                this.PrecioVenta = PrecioVenta;
        }

        public String getNombreProducto() {
                return NombreProducto;
        }

        public void setNombreProducto(String NombreProducto) {
                this.NombreProducto = NombreProducto;
        }

        public int getCantidad() {
                return Cantidad;
        }

        public void setCantidad(int Cantidad) {
                this.Cantidad = Cantidad;
        }

        public double getPrecioCompra() {
                return PrecioCompra;
        }

        public void setPrecioCompra(double PrecioCompra) {
                this.PrecioCompra = PrecioCompra;
        }

        public double getPrecioVenta() {
                return PrecioVenta;
        }

        public void setPrecioVenta(double PrecioVenta) {
                this.PrecioVenta = PrecioVenta;
        }

}
