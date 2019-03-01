
package t8p1e1;

import Modelo.BD.PersonaDAO;
import Modelo.ClasesUML.Persona;
import Vista.*;
import java.util.ArrayList;

public class Principal {

    private static PersonaDAO miPersonaDAO;
    private static Ventana v;
    private static VMenu vm;
    private static ArrayList<Persona> listaPersonas;
    private static int posicion;
 
    public static void main(String[] args) 
    {
        // Ya no hay ArrayList inventados o creados
        vm = new VMenu();
        vm.setVisible(true);
    }
      
    public static void alta() 
    {
        vm.setVisible(false);
        v = new Ventana();
        v.setVisible(true);
    }
    
    public static void registrarPersona(String n, Integer e, String pr, String t)throws Exception
    {
         miPersonaDAO = new PersonaDAO();
         
         Persona miPersona=new Persona();

         miPersona.setNombrePersona(n);
         miPersona.setEdadPersona(e);
         miPersona.setProfesionPersona(pr);
         miPersona.setTelefonoPersona(t);

         miPersonaDAO.registrarPersona(miPersona);
         v.dispose();
         vm.setVisible(true);

    }
    
    public static void salir()
    {
        v.dispose();
        vm.setVisible(true);
    }
    
    public static void terminar()
    {
        System.exit(0);
    }
    
    public static boolean isSiguiente()
    {
        if (posicion == listaPersonas.size()-1)
            return false;
        return true;
    }
    
    public static boolean isAnterior()
    {
        if (posicion == 0)
            return false;
        return true;
    }
    
    public static void obtenerRegistros() throws Exception
    {
        miPersonaDAO = new PersonaDAO();

        //Se obtiene la lista de personas
        listaPersonas = miPersonaDAO.listaDePersonas();
        //se valida si se obtubo o no informacion
        if (listaPersonas.size()>0) 
        {
            // Paso a la ventana los datos del primero
            posicion = 0;
            v = new Ventana(listaPersonas.get(0).getNombrePersona(),listaPersonas.get(0).getEdadPersona(),listaPersonas.get(0).getProfesionPersona(),listaPersonas.get(0).getTelefonoPersona());
            v.setVisible(true);
        }
        else
            throw new Exception("No hay personas");
 }
    
  public static String getSiguienteNombre()
  {
      posicion = posicion + 1;
      return listaPersonas.get(posicion).getNombrePersona();
  }
  
  public static Integer getSiguienteEdad()
  {
     return listaPersonas.get(posicion).getEdadPersona();
  }
   
  public static String getSiguienteProfesion()
  {
      return listaPersonas.get(posicion).getProfesionPersona();
  }
    
  public static String getSiguienteTelefono()
  {
      return listaPersonas.get(posicion).getTelefonoPersona();
  }
  
  public static String getAnteriorNombre()
  {
      posicion = posicion - 1;
      return listaPersonas.get(posicion).getNombrePersona();
  }
  
  public static Integer getAnteriorEdad()
  {
     return listaPersonas.get(posicion).getEdadPersona();
  }
   
  public static String getAnteriorProfesion()
  {
      return listaPersonas.get(posicion).getProfesionPersona();
  }
    
  public static String getAnteriorTelefono()
  {
      return listaPersonas.get(posicion).getTelefonoPersona();
  }
   
  public static void visualizar(Persona p)
  {
        System.out.println("Nombre Persona: "+p.getNombrePersona());
        System.out.println("Edad Persona: "+p.getEdadPersona());
        System.out.println("Profesión Persona: "+p.getProfesionPersona());
        System.out.println("Telefono Persona: "+p.getTelefonoPersona());
        System.out.println("*************************************************\n");
  }
    
    public static void buscarPersona(String nombre) throws Exception
    {
        miPersonaDAO = new PersonaDAO();
        
        Persona miPersona = miPersonaDAO.consultarPersona(nombre);
        //se valida que se encuentre la persona
        if (miPersona != null) 
        {
               visualizar(miPersona);
        }
        else
        {
          throw new Exception("Persona no encontrada");
        }
   }
}
