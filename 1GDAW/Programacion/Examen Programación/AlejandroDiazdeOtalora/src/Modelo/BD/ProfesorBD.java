/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BD;

import Modelo.UML.Profesor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author 1gprogexa17
 */
public class ProfesorBD {
    private ConexionBD con;
    private PreparedStatement p;
    private Statement s;
    private ResultSet r;
    private Profesor prof;
    
    public Profesor unProfesor(String nombre)throws Exception{
        con=new ConexionBD();
        con.conexion();
        p=con.getCon().prepareStatement("select * from profesores where nombre=?");
        p.setString(1, nombre);
        r=p.executeQuery();
        if(r.next()){
            prof=new Profesor();
            prof.setNombre(r.getString(1));
        }       
        con.descontectar();        
        return prof;
    }
}
