
package data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.TreeSet;

import business.FileNameConstants;

public class Escalador implements Serializable{

	private static final long serialVersionUID = -819014890345586134L;
	private String name;
	private char[] password;
	private LocalDate fechaDeNacimiento;
	private int logradas;
	private TreeSet <Ruta> retos;
	private TreeSet <Ruta> favoritos;
	private TreeSet <Ruta> achieveds;
	private String escaladaFavorita;
	private String direccionImagen;
	private double maximaDificultadLograda;


	public Escalador(String name, char[] password2){
		this.name = name;
		this.setPassword(password2);
		this.fechaDeNacimiento = LocalDate.of(1900, 1, 1);
		this.logradas = 0;
		this.retos = new TreeSet <Ruta>();
		this.favoritos = new TreeSet <Ruta>();
		this.achieveds = new TreeSet <Ruta>();
		this.escaladaFavorita = "not specified";
		this.direccionImagen = FileNameConstants.DEFAULT_USER_IMAGE;
		this.maximaDificultadLograda = 0.0;
	}



	public void removeFavorite(Ruta r) {
		this.favoritos.remove(r);
	}

	public void removeGoal(Ruta r) {
		this.retos.remove(r);
	}

	public void putFavoriteRoute(Ruta route) {
		favoritos.add(route);
	}

	public void putGoalRoute(Ruta route) {
		achieveds.add(route);
	}

	public void putAchievedsRoute(Ruta route) {
		achieveds.add(route);
		if (route.getDificultad()>this.maximaDificultadLograda)
			this.maximaDificultadLograda = route.getDificultad();
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
	public TreeSet <Ruta> getRetos() {
		return retos;
	}
	public void setRetos(TreeSet <Ruta> retos) {
		this.retos = retos;
	}
	public TreeSet <Ruta> getFavoritos() {
		return favoritos;
	}
	public void setFavoritos(TreeSet <Ruta> favoritos) {
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

	public TreeSet <Ruta> getAchieveds() {
		return achieveds;
	}

	public void setAchieveds(TreeSet <Ruta> logrados) {
		this.achieveds = logrados;
	}
}
