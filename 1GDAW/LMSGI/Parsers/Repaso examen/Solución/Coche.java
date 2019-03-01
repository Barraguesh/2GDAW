
package repasodom;


public class Coche {
    
    private String color;
    private String marca;
    private String modelo;
    private Integer potencia;

    public Coche() {
    }

    public Coche(String color, String marca, String modelo, Integer potencia) {
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "Coche{" + "color=" + color + ", marca=" + marca + ", modelo=" + modelo + ", potencia=" + potencia + '}';
    }
    
    
}
