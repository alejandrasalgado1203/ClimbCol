
package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

public class Zona implements Serializable,NameImageGiver{

	private static final long serialVersionUID = 8176465641263408346L;
	private String name;
	private double dificultadMax;
	private double dificultadMin;
	private double dificultadPromedio;
	private ArrayList<String> direccionImagenes;
	private TreeMap <String,Ruta> rutas;
	private Parque parque;   


	public Zona(String name, String direccionImagen) {
		super();
		this.name = name;
		this.direccionImagenes = new ArrayList<String>();
		this.direccionImagenes.add(direccionImagen);
		this.dificultadMax = Integer.MIN_VALUE;
		this.dificultadMin = Integer.MAX_VALUE;
		this.dificultadPromedio = 0;
		this.rutas = new TreeMap <String,Ruta>();
	}

	public void putRuta(Ruta r) {
		this.rutas.put(r.getName(), r);
		r.setZona(this);
		this.actualizeDificult(r.getDificultad());
	}

	public void addImage(String string) {
		this.direccionImagenes.add(string);
	}

	public Ruta getRuta(String s) {
		return this.rutas.get(s);
	}

	private void actualizeDificult(double dificultad) {
		if(this.dificultadMax<dificultad)this.dificultadMax = dificultad;
		if(this.dificultadMin>dificultad)this.dificultadMin = dificultad;
		double sum = 0;
		for (Ruta r : this.rutas.values()) {
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
	public ArrayList<String> getDireccionImagen() {
		return direccionImagenes;
	}
	public void setDireccionImagen(ArrayList<String> direccionImagen) {
		this.direccionImagenes = direccionImagen;
	}
	public TreeMap<String, Ruta> getRutas() {
		return rutas;
	}
	public void setRutas(TreeMap<String, Ruta> rutas) {
		this.rutas = rutas;
	}
	public Parque getParque() {
		return parque;
	}
	public void setParque(Parque parque) {
		this.parque = parque;
	}

	@Override
	public String getMainImage() {
		// TODO Auto-generated method stub
		return null;
	}
}
