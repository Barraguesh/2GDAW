/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1ArrayList;

/**
 *
 * @author Jon
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import javax.swing.JOptionPane;
public class Ejercicio1ArrayList {
static ArrayList <Double> Numeros = new ArrayList <Double> ();
   


//NumberFormat Exception
    public static void Datos() 
    {
        
        do
        {
            try{
            Numeros.add(Double.parseDouble(JOptionPane.showInputDialog("Introduce un numerito, puede tener desimales")));
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null,"Introduce un numero por favor");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Ha ocurrido un error "
                + e.getMessage());
            }
        }
        while (JOptionPane.showConfirmDialog(null, "Deseas continuar?")==0);
        
    }
    
    
    /*MAXIMOS Y MINIMOS*/
    
    
    public static void MaxMin() 
    {
        Numeros.sort(null);
        JOptionPane.showMessageDialog(null, Numeros.get(0)+" y "+Numeros.get((Numeros.size()-1)));
    }
    
    /*BUSCAR NUMERO Y MOSTRAR*/
    
    public static void Busq()   
    {
        double num = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero a buscar"));
        
        if (Numeros.contains(num))
        {
            JOptionPane.showMessageDialog(null,"Se ha encontrado el numero");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"No se ha encontrado el numero");
        }
        
    }
    /*BUSCAR NUMERO Y BORRAR*/
    public static void BusqDel()
    {
        
          double num = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero a buscar"));
        
        if (Numeros.contains(num))
        {
            
            int a = Numeros.indexOf(num);
            
            Numeros.remove(a);
            
            JOptionPane.showMessageDialog(null,"Se ha encontrado y borrado el numero");
            
        }
        else
        {
            JOptionPane.showMessageDialog(null,"No se ha encontrado el numero");
        }
        
    }
    /*Convertir ArrayList en Array*/
    
    public static void Conv()
    {
        
        Double [] numeros = Numeros.toArray(new Double[Numeros.size()]);
        
        String num = Arrays.toString(numeros);
        
        JOptionPane.showMessageDialog(null, num +"\n"+"Double [] numeros = Numeros.toArray(new Double[Numeros.size()]);\n" +
        "\n" +
        "String num = Arrays.toString(numeros);");
        
    }
    
    /*NUMERO DE ELEMENTOS*/
    
    public static void NumEle()
    {
        if(Numeros.size()>0){
        JOptionPane.showMessageDialog(null,Numeros.size()+"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis posuere diam odio, eget commodo tortor tempus ac. Suspendisse velit purus, laoreet in dapibus sed, auctor sit amet justo. Suspendisse fringilla enim metus, eget ultrices est ultricies in. Ut ac aliquet tellus, sed ultrices odio. Integer fermentum ornare nisi, quis congue nibh dignissim eget. Fusce nisi massa, maximus ut condimentum quis, pulvinar non libero. Phasellus pulvinar ligula eget quam iaculis convallis. Maecenas tincidunt, neque at eleifend fringilla, dui enim maximus ligula, in sollicitudin nulla nibh sed sapien. Mauris tristique dolor arcu, ut consectetur purus blandit vitae. Proin bibendum quis quam et cursus.");
        }
        else JOptionPane.showMessageDialog(null,"Esta vacio");
    }
    
    
    /*INSERTAR ELEMENTO*/
    
    public static void Add_Num()
    {
        
        Numeros.add(Double.parseDouble(JOptionPane.showInputDialog("Introduce un numero a añadir")));
        
    }
    
    /*ADD NUMBER IN POSITION*/
    
    public static void Add_Num_In_Pos()
    {
        
        Numeros.add(Integer.parseInt(JOptionPane.showInputDialog("Introduce la posicion en la que quieres introducir un numero"))
                , Double.parseDouble(JOptionPane.showInputDialog("Introduce el numero")));
        
    }
    
    /*DELETE NUMBER IN POSITION*/
    
    public static void Del_Num_In_Pos()
    {
        
        Numeros.remove(Integer.parseInt(JOptionPane.showInputDialog("Introduce la posicion de la cual quieres borrar un numero")));
        
    }
    
    
    /*SUMA Y MEDIA ARITMETICA*/
    
    public static void Sum_Med()
    {
        int cont = 0;
        double sum = 0;
        
        
        
        
        /* for (Double elemento : Numeros)
        {
        sum +=elemento;
        }*/
       Iterator <Double> suma = Numeros.iterator();
        while (suma.hasNext())
        {
            sum = sum + Numeros.get(cont);
            cont++;
        }
        
        double media = sum/Numeros.size();
        
        JOptionPane.showMessageDialog(null,"La suma de todos los elementos es "
                + sum + "\n"
                + "Y la media aritmética es " +media);
        
        
    }
    
    
    
    /*MAIN*/
    
    
    public static void main(String[] args) {
        
        Datos();
        boolean cont=true;
        
        do
        {
           try{
            int check = Integer.parseInt(JOptionPane.showInputDialog("1. Visualizar el valor maximo y el mınimo.\n" +
            "2. Solicitar un numero y buscarlo. \n" +
            "3. Solicitar un numero y buscarlo. Si se encuentra borrarlo. \n" +
            "4. Convertir el arrayList en un array.\n" +
            "5. Si no esta vacıo, mostrar el numero de elementos que contiene. \n" +
            "6. Insertar un nuevo elemento por el final.\n" +
            "7. Insertar un nuevo elemento en la posicion que te indique el usuario. \n" +
            "8. Borrar un elemento de una posicion concreta. \n" +
            "9. Calcular la suma y la media aritmetica de los valores contenidos. \n" +
           "10. Finalizar."));
            
            
            switch (check)
            {
                case 1:
                    
                    MaxMin();
                    
                break;
                case 2:
                
                    Busq();
                    
                break;
                case 3:
                    
                    BusqDel();
                    
                break; 
                case 4:
                
                    Conv();
                    
                break;
                case 5:
                    
                    NumEle();
                    
                break; 
                case 6:
                    
                    Add_Num();
                    
                break;  
                case 7:
                    
                    Add_Num_In_Pos();
                    
                break; 
                case 8:
                
                    Del_Num_In_Pos();
                
                break;
                case 9:
                    
                    Sum_Med();
                    
                break;   
                case 10:
                    
                    cont=false;
                    
                break;    
                default:
                    JOptionPane.showMessageDialog(null,"Introduce un valor valido");
                break;
            }
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null,"Introduce un numero por favor");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Ha ocurrido un error "+e.getMessage());
            }
         }
        while(cont==true);
        
        
        
        
        }
        
    }