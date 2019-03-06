
package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeSet;

public class Zona implements Serializable,Comparable<Zona>,NameImageGiver{

	private static final long serialVersionUID = 8176465641263408346L;
	private String name;
	private double dificultadMax;
	private double dificultadMin;
	private double dificultadPromedio;
	private String direccionImagenes;
	private TreeSet <Ruta> rutas;
	private Parque parque;   


	public Zona(String name, String direccionImagen) {
		super();
		this.name = name;
		this.direccionImagenes=direccionImagen;
		this.dificultadMax = Integer.MIN_VALUE;
		this.dificultadMin = Integer.MAX_VALUE;
		this.dificultadPromedio = 0;
		this.rutas = new TreeSet <Ruta>();
	}

	public void addRuta(Ruta r) {
		this.rutas.add(r);
		r.setZona(this);
		this.actualizeDificult(r.getDificultad());
	}

	public void addImage(String string) {
		this.direccionImagenes = string;
	}

	public String getMainImage() {
		return this.direccionImagenes;
	}

	private void actualizeDificult(double dificultad) {
		if(this.dificultadMax<dificultad)this.dificultadMax = dificultad;
		if(this.dificultadMin>dificultad)this.dificultadMin = dificultad;
		double sum = 0;
		for (Ruta r : this.rutas) {
			sum+=r.getDificultad();
		}
		this.dificultadPromedio = sum/this.rutas.size();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDificultadMax() {
		return dificultadMax;
	}
	public void setDificultadMax(double dificultadMax) {
		this.dificultadMax = dificultadMax;
	}
	public double getDificultadMin() {
		return dificultadMin;
	}
	public void setDificultadMin(double dificultadMin) {
		this.dificultadMin = dificultadMin;
	}
	public double getDificultadPromedio() {
		return dificultadPromedio;
	}
	public void setDificultadPromedio(double dificultadPromedio) {
		this.dificultadPromedio = dificultadPromedio;
	}
	public String getDireccionImagen() {
		return direccionImagenes;
	}
	public void setDireccionImagen(String direccionImagen) {
		this.direccionImagenes = direccionImagen;
	}
	public TreeSet <Ruta> getRutas() {
		return rutas;
	}
	public void setRutas(TreeSet <Ruta> rutas) {
		this.rutas = rutas;
	}
	public Parque getParque() {
		return parque;
	}
	public void setParque(Parque parque) {
		this.parque = parque;
	}

	@Override
	public String toString() {
		return name ;
	}

	@Override
	public int compareTo(Zona o) {
		return name.compareTo(o.getName());
	}


}
