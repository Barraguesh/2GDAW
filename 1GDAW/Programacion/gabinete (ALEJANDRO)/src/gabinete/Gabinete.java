/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gabinete;
import Modelo.UML.*;
import Modelo.BD.*;
import Vista.*;
import java.util.ArrayList;
import javax.persistence.Persistence;
/**
 *
 * @author Alejandro
 */
public class Gabinete {

    static AbogadosJpaController miAbogado;
    static ClientesJpaController miCliente;
    static CasosJpaController miCaso;
    static Menu vm;
    static AltaAbogados va;
    static AltaClientes vc;
    static Abogados a;
    static Clientes c;
    static ArrayList <Casos> casos;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            vm=new Menu();
            casos=new ArrayList();
            miAbogado=new AbogadosJpaController(Persistence.createEntityManagerFactory("gabinetePU2"));
            miCliente=new ClientesJpaController(Persistence.createEntityManagerFactory("gabinetePU2"));
            miCaso=new CasosJpaController(Persistence.createEntityManagerFactory("gabinetePU2"));
        }catch (Exception e){
            System.out.println("Peto");
        }
    }
    public static void alta(javax.swing.JFrame v){
        v.setVisible(false);
        va = new AltaAbogados();
    }
    public static void alta2(javax.swing.JFrame v){
        v.setVisible(false);
        vc = new AltaClientes();
    }
    public static void modif(javax.swing.JFrame v,boolean a){
        v.setVisible(false);
        va = new AltaAbogados(a);
    }
    public static void modif2(javax.swing.JFrame v,boolean a){
        v.setVisible(false);
        vc = new AltaClientes(a);
    }
    public static void crearAbogado(String dni, String nombre, String a1, String a2, String dir)throws Exception{
        a = new Abogados(dni, nombre, a1, a2, dir);       
        miAbogado.create(a);       
    }
    public static void eliminarAbogado(String id)throws Exception{
        miAbogado.destroy(id);
    }
    public static void modificarAbogado(String dni, String nombre, String a1, String a2, String dir)throws Exception{
        a = new Abogados(dni, nombre, a1, a2, dir);           
        a.setCasosCollection(casos);
        miAbogado.edit(a);
    }
    public static void crearCliente(String dni, String nombre, String a1, String a2, String dir, String tlfo)throws Exception{
        c = new Clientes(dni, nombre, a1, a2, dir, tlfo);
        miCliente.create(c);
    }
    public static void eliminarCliente(String id)throws Exception{
        miCliente.destroy(id);
    }
    public static void modificarCliente(String dni, String nombre, String a1, String a2, String dir, String tlfo)throws Exception{
        c = new Clientes(dni, nombre, a1, a2, dir, tlfo);      
        c.setCasosCollection(casos);
        miCliente.edit(c);
    }
    
    public static void next(javax.swing.JFrame v){
        v.dispose();       
        va = new AltaAbogados();
    }
    public static void next2(javax.swing.JFrame v){
        v.dispose();       
        vc = new AltaClientes();
    }
    public static void volver(javax.swing.JFrame v){
        v.dispose();
        vm.setVisible(true);
    }
    public static Abogados find(String id){
        Abogados abogado=miAbogado.findAbogados(id);
        return abogado;
    } 
    public static Clientes find2(String id){
        Clientes cliente=miCliente.findClientes(id);
        return cliente;
    } 
}
