/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloBDD;

import Clase.Consulta;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author 1gprogexa20
 */
public class AccesoBDD {
    
    public static void InsertarAlumno(String dni, String nombre) throws SQLException, Exception{
        ConexionBDD con = new ConexionBDD();
        PreparedStatement prep = con.Conectar().prepareStatement("INSERT INTO ALUMNOS VALUES (?,?)");
        prep.setString(1, dni);
        prep.setString(2, nombre);
        prep.executeUpdate();
        con.Desconectar();
        prep.close();
    }
    
    public static void InsertarAsignaturaAlumno(String dni, String asignatura) throws SQLException, Exception{
        ConexionBDD con = new ConexionBDD();
        PreparedStatement prep = con.Conectar().prepareStatement("INSERT INTO alumnosasignaturas VALUES(?,?)");
        prep.setString(1, dni);
        prep.setString(2, asignatura);
        prep.executeUpdate();
        con.Desconectar();
        prep.close();
    }
    
    public static ArrayList ConsultaAlumnos(String nombre) throws Exception{
        ConexionBDD conn = new ConexionBDD();        
        Statement stat = conn.Conectar().createStatement();        
        ResultSet resul = stat.executeQuery("SELECT * FROM ALUMNOS WHERE NOMBRE='" + nombre + "'");
        ArrayList array = new ArrayList();
        Consulta c = null;
        while (resul.next()){
            c = new Consulta();
            c.setDNI(resul.getString("dni"));
            c.setNombre(resul.getString("nombre"));
            array.add(c);
        }
        conn.Desconectar();
        stat.close();
        resul.close();
        return array;
    }
    
    public static ArrayList ConsultaAsignatura(String nombre) throws Exception{
        ArrayList array = new ArrayList();
        
        return array;
    }
}
