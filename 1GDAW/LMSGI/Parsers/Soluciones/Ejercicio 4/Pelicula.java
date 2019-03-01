
package ejemploparsers;


public class Pelicula {
    private String categoria;
    private String titulo;
    private String director;
    private int anyo;
    private int duracion;
    private String medida;

    public Pelicula(String categoria, String titulo, String director, int anyo, int duracion, String medida) {
        this.categoria = categoria;
        this.titulo = titulo;
        this.director = director;
        this.anyo = anyo;
        this.duracion = duracion;
        this.medida = medida;
    }

    public Pelicula() {
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }
    
        public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(" { Detalles de la película --");
        sb.append("Título:" + getTitulo());
        sb.append(", ");
        sb.append("Categoría:" + getCategoria());
        sb.append(", ");
        sb.append("Director:" + getDirector());
        sb.append(", ");
        sb.append("Año:" + getAnyo());
        sb.append(", ");
        sb.append("Duración:" + getDuracion() + getMedida());
        sb.append(". } \n");

        return sb.toString();
    }
}
