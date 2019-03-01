/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danielbarragues;

import ModeloBDD.AccesoBDD;
import Vista.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 1gprogexa20
 */
public class DanielBarragues {
    
    public static AccesoBDD acceso = new AccesoBDD();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Para ahorrar tiempo he usado un JOption pane
        switch(Integer.parseInt(JOptionPane.showInputDialog("Operaciones permitidas\n1.-Alta de alumnos\n2.-Consultas de profesores\n3.-Salir"))){
            case 1:
                AltaAlumnos Alta= new AltaAlumnos();
                Alta.setVisible(true);
            break;
            case 2:
                ConsultasdeProfesores Consulta = new ConsultasdeProfesores();
                Consulta.setVisible(true);
            break;
            case 3:
                System.exit(0);
            break;
        }
        
        
    } 
    
    public static void IntroducirAlumnosBDD(String dni, String nombre, String asignatura, String asignatura2) throws SQLException, Exception{
        acceso.InsertarAlumno(dni, nombre);
        IntroducirAsignaturaAlumno(dni, asignatura, asignatura2);
    }
    
    public static void IntroducirAsignaturaAlumno(String dni, String asignatura, String asignatura2) throws SQLException, Exception{
        acceso.InsertarAsignaturaAlumno(dni, asignatura);
        if (asignatura2 != "Seleccionar"){
            acceso.InsertarAsignaturaAlumno(dni, asignatura2);
        }
    }
    
    public static ArrayList Consultar(String nombre, String tipo) throws Exception{
        if(tipo == "alumnos"){
            ArrayList array = acceso.ConsultaAlumnos(nombre);
            return array;
        }else{
            ArrayList array = acceso.ConsultaAsignatura(nombre);
            return array;
        }
    }
}
