package business;

import java.util.TreeMap;


import data.Parque;

public class CreadorDeDatos {

	private TreeMap<String, Parque> parques;

	public CreadorDeDatos(TreeMap<String, Parque> parques) {
		super();
		this.parques = parques;
	}



	public TreeMap<String, Parque> getParques() {
		return parques;
	}

	public void setParques(TreeMap<String, Parque> parques) {
		this.parques = parques;
	}
}
