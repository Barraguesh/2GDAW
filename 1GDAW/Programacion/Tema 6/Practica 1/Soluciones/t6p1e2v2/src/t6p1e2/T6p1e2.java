
package t6p1e2;

import Excepciones.*;
import Modelo.Alumno;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        Pattern patron = Pattern.compile("^[0-9]{5}$");
        Matcher m = patron.matcher(codigo);
        if (!m.matches())
            throw new DatoNoValido(1);
                    
    }
    
    public static void validarNombre(String nombre)throws Exception{
        // Todo letras y como mínimo 3
        Pattern patron = Pattern.compile("^[A-Z][a-z]{2,}$");
        Matcher m = patron.matcher(nombre);
        if (!m.matches())
            throw new DatoNoValido(2);
                    
    }
    
    public static void validarDomicilio(String domicilio)throws Exception{
        // c/aaa 999 9a
       Pattern patron = Pattern.compile("^c/[a-z]*[ ][0-9]{1,3}[ ][0-9][a-z]$");
        Matcher m = patron.matcher(domicilio);
        if (!m.matches())
            throw new DatoNoValido(3);
                    
    }
    
    public static void validarTelefono(String telefono) throws Exception{
        // 9 digitos numéricos empezando por 6, 7 , 8 o 9
        Pattern patron = Pattern.compile("^[6789][0-9]{8}$");
        Matcher m = patron.matcher(telefono);
        if (!m.matches())
            throw new DatoNoValido(4);
    }
}
