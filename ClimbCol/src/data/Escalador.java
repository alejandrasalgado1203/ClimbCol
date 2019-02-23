
package data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.TreeMap;

public class Escalador implements Serializable{
    
    private String usuario;
    private LocalDate fechaDeNacimiento;
    private TreeMap<String,Ruta> logradas;
    private TreeMap<String,Ruta> retos;
    private TreeMap<String,Ruta> favoritos;
    private String escaladaFavorita;
    private String direccionImagen;
    private double maximaDificultadLograda;
            
  
	

	public void setMaximaDificultadLograda(int maximaDificultadLograda) {
		this.maximaDificultadLograda = maximaDificultadLograda;
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
