
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
                validar(1,codigo,"^[0-9]{5}$");
                String nombre = JOptionPane.showInputDialog("Teclea el nombre del alumno");
                validar(2,nombre,"^[A-Z][a-z]{2,}$");
                String domicilio = JOptionPane.showInputDialog("Teclea el domicilio del alumno");
                validar(3,domicilio,"^c/[A-Za-z]*[ ][0-9]{1,3}[ ][0-9][a-z]$");
                String telefono = JOptionPane.showInputDialog("Teclea el teléfono del alumno");
                validar(4,telefono,"^[6789][0-9]{8}$");
            
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
    
    public static void validar(int n,String dato,String regex)throws Exception{
        Pattern patron = Pattern.compile(regex);
        Matcher m = patron.matcher(dato);
        if (!m.matches())
            throw new DatoNoValido(n);
                    
    }
}
