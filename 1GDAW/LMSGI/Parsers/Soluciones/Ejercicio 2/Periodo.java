
package ejemploparsers;


public class Periodo {
    
    private String codigo;
    private int precipitacion;
    private int cotaNieve;
    private String estadoCielo;
    private String descEstadoCielo;
    private String dirViento;
    private int velViento;
    private int rachaMax;
    private int tempPeriodo;
    private int sensTermPeriodo;
    private int humRelPeriodo;

    public Periodo() {
    }

    public Periodo(String codigo, int precipitacion, int cotaNieve, String estadoCielo, String descEstadoCielo, String dirViento, int velViento, int rachaMax, int tempPeriodo, int sensTermPeriodo, int humRelPeriodo) {
        this.codigo = codigo;
        this.precipitacion = precipitacion;
        this.cotaNieve = cotaNieve;
        this.estadoCielo = estadoCielo;
        this.descEstadoCielo = descEstadoCielo;
        this.dirViento = dirViento;
        this.velViento = velViento;
        this.rachaMax = rachaMax;
        this.tempPeriodo = tempPeriodo;
        this.sensTermPeriodo = sensTermPeriodo;
        this.humRelPeriodo = humRelPeriodo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getPrecipitacion() {
        return precipitacion;
    }

    public void setPrecipitacion(int precipitacion) {
        this.precipitacion = precipitacion;
    }

    public int getCotaNieve() {
        return cotaNieve;
    }

    public void setCotaNieve(int cotaNieve) {
        this.cotaNieve = cotaNieve;
    }

    public String getEstadoCielo() {
        return estadoCielo;
    }

    public void setEstadoCielo(String estadoCielo) {
        this.estadoCielo = estadoCielo;
    }

    public String getDescEstadoCielo() {
        return descEstadoCielo;
    }

    public void setDescEstadoCielo(String descEstadoCielo) {
        this.descEstadoCielo = descEstadoCielo;
    }

    public String getDirViento() {
        return dirViento;
    }

    public void setDirViento(String dirViento) {
        this.dirViento = dirViento;
    }

    public int getVelViento() {
        return velViento;
    }

    public void setVelViento(int velViento) {
        this.velViento = velViento;
    }

    public int getRachaMax() {
        return rachaMax;
    }

    public void setRachaMax(int rachaMax) {
        this.rachaMax = rachaMax;
    }

    public int getTempPeriodo() {
        return tempPeriodo;
    }

    public void setTempPeriodo(int tempPeriodo) {
        this.tempPeriodo = tempPeriodo;
    }

    public int getSensTermPeriodo() {
        return sensTermPeriodo;
    }

    public void setSensTermPeriodo(int sensTermPeriodo) {
        this.sensTermPeriodo = sensTermPeriodo;
    }

    public int getHumRelPeriodo() {
        return humRelPeriodo;
    }

    public void setHumRelPeriodo(int humRelPeriodo) {
        this.humRelPeriodo = humRelPeriodo;
    }
    
        public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Periodo: " + getCodigo());
        sb.append("; ");
        sb.append("Precipitación:" + getPrecipitacion());
        sb.append("; ");
        sb.append("Cota de nieve:" + getCotaNieve());
        sb.append("; ");
        sb.append("Descripción estado del cielo:" + getDescEstadoCielo());
        sb.append("; ");
        sb.append("Estado del cielo:" + getEstadoCielo());
        sb.append("; ");
        sb.append("Dirección del viento:" + getDirViento());
        sb.append("; ");
        sb.append("Velocidad del viento:" + getVelViento());
        sb.append("; ");
        sb.append("Racha Maxima:" + getRachaMax());
        sb.append("; ");
        sb.append("Temperatura:" + getTempPeriodo());
        sb.append("; ");
        sb.append("Sensación térmica:" + getSensTermPeriodo());
        sb.append("; ");
        sb.append("Humedad relativa:" + getHumRelPeriodo());
        sb.append(".");
        return sb.toString();
    }
    
    
}
