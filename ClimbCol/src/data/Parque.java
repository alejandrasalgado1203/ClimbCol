
package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeSet;

public class Parque implements Serializable,Comparable<Parque>,NameImageGiver{

	private static final long serialVersionUID = -1715829727108363741L;
	private String name;        
	private String ubicacion;
	private String linkUbicacion;
	private String temperaturaPromedio;
	private String altitud;
	private String linkParque;
	private ArrayList<String> direccionImagenes;
	private TreeSet<Zona> zonas;


	public Parque(String name, String ubicacion, String linkUbicacion, String temperaturaPromedio, String campeonato,
			String linkParque, String direccionImagen) {
		super();
		this.name = name;
		this.ubicacion = ubicacion;
		this.linkUbicacion = linkUbicacion;
		this.temperaturaPromedio = temperaturaPromedio;
		this.altitud = campeonato;
		this.linkParque = linkParque;
		this.direccionImagenes = new ArrayList<String> ();
		this.direccionImagenes.add(direccionImagen);
		this.zonas = new TreeSet<Zona> ();
	}

	public Parque(String string, String string2) {
		this.name = string;
		this.direccionImagenes = new ArrayList<String> ();
		this.direccionImagenes.add(string2);
		this.zonas = new TreeSet<Zona> ();
	}

	public void addZone(Zona z) {
		this.zonas.add(z);
		z.setParque(this);
	}

	public void addImage(String string) {
		this.direccionImagenes.add(string);
	}

	public String getMainImage() {
		for (String string : direccionImagenes) {
			if (string.contains("main"))return string;
		}
		return this.direccionImagenes.get(0);
	}

	//getters y setters 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getLinkUbicacion() {
		return linkUbicacion;
	}
	public void setLinkUbicacion(String linkUbicacion) {
		this.linkUbicacion = linkUbicacion;
	}
	public String getTemperaturaPromedio() {
		return temperaturaPromedio;
	}
	public void setTemperaturaPromedio(String temperaturaPromedio) {
		this.temperaturaPromedio = temperaturaPromedio;
	}
	public String getAltitud() {
		return altitud;
	}
	public void setAltitud(String altitud) {
		this.altitud = altitud;
	}
	public String getLinkParque() {
		return linkParque;
	}
	public void setLinkParque(String linkParque) {
		this.linkParque = linkParque;
	}
	public ArrayList<String> getDireccionImagenes() {
		return direccionImagenes;
	}
	public void setDireccionImagenes(ArrayList<String> direccionImagenes) {
		this.direccionImagenes = direccionImagenes;
	}
	public TreeSet<Zona> getZonas() {
		return zonas;
	}
	public void setZonas(TreeSet<Zona> zonas) {
		this.zonas = zonas;
	}

	@Override
	public String toString() {
		return name ;
	}

	@Override
	public int compareTo(Parque o) {
		return name.compareTo(o.getName());
	}


}
