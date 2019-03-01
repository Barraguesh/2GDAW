/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BD;

import Modelo.UML.Alumno;
import Modelo.UML.Asignatura;
import alejandrodiazdeotalora.AlejandroDiazdeOtalora;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 1gprogexa17
 */
public class AlumnoBD {
    private ConexionBD con;
    private PreparedStatement p;
    private Statement s;
    private ResultSet r;
    private ResultSet r2;    
    private Alumno a;
    private ArrayList <Alumno> as;
    private Asignatura asigna;
    
    public ArrayList <Alumno> selectAll()throws Exception{
        con=new ConexionBD();
        con.conexion(); 
        s=con.getCon().createStatement();
        r=s.executeQuery("select * from alumnos");
        as=new ArrayList();
        while(r.next()){            
            a=new Alumno();
            a.setDni(r.getString(1));
            a.setNombre(r.getString(2));
            p=con.getCon().prepareStatement("select * from alumnosasignaturas where dniAlumno=?");
            p.setString(1, a.getDni());
            r2=p.executeQuery();
            while(r2.next()){
                AsignaturaBD asg=new AsignaturaBD();
                asg.selectByName(r2.getString(2));
                asigna=new Asignatura();
                asigna.setNombre(r.getString(1));
                asigna.setP(AlejandroDiazdeOtalora.getProfesor(r.getString(2)));
                a.addA(asigna);
            }
                
            as.add(a);
        }
        con.descontectar();
        return as;
    }
    
    public Alumno selectByDni(String dni)throws Exception{
        a=null;
        con=new ConexionBD();
        con.conexion(); 
        p=con.getCon().prepareStatement("select * from alumnos where dni=?");
        p.setString(1, dni);       
        r=p.executeQuery();
        if(r.next()){        
            a=new Alumno();
            a.setDni(r.getString(1));
            a.setNombre(r.getString(2));           
        }        
        con.descontectar();
        return a;
    }
    
    public Alumno selectByName(String nombre)throws Exception{
        a=null;
        con=new ConexionBD();
        con.conexion(); 
        p=con.getCon().prepareStatement("select * from alumnos where nombre=?");
        p.setString(1, nombre);       
        r=p.executeQuery();
        if(r.next()){            
            a=new Alumno();
            a.setDni(r.getString(1));
            a.setNombre(r.getString(2));           

            p=con.getCon().prepareStatement("select * from alumnosasignaturas where dnialumno=?");
            p.setString(1, a.getDni());
            r2=p.executeQuery();
            while(r2.next()){
                AsignaturaBD asb=new AsignaturaBD();
                asigna=asb.selectByName(r2.getString(2));
                a.addA(asigna);
            }
        }        
        con.descontectar();
        return a;
    }
    
    public void crear(Alumno a)throws Exception{
        con=new ConexionBD();
        con.conexion();
        p=con.getCon().prepareStatement("insert into alumnos values(?,?)");
        p.setString(1, a.getDni());
        p.setString(2, a.getNombre());
        p.executeUpdate();
        for (Asignatura asig : a.getA()) {
            p=con.getCon().prepareStatement("insert into alumnosasignaturas values (?,?)");
            p.setString(1, a.getDni());
            p.setString(2, asig.getNombre());
            p.executeUpdate();  
        }           
        con.descontectar();        
    }
}
