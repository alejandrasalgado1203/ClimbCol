package business;

import java.util.ArrayList;
import java.util.TreeMap;


import data.Parque;

public class CreadorDeDatos {

	private TreeMap<String, Parque> parques;

	public CreadorDeDatos(TreeMap<String, Parque> parques) {
		super();
		this.parques = parques;
		
	}


	public void createPark(ArrayList<String> park) {
		System.out.println(park);

	}	

	public void createZone(ArrayList<String> zone) {
		System.out.println(zone);
	}

	public void createRute(ArrayList<String> rute) {
		System.out.println(rute);
		
	}


	public void editPark(ArrayList<String> park) {
		System.out.println(park);
		
	}


	public void editZone(ArrayList<String> zone) {
		System.out.println(zone);
		
	}	
	
	
	public TreeMap<String, Parque> getParques() {
		return parques;
	}

	public void setParques(TreeMap<String, Parque> parques) {
		this.parques = parques;
	}



	public void save() {
		// TODO Auto-generated method stub
		System.out.println("save");
	}


	

}
