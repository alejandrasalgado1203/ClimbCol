package business;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


import data.*;

public class CreadorDeDatos {

	private TreeMap<String, Parque> parques;

	public CreadorDeDatos(TreeMap<String, Parque> parques) {
		super();
		this.parques = parques;

	}


	public void createPark(ArrayList<String> park) {
		Parque p = new Parque (park.get(0),park.get(1),park.get(2),park.get(3),
				park.get(4),park.get(5),park.get(6));
		parques.put(p.getName(), p);

	}	

	public void createZone(ArrayList<String> zone) {
		Zona z = new Zona (zone.get(1),zone.get(2));
		this.getParque(zone.get(0)).putZone(z);
	}

	public void createRute(ArrayList<String> rute) {
		Ruta r = new Ruta(rute.get(2));
		r.setDificultad(Double.parseDouble(rute.get(3).trim()));
		r.setNumeroDeChapas(Integer.parseInt(rute.get(4).trim()));
		r.setTipoDeRuta(rute.get(5));
		r.setAltura(rute.get(6));
		this.getZone(rute.subList(0, 2)).putRuta(r);
	}


	public void editPark(ArrayList<String> park) {
		this.getParque(park.get(0)).addImage(park.get(1));

	}


	public void editZone(ArrayList<String> zone) {
		this.getZone(zone.subList(0, 2)).addImage(zone.get(2));
	}	


	public TreeMap<String, Parque> getParques() {
		return parques;
	}

	public void setParques(TreeMap<String, Parque> parques) {
		this.parques = parques;
	}



	public void save() {
		DataSerializer.serializeParks(this.parques);
	}

	private Parque getParque(String string) {
		return this.parques.get(string);
	}

	private Zona getZone(List<String> subList) {
		return parques.get(subList.get(0)).getZona(subList.get(1));
	}

}
