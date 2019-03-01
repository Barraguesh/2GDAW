/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alejandrodiazdeotalora;

import Exceptionss.NotFound;
import Modelo.BD.AsignaturaBD;
import Vista.AltadeAlumnos;
import Vista.Opcion;
import Modelo.BD.*;
import Modelo.UML.*;
import Vista.Consultas;
import java.util.ArrayList;

/**
 *
 * @author 1gprogexa17
 */
public class AlejandroDiazdeOtalora {
static Opcion o;
static Consultas cons;
static AltadeAlumnos a;
static ConexionBD con;
static AsignaturaBD asignaturaBD;
static ProfesorBD profeBD;
static AlumnoBD alumnoBD;
static ArrayList <Asignatura> asignaturas;
static ArrayList <Asignatura> asignaturasAlumno;
static ArrayList <Alumno> alumnos;
static Alumno al;
static Asignatura asignatura;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        con=new ConexionBD();
        asignaturas=new ArrayList();
        asignaturasAlumno=new ArrayList();
        asignaturaBD=new AsignaturaBD();
        profeBD=new ProfesorBD();
        alumnoBD=new AlumnoBD();
        o=new Opcion();
    }
    
    public static void toOpciones(){
        o=new Opcion();               
    }
    public static void res(int tipo){
        switch (tipo){
            case 1:
                o.dispose();
                a=new AltadeAlumnos();
                break;
            case 2:
                o.dispose();
                cons=new Consultas();
                break;
            case 3:
                salir();
                break;
        }
    }
    
    public static void llenarcbAsigs(javax.swing.JComboBox cb, boolean rellenar)throws Exception{
        if(!rellenar){
            asignaturasAlumno=new ArrayList();
            asignaturas=asignaturaBD.selectAll();
        }
        else
            cb.removeAllItems();
        for (Asignatura a : asignaturas) {
            cb.addItem(a.getNombre());
        }
    }
    
    public static Profesor getProfesor(String nombre)throws Exception{
        return profeBD.unProfesor(nombre);
    }
    
    public static void anadirAsig(int indice){
        asignaturasAlumno.add(asignaturas.get(indice));
        asignaturas.remove(indice);       
    }
    public static void crearAlumno(String dni, String nombre)throws Exception{
        al=new Alumno(nombre, dni);
        al.setA(asignaturasAlumno);
        alumnoBD.crear(al);
    }
    
    public static String AsignaturasAlumno(String nombre)throws Exception{
        String cadena="";
        al=alumnoBD.selectByName(nombre);
        if(al==null)
            throw new NotFound();
        cadena+=al.getNombre()+":\n";
        if(al.getA()!=null)
            for(Asignatura a : al.getA())
                cadena+=a.getNombre()+"\n";     
        else
            cadena+="No hay datos";
        return cadena;
    }
    public static String AlumnoAsignaturas(String nombre)throws Exception{      
        String cadena="";
        asignatura=asignaturaBD.selectByName(nombre);
        if(asignatura==null)
            throw new NotFound();
        cadena+=asignatura.getNombre()+":\n";
        if(asignatura.getA()!=null)
            for(Alumno a : asignatura.getA())
                cadena+=a.getDni()+"  "+a.getNombre()+"\n";        
        else
            cadena+="No hay datos";
        return cadena;
    }
    public static void salir(){
        System.exit(0);
    }
}
