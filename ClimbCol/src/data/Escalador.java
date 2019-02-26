
package data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.TreeMap;

public class Escalador implements Serializable{

	private static final long serialVersionUID = -819014890345586134L;
	private String name;
	private String password;
	private LocalDate fechaDeNacimiento;
	private TreeMap<String,Ruta> logradas;
	private TreeMap<String,Ruta> retos;
	private TreeMap<String,Ruta> favoritos;
	private String escaladaFavorita;
	private String direccionImagen;
	private double maximaDificultadLograda;


	public Escalador(String name, String password){
		this.name = name;
		this.setPassword(password);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public TreeMap<String, Ruta> getLogradas() {
		return logradas;
	}
	public void setLogradas(TreeMap<String, Ruta> logradas) {
		this.logradas = logradas;
	}
	public TreeMap<String, Ruta> getRetos() {
		return retos;
	}
	public void setRetos(TreeMap<String, Ruta> retos) {
		this.retos = retos;
	}
	public TreeMap<String, Ruta> getFavoritos() {
		return favoritos;
	}
	public void setFavoritos(TreeMap<String, Ruta> favoritos) {
		this.favoritos = favoritos;
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
	public double getMaximaDificultadLograda() {
		return maximaDificultadLograda;
	}
	public void setMaximaDificultadLograda(double maximaDificultadLograda) {
		this.maximaDificultadLograda = maximaDificultadLograda;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
