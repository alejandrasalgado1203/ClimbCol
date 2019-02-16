
package data;

import java.util.TreeSet;

public class Zona {
    
    private String nombre;
    private double dificultadMax;
    private double dificultadMin;
    private double dificultadPromedio;
    private String direccionImagen;
    private TreeSet <Ruta> rutas;
    
    public Zona(String nombre, double dificultadMax, double dificultadMin,
			String direccionImagen) {
        super();
        this.nombre = nombre;
        this.dificultadMax = dificultadMax;
        this.dificultadMin = dificultadMin;
        this.direccionImagen = direccionImagen;
        rutas = new TreeSet<Ruta>();
    }

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
    public String getDireccionImagen() {
            return direccionImagen;
    }
    public void setDireccionImagen(String direccionImagen) {
            this.direccionImagen = direccionImagen;
    }
    
    
}
