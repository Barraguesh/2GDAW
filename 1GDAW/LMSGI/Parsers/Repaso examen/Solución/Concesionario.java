
package repasodom;

import java.util.ArrayList;


public class Concesionario {

    private Integer codigo;
    private String nombre;
    private String direccion;
    private ArrayList<Coche> coches;
    
    public Concesionario() {
    }

    public Concesionario(Integer codigo, String nombre, String direccion, ArrayList<Coche> coches) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.coches = coches;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Coche> getCoches() {
        return coches;
    }

    public void setCoches(ArrayList<Coche> coches) {
        this.coches = coches;
    }

    @Override
    public String toString() {
        return "Concesionario{" + "codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + ", coches=" + coches.toString() + '}';
    }
    
    
}
