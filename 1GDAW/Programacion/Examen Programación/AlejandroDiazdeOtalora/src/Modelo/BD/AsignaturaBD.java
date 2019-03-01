/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BD;

import Modelo.UML.Alumno;
import Modelo.UML.Asignatura;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import alejandrodiazdeotalora.AlejandroDiazdeOtalora;
import java.util.ArrayList;

/**
 *
 * @author 1gprogexa17
 */
public class AsignaturaBD {
    private ConexionBD con;
    private PreparedStatement p;
    private Statement s;
    private ResultSet r;
    private ResultSet r2;
    private Asignatura a;
    private ArrayList <Asignatura> asigs;
    private Alumno alumnn;
    
    public ArrayList <Asignatura> selectAll()throws Exception{    
        a=null;
        con=new ConexionBD();
        con.conexion();
        s=con.getCon().createStatement();
        r=s.executeQuery("select * from asignaturas");
        asigs=new ArrayList();
        while(r.next()){          
            a=new Asignatura();
            a.setNombre(r.getString(1));
            a.setP(AlejandroDiazdeOtalora.getProfesor(r.getString(2)));
            p=con.getCon().prepareStatement("select * from alumnosasignaturas where nombreAsignatura=?");
            p.setString(1, a.getNombre());
            r2=p.executeQuery();
            while (r2.next()){
                AlumnoBD alumn=new AlumnoBD();
                alumn.selectByDni(r2.getString(1));
                alumnn=new Alumno();
                alumnn.setDni(r.getString(1));
                alumnn.setNombre(r.getString(2));               
            }
            asigs.add(a);
        }
        con.descontectar();        
        return asigs;
    }
    public Asignatura selectByName(String nombre)throws Exception{    
        a=null;
        alumnn=null;
        con=new ConexionBD();
        con.conexion();
        p=con.getCon().prepareStatement("select * from asignaturas where nombre=?");
        p.setString(1, nombre);
        r=p.executeQuery();       
        if(r.next()){
            a=new Asignatura();
            a.setNombre(r.getString(1));
            a.setP(AlejandroDiazdeOtalora.getProfesor(r.getString(2))); 
            
            p=con.getCon().prepareStatement("select * from alumnosasignaturas where nombreAsignatura=?");
            p.setString(1, a.getNombre());
            r2=p.executeQuery();
            while (r2.next()){
                AlumnoBD alumn=new AlumnoBD();
                alumnn=alumn.selectByDni(r2.getString(1));             
                a.addA(alumnn);
            }           
        }
        con.descontectar();        
        return a;
    }
}
