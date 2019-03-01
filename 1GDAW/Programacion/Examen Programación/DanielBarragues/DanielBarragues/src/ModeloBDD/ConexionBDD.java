/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloBDD;

import java.sql.*;

/**
 *
 * @author 1gprogexa20
 */
public class ConexionBDD {
    
    public static String nombre = "examentercera";
    private String login = "root";
    private String pass = "usbw";
    private String url = "jdbc:mysql://localhost:3307/"+nombre;
    
    private Connection con;
    
    public ConexionBDD() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url,login,pass);
         if (con == null){
            throw new Exception("Problemas con la conexión");
         }
    }
    
    public Connection Conectar(){
       return con;
    }

    public void Desconectar(){
       con = null;
    }
}