
package data;

import java.io.Serializable;

public class Ruta implements Serializable,Comparable<Ruta>,NameImageGiver{

	private static final long serialVersionUID = 8944754339534154430L;
	private String name;
	private double dificultad;
	private int numeroDeChapas;
	private String tipoDeRuta;
	private String altura;
	private Zona zona;
        private String image;

	public Ruta(String name) {
		super();
		this.name = name;
	}

        public String getImage(){
            return image;
        }
        public void setImage(String image){
            this.image = image;
        }
	@Override
	public String getMainImage() {
		// TODO Auto-generated method stub
		return null;
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
	public int compareTo(Ruta o) {
		return name.compareTo(o.getName());
	}
}
