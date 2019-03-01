
package t6p1e2;

import Excepciones.*;
import Modelo.Alumno;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class T6p1e2 {

    public static void main(String[] args) {
        try
        {
            ArrayList<Alumno> listaClase;
            listaClase = obtenerDatosAlumnos();
            buscarPorCodigo(listaClase);
        }
        catch(Exception e)
        {
            System.out.println("Problemas");
        }
    }
    
    
    public static void buscarPorCodigo(ArrayList<Alumno> lista){
        String codigo = JOptionPane.showInputDialog("Teclea el código del alumno");
        // Validar
        int x;
        for(x = 0; x < lista.size() && lista.get(x).getCodigo().equals(codigo)== false; x++){}
        if( x == lista.size())
            JOptionPane.showMessageDialog(null,"Alumno no encontrado");
        else
            JOptionPane.showMessageDialog(null,"Objeto alumno: " + lista.get(x) + "\n" + lista.get(x).toString());
            
    }
    
    public static ArrayList<Alumno> obtenerDatosAlumnos(){
        ArrayList<Alumno> lista = new ArrayList();
        do
        {
            try
            {
                String codigo = JOptionPane.showInputDialog("Teclea el código del alumno");
                validarCodigo(codigo);
                String nombre = JOptionPane.showInputDialog("Teclea el nombre del alumno");
                validarNombre(nombre);
                String domicilio = JOptionPane.showInputDialog("Teclea el domicilio del alumno");
                validarDomicilio(domicilio);
                String telefono = JOptionPane.showInputDialog("Teclea el teléfono del alumno");
                validarTelefono(telefono);
            
                Alumno a = new Alumno(codigo,nombre,domicilio,telefono);
                lista.add(a);
            }
            catch(DatoNoValido e){
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
            catch(Exception e)
            {
                System.out.println("Problemas");
            }
        }
        while(JOptionPane.showConfirmDialog(null,"¿ Hay más alumnos en clase?")==0);
        return lista;
    }
    
    public static void validarCodigo(String codigo)throws Exception{
        // Cinco dígitos numéricos
        boolean error=false;
        if (codigo.length()!= 5)
            error = true;
        else
            for (int x = 0; x < codigo.length() && error == false;x++)
                if (Character.isAlphabetic(codigo.charAt(x)))
                    error = true;
        if (error)
            throw new DatoNoValido(1);
                    
    }
    
    public static void validarNombre(String nombre)throws Exception{
        // Todo letras
        boolean error=false;
        if (nombre.length()<= 2)
            error = true;
        else
            for (int x = 0; x < nombre.length() && error == false;x++)
                if (Character.isDigit(nombre.charAt(x)))
                    error = true;
        if (error)
            throw new DatoNoValido(2);
                    
    }
    
    public static void validarDomicilio(String domicilio)throws Exception{
        // c/aaa 999 9a
        boolean error=false;
        if (domicilio.length()<= 10)
            error = true;
        else
        {
            if (domicilio.charAt(0)!= 'c' || domicilio.charAt(1)!='/')
                error = true;
            else
            {
                String calle = domicilio.substring(2, domicilio.indexOf(" "));
                for (int x = 0; x < calle.length() && error == false;x++)
                    if (Character.isDigit(calle.charAt(x)))
                        error = true;
                
                if (!error)
                {
                    String numero = domicilio.substring(domicilio.indexOf(" ")+1, domicilio.lastIndexOf(" "));
                    for (int x = 0; x < numero.length() && error == false;x++)
                        if (Character.isAlphabetic(numero.charAt(x)))
                            error = true;
                    if (!error)
                        if (Character.isAlphabetic(domicilio.charAt(domicilio.lastIndexOf(" ")+1)) || Character.isDigit(domicilio.charAt(domicilio.length()-1)))
                            error = true;
                }
                
            }
        }
        if (error)
            throw new DatoNoValido(3);
                    
    }
    
    public static void validarTelefono(String telefono) throws Exception{
        // 9 digitos numéricos empezando por 6, 7 , 8 o 9
        boolean error=false;
        if (telefono.length()!= 9)
            error = true;
        else
            if (telefono.charAt(0)!= '6' && telefono.charAt(0)!= '7' && telefono.charAt(0)!= '8' && telefono.charAt(0)!= '9' )
                error = true;
            else
                for (int x = 0; x < telefono.length() && error == false;x++)
                    if (Character.isAlphabetic(telefono.charAt(x)))
                        error = true;
        if (error)
            throw new DatoNoValido(4);
    }
}
