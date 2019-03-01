package Modelo.BD;

import Modelo.ClasesUML.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PersonaDAO {
 
   
    public void registrarPersona(Persona persona) throws Exception
    {
       // Abrir la conexión. 
       DbConnection conex= new DbConnection();
  
           // Preparar y ejecutar la sentencia sql.
           // También se puede hacer con preparedStatement
           Statement sentencia = conex.getConnection().createStatement();
           sentencia.executeUpdate("INSERT INTO persona VALUES ('"+persona.getNombrePersona()+"', '"+persona.getEdadPersona()+"', '"
               +persona.getProfesionPersona()+"', '"+persona.getTelefonoPersona()+"')");
           sentencia.close();


           conex.desconectar();
    }


   public Persona consultarPersona(String nombre) throws Exception
   {
     Persona persona=null;
     DbConnection conex= new DbConnection();

    
       PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM persona where nombre = ? ");
       consulta.setString(1, nombre);
       ResultSet res = consulta.executeQuery();

       if(res.next())
       {
           persona= new Persona();
           persona.setNombrePersona(res.getString("nombre"));
           persona.setEdadPersona(Integer.parseInt(res.getString("edad")));
           persona.setProfesionPersona(res.getString("profesion"));
           persona.setTelefonoPersona(res.getString("telefono"));
       }
       else
            throw new Exception ("Persona no encontrada");
       

       res.close();
       consulta.close();
       conex.desconectar();
 
       return persona;
    }

    public ArrayList<Persona> listaDePersonas() throws Exception
    {
        ArrayList< Persona> listaPersonas = new ArrayList();

        DbConnection conex= new DbConnection();

        Statement consulta = conex.getConnection().createStatement();
        ResultSet res = consulta.executeQuery("Select * from persona");
        while(res.next())
        {
          Persona persona= new Persona();
          persona.setNombrePersona(res.getString("nombre"));
          persona.setEdadPersona(Integer.parseInt(res.getString("edad")));
          persona.setProfesionPersona(res.getString("profesion"));
          persona.setTelefonoPersona(res.getString("telefono"));
          listaPersonas.add(persona);
        }
        res.close();
        consulta.close();
        conex.desconectar();
   
        return listaPersonas;
 }
}
 
