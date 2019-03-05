package business;

import java.util.ArrayList;
import java.util.TreeSet;

import data.*;

public class CreadorDeDatos {

	private TreeSet<Parque> parques;

	public CreadorDeDatos(TreeSet<Parque> parques) {
		super();
		this.parques = parques;

	}

	public void createPark(ArrayList<String> park) {
		Parque p = new Parque (park.get(0),park.get(1),park.get(2),park.get(3),
				park.get(4),park.get(5),park.get(6));
		parques.add(p);
	}	

	public void createZone(ArrayList<String> zone, Parque parque) {
		Zona z = new Zona (zone.get(0),zone.get(1));
		parque.addZone(z);
	}

	public void createRute(ArrayList<String> list, Zona zone) {
		Ruta r = new Ruta(list.get(0));
		r.setDificultad(Double.parseDouble(list.get(1).trim()));
		r.setNumeroDeChapas(Integer.parseInt(list.get(2).trim()));
		r.setTipoDeRuta(list.get(3));
		r.setAltura(list.get(4));
		zone.addRuta(r);
	}

	public void editPark(ArrayList<String> park, Parque parque) {
		parque.addImage(park.get(0));

	}

	public void editZone(ArrayList<String> info, Zona zone) {
		zone.addImage(info.get(0));
	}	

	public TreeSet<Parque> getParques() {
		return parques;
	}

	public void setParques(TreeSet<Parque> parques) {
		this.parques = parques;
	}

	public void save() {
		DataSerializer.serializeParks(this.parques);
	}
}
