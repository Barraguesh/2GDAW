/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;
import Vista.Inicio;
import Vista.Ventas;
import Vista.Compras;
import Modelo.Productos;
import java.util.ArrayList;
/**
 *
 * @author danie
 */
public class Ejercicio3 {
        
        static Inicio I;
        static Ventas V;
        static Compras C;
        static  ArrayList <Productos> Productos ;
        static Productos p;
        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
                // TODO code application logic here
                I = new Inicio();
                V = new Ventas();
                C = new Compras();
                
                Productos = new ArrayList();
                
                Productos.add(new Productos("Aceite", 10, 3.5, 4.0));
                Productos.add(new Productos("Salmon",  20, 4.75, 5.25));
                Productos.add(new Productos("Sal", 5, 1.25, 1.75));
                
        }
        
        public static boolean ComprobarVenta (String Nombre) {
                int i;
                for (i = 0; i < Productos.size()&&!Productos.get(i).getNombreProducto().equalsIgnoreCase(Nombre);i++) {}
                if (i==Productos.size()) {
                        return false;
                }
                p = Productos.get(i);
                return true;
        }
        
        public static String MostrarImporteVenta (){
                return Double.toString( p.getPrecioVenta());
        }
        
        public static void ActualizarCantidadCompras (String Cantidad) {
                p.setCantidad(p.getCantidad()+Integer.parseInt(Cantidad));
        }
        
        public static int MostrarCantidadNuevaCompras () {
                return p.getCantidad();
        }
        
        public static void ActualizarCantidadVentas (String Cantidad) {
                p.setCantidad(p.getCantidad()-Integer.parseInt(Cantidad));
        }
        
        public static int MostrarCantidadNuevaVentas () {
                return p.getCantidad();
        }
        
        public static boolean ComprobarCompra (String Nombre) {
                int i;
                for (i = 0; i < Productos.size()&&!Productos.get(i).getNombreProducto().equalsIgnoreCase(Nombre);i++) {}
                if (i==Productos.size()) {
                        return false;
                }
                p = Productos.get(i);
                return true;
        }
        
        public static String MostrarImporteCompra (){
                return Double.toString( p.getPrecioCompra());
        }
        
        public static void IrVentas (){
                V.setVisible(true);
                I.setVisible(false);
        }
        
        public static void IrCompras (){
                C.setVisible(true);
                I.setVisible(false);
        }
        
        public static void Salir (){
                System.exit(0);
        }
        
        public static void Cancelar (){
                V.setVisible(false);
                C.setVisible(false);
                I.setVisible(true);
        }
}
