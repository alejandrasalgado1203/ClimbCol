package business;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

import data.*;

public class ClimbColManager {

	private static TreeMap<String,Parque> parks;


	public static ArrayList<Ruta> getAllRutes() {
		TreeSet<Ruta> rutes = new TreeSet<Ruta>();
		for (Parque p : parks.values()) {
			for (Zona z : p.getZonas().values()) {
				rutes.addAll(z.getRutas().values());
			}
		}
		return new ArrayList<Ruta> (rutes);
	}

	public static Object[] getParksNames() {
		return parks.keySet().toArray();
	}

	public static Zona getZone(Parque p, String name) {
		return p.getZona(name);
	}

	public static Parque getPark(String name) {
		return parks.get(name);
	}

	public static Object[] getZonesNames(Parque p) {
		return p.getZonas().keySet().toArray();
	}

	public static TreeMap<String,Parque> getParks() {
		return parks;
	}

	public static void setParks(TreeMap<String,Parque> parks) {
		ClimbColManager.parks = parks;
	}

	public static Object[] getRutesNames(Zona zone) {
		return zone.getRutas().keySet().toArray();
	}

	public static Ruta getRute(Zona zone, String selectedValue) {
		return zone.getRuta(selectedValue);
	}

}
