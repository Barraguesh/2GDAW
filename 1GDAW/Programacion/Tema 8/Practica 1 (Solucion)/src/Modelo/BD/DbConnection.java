package Modelo.BD;

import java.sql.*;

public class DbConnection {

   //Parametros de conexion
    private String bd = "bdPracticaUnoE1";
    private String login = "root";
    private String password = "usbw";
    private String url = "jdbc:mysql://localhost:3307/"+bd;
    
    // constantes???
    // Parametros para el constructor??
    // Todo static como en la clase principal???
 
    private Connection connection;
 
    /** Constructor de DbConnection */
    public DbConnection() throws Exception
    {
         //obtenemos el driver para mysql
         Class.forName("com.mysql.jdbc.Driver");
         //obtenemos la conexión
         connection = DriverManager.getConnection(url,login,password);
 
         if (connection==null){
            throw new Exception("Problemas con la conexión");
         }
   }
  
   public Connection getConnection(){
      return connection;
   }
 
   public void desconectar(){
      connection = null;
   }
}
