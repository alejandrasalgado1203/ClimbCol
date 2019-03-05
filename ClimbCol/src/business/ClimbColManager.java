package business;

import java.util.ArrayList;
import java.util.TreeSet;

import data.*;

public class ClimbColManager {

	private static TreeSet<Parque> parks;


	public static ArrayList<Ruta> getAllRutes() {
		TreeSet<Ruta> rutes = new TreeSet<Ruta>();
		for (Parque p : parks) {
			for (Zona z : p.getZonas()) {
				rutes.addAll(z.getRutas());
			}
		}
		return new ArrayList<Ruta> (rutes);
	}

	public static TreeSet<Parque> getParks() {
		return parks;
	}

	public static void setParks(TreeSet<Parque> parques) {
		ClimbColManager.parks = parques;
	}

}
