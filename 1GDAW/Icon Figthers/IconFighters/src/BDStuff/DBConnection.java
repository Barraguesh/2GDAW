/**
 * @author Barraguesh
 * @version %I% %G%
 * @since v0.2 alpha
 */
package BDStuff;

import java.sql.*;

public class DBConnection {

   //Connection parameters
    private String bd = "iconfigthers";
    private String login = "root";
    private String password = "usbw";
    private String url = "jdbc:mysql://localhost:3307/"+bd;
 
    private Connection connection;
 
    /** DBConnection constructor */
    public DBConnection() throws Exception
    {
         //We get the MYSQL Driver
         Class.forName("com.mysql.jdbc.Driver");
         //We get the connection
         connection = DriverManager.getConnection(url,login,password);

         if (connection == null){
            throw new Exception("Problemas con la conexión");
         }
    }
    
    public Connection getConnection(){
       return connection;
    }

    public void Disconnect(){
       connection = null;
    }
}