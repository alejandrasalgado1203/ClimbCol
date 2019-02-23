
package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

public class Parque implements Serializable{
                    
    private String nombre;        
    private String ubicacion;
    private String linkUbicacion;
    private String temperaturaPromedio;
    private String campeonato;
    private String linkParque;
    private ArrayList<String> direccionImagenes;
    private TreeMap<String,Zona> zonas;
    
    
    
    
	public Parque() {
		super();
		Random rand = new Random();
		zonas = new TreeMap<String,Zona>();
		zonas.put("prueba zonas"+rand.nextInt(30) , new Zona());
		zonas.put("prueba zonas"+rand.nextInt(30), new Zona());
		zonas.put("prueba zonas"+rand.nextInt(30), new Zona());
		
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
