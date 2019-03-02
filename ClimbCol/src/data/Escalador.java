
package data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.TreeMap;

import business.FileNameConstants;

public class Escalador implements Serializable{

	private static final long serialVersionUID = -819014890345586134L;
	private String name;
	private char[] password;
	private LocalDate fechaDeNacimiento;
	private int logradas;
	private TreeMap<String,Ruta> retos;
	private TreeMap<String,Ruta> favoritos;
	private String escaladaFavorita;
	private String direccionImagen;
	private double maximaDificultadLograda;


	public Escalador(String name, char[] password2){
		this.name = name;
		this.setPassword(password2);
		this.fechaDeNacimiento = LocalDate.of(1900, 1, 1);
		this.logradas = 0;
		this.retos = new TreeMap<String,Ruta>();
		this.favoritos = new TreeMap<String,Ruta>();
		this.escaladaFavorita = "not specified";
		this.direccionImagen = FileNameConstants.DEFAULT_USER_IMAGE;
		this.maximaDificultadLograda = 0;
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
	public int getLogradas() {
		return logradas;
	}
	public void setLogradas(int logradas) {
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
		return new String(password);
	}
	public void setPassword(char[] password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "fecha De Nacimiento: " + fechaDeNacimiento + "\n escalada Favorita: " + escaladaFavorita
				+ "\n maxima Dificultad Lograda: " + maximaDificultadLograda ;
	}


}
