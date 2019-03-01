/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication36;

/**
 *
 * @author Usuario
 */
public class Persona {
private String colorPelo, colorOjos;
private double altura, peso;
 
 public Persona(String pColorPelo, String pColorOjos, double pAltura, double pPeso){
     colorPelo=pColorPelo;
     colorOjos=pColorOjos;
     altura=pAltura;
     peso=pPeso;
     
    }

    public String getColorPelo() {
        return colorPelo;
    }

    public void setColorPelo(String colorPelo) {
        this.colorPelo = colorPelo;
    }
        
    public String getColorOjos() {
        return colorOjos;
    }

    public void setColorOjos(String colorOjos) {
        this.colorOjos = colorOjos;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
}

