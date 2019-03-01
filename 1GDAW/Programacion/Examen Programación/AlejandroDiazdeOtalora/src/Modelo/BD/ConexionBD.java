/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BD;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 1gprogexa17
 */
public class ConexionBD {
    private String user="root";
    private String pass="usbw";
    private String url="jdbc:mysql://localhost:3307/examentercera";    
    
    private Connection con;

    public ConexionBD() {}
    
    public void conexion()throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(url,user,pass);
        
        if(con==null)
            System.out.println("Problemas con la conexion");
    }

    public Connection getCon() {
        return con;
    }

    public void descontectar() {
        this.con = null;
    }
    
}
