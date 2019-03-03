
package data;

import java.io.Serializable;

public class Ruta implements Serializable,NameImageGiver{

	private static final long serialVersionUID = 8944754339534154430L;
	private String name;
	private double dificultad;
	private int numeroDeChapas;
	private String tipoDeRuta;
	private String altura;
	private Zona zona;

	public Ruta(String name) {
		super();
		this.name = name;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Zona getZona() {
		return zona;
	}
	public void setZona(Zona zona) {
		this.zona = zona;
	}


	@Override
	public String getMainImage() {
		// TODO Auto-generated method stub
		return null;
	}


}
