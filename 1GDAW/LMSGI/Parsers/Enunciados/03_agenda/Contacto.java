
package ejemploparsers;


public class Contacto {
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;

    public Contacto(String nombre, String apellidos, String email, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
    }

    public Contacto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(" { Detalles del contacto --");
        sb.append("Nombre:" + getNombre());
        sb.append(", ");
        sb.append("Apellidos:" + getApellidos());
        sb.append(", ");
        sb.append("Email:" + getEmail());
        sb.append(", ");
        sb.append("Telefono:" + getTelefono());
        sb.append(". } \n");

        return sb.toString();
    }
}
