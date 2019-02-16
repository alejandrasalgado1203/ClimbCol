
package data;

import java.time.LocalDate;
import java.util.TreeSet;

public class Escalador {
    
    private String usuario;
    private LocalDate fechaDeNacimiento;
    private TreeSet<Ruta> logradas;
    private TreeSet<Ruta> retos;
    private TreeSet<Ruta> favoritos;
    private String escaladaFavorita;
    private String direccionImagen;
            
    public Escalador(String usuario, LocalDate fechaDeNacimiento, String escaladaFavorita, String direccionImagen) {
        super();
        this.usuario = usuario;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.escaladaFavorita = escaladaFavorita;
        this.direccionImagen = direccionImagen;
        logradas = new TreeSet<Ruta>();
        retos = new TreeSet<Ruta>();
        favoritos = new TreeSet<Ruta>();
    }
    
    public String getUsuario() {
            return usuario;
    }
    public void setUsuario(String usuario) {
            this.usuario = usuario;
    }
    public LocalDate getFechaDeNacimiento() {
            return fechaDeNacimiento;
    }
    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
            this.fechaDeNacimiento = fechaDeNacimiento;
    }
    public String getEscaladaFavorita() {
            return escaladaFavorita;
    }
    public void setEscaladaFavorita(String escaladaFavorita) {
            this.escaladaFavorita = escaladaFavorita;
    }
    public String getDireccionImagen() {
            return direccionImagen;
    }
    public void setDireccionImagen(String direccionImagen) {
            this.direccionImagen = direccionImagen;
    }
    
}
