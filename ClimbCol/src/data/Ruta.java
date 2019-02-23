
package data;

import java.io.Serializable;

public class Ruta implements Serializable{
    
    private String nombre;
    private double dificultad;
    private int numeroDeChapas;
    private String tipoDeRuta;
    private String altura;
    private Zona zona;
    
    public Ruta(String nombre, double dificultad, int numeroDeChapas, String tipoDeRuta, String altura) {
        super();
        this.nombre = nombre;
        this.dificultad = dificultad;
        this.numeroDeChapas = numeroDeChapas;
        this.tipoDeRuta = tipoDeRuta;
        this.altura = altura;
    }

    public String getNombre() {
            return nombre;
    }
    public void setNombre(String nombre) {
            this.nombre = nombre;
    }
    public double getDificultad() {
            return dificultad;
    }
    public void setDificultad(double dificultad) {
            this.dificultad = dificultad;
    }
    public int getNumeroDeChapas() {
            return numeroDeChapas;
    }
    public void setNumeroDeChapas(int numeroDeChapas) {
            this.numeroDeChapas = numeroDeChapas;
    }
    public String getTipoDeRuta() {
            return tipoDeRuta;
    }
    public void setTipoDeRuta(String tipoDeRuta) {
            this.tipoDeRuta = tipoDeRuta;
    }
    public String getAltura() {
            return altura;
    }
    public void setAltura(String altura) {
            this.altura = altura;
    }

    
}
