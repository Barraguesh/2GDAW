
package ejemploparsers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Dia {
    
    
    
    private String fecha;
    private List periodos;
    private int uvMax;
    private int tempMax;
    private int tempMin;
    private int sensTermMax;
    private int sensTermMin;
    private int humMax;
    private int humMin;

    public Dia() {
        periodos = new ArrayList();
    }

    public Dia(String fecha, List periodos, int uvMax, int tempMax, int tempMin, int sensTermMax, int sensTermMin, int humMax, int humMin) {
        this.fecha = fecha;
        this.periodos = new ArrayList();
        this.uvMax = uvMax;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.sensTermMax = sensTermMax;
        this.sensTermMin = sensTermMin;
        this.humMax = humMax;
        this.humMin = humMin;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List getPeriodos() {
        return periodos;
    }

    public void setPeriodos(List periodos) {
        this.periodos = periodos;
    }

    public int getUvMax() {
        return uvMax;
    }

    public void setUvMax(int uvMax) {
        this.uvMax = uvMax;
    }

    public int getTempMax() {
        return tempMax;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
    }

    public int getTempMin() {
        return tempMin;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }

    public int getSensTermMax() {
        return sensTermMax;
    }

    public void setSensTermMax(int sensTermMax) {
        this.sensTermMax = sensTermMax;
    }

    public int getSensTermMin() {
        return sensTermMin;
    }

    public void setSensTermMin(int sensTermMin) {
        this.sensTermMin = sensTermMin;
    }

    public int getHumMax() {
        return humMax;
    }

    public void setHumMax(int humMax) {
        this.humMax = humMax;
    }

    public int getHumMin() {
        return humMin;
    }

    public void setHumMin(int humMin) {
        this.humMin = humMin;
    }



   

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(" - Predicciones Meteorológicas de Vitoria - ");
        sb.append("Día:" + getFecha());
        sb.append(" --> ");
        sb.append("Temperatura Max:" + getTempMax());
        sb.append("; ");
        sb.append("Temperatura Min:" + getTempMin());
        sb.append("; ");
        sb.append("Sensacion Térmica Max:" + getSensTermMax());
        sb.append("; ");
        sb.append("Sensacion Térmica Min:" + getSensTermMin());
        sb.append("; ");
        sb.append("Humedad Relativa Max:" + getHumMax());
        sb.append("; ");
        sb.append("Humedad Relativa Min:" + getHumMin());
        sb.append("; ");
        sb.append("UV Max:" + getUvMax());
        sb.append("\n");
        sb.append("Información por periodo:");
        Iterator it = getPeriodos().iterator();
        while (it.hasNext()) {
            Periodo p = (Periodo) it.next();
            sb.append("\n");
            sb.append(p.toString());
            sb.append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }
}
