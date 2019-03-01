/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioparserdom;

/**
 *
 * @author widemos
 */
public class CentroSalud {

    private String nombre;
    private String direccion;
    private String cp;
    private String localidad;
    private String provincia;
    private String servicios;

    public CentroSalud() {
    }

    public CentroSalud(String nombre, String direccion, String cp, String localidad, String provincia, String servicios) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cp = cp;
        this.localidad = localidad;
        this.provincia = provincia;
        this.servicios = servicios;
    }

    @Override
    public String toString() {
        return "CentroSalud {" + "\n  nombre=" + nombre + "\n  direccion=" + direccion + ", cp=" + cp + ", localidad=" + localidad + ", provincia=" + provincia + "\n  servicios=" + servicios + "\n}";
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the cp
     */
    public String getCp() {
        return cp;
    }

    /**
     * @param cp the cp to set
     */
    public void setCp(String cp) {
        this.cp = cp;
    }

    /**
     * @return the localidad
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * @param localidad the localidad to set
     */
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    /**
     * @return the provincia
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * @param provincia the provincia to set
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * @return the servicios
     */
    public String getServicios() {
        return servicios;
    }

    /**
     * @param servicios the servicios to set
     */
    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

}
