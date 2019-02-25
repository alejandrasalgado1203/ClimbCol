
package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

public class Parque implements Serializable,ChoosableByName{

	private static final long serialVersionUID = -1715829727108363741L;
	private String name;        
	private String ubicacion;
	private String linkUbicacion;
	private String temperaturaPromedio;
	private String campeonato;
	private String linkParque;
	private ArrayList<String> direccionImagenes;
	private TreeMap<String,Zona> zonas;


	public Parque(String name, String ubicacion, String linkUbicacion, String temperaturaPromedio, String campeonato,
			String linkParque, String direccionImagen) {
		super();
		this.name = name;
		this.ubicacion = ubicacion;
		this.linkUbicacion = linkUbicacion;
		this.temperaturaPromedio = temperaturaPromedio;
		this.campeonato = campeonato;
		this.linkParque = linkParque;
		this.direccionImagenes = new ArrayList<String> ();
		this.direccionImagenes.add(direccionImagen);
		this.zonas = new TreeMap<String,Zona> ();
	}

	public void putZone(Zona z) {
		this.zonas.put(z.getName(), z);
		z.setParque(this);
	}

	public Zona getZona(String string) {
		return this.zonas.get(string);
	}

	public void addImage(String string) {
		this.direccionImagenes.add(string);
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
	public String getCampeonato() {
		return campeonato;
	}
	public void setCampeonato(String campeonato) {
		this.campeonato = campeonato;
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
	public TreeMap<String, Zona> getZonas() {
		return zonas;
	}
	public void setZonas(TreeMap<String, Zona> zonas) {
		this.zonas = zonas;
	}
}
