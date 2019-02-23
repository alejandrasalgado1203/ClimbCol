
package data;

import java.util.ArrayList;
import java.util.TreeMap;

public class Zona {
    
    private String nombre;
    private double dificultadMax;
    private double dificultadMin;
    private double dificultadPromedio;
    private ArrayList<String> direccionImagen;
    private TreeMap <String,Ruta> rutas;
    private Parque parque;
    
  

    public String getNombre() {
            return nombre;
    }
    public void setNombre(String nombre) {
            this.nombre = nombre;
    }
    public double getDificultadMax() {
            return dificultadMax;
    }
    public void setDificultadMax(double dificultadMax) {
            this.dificultadMax = dificultadMax;
    }
    public double getDificultadMin() {
            return dificultadMin;
    }
    public void setDificultadMin(double dificultadMin) {
            this.dificultadMin = dificultadMin;
    }
    public double getDificultadPromedio(double dificultadMin,double dificultadMax) {
            this.dificultadPromedio = ((dificultadMax + dificultadMin)/2);
            return dificultadPromedio;
    }
    public void setDificultadPromedio(double dificultadPromedio) {
            this.dificultadPromedio = dificultadPromedio;
    }
   
}
