package business;

import java.util.ArrayList;
import java.util.TreeSet;

import data.*;

public class ClimbColManager {

	private static TreeSet<Park> parks;


	public static ArrayList<Route> getAllRoutes() {
		TreeSet<Route> routes = new TreeSet<Route>();
		for (Park p : parks) {
			for (Zone z : p.getZones()) {
				routes.addAll(z.getRoutes());
			}
		}
		return new ArrayList<Route> (routes);
	}

	public static TreeSet<Park> getParks() {
		return parks;
	}

	public static void setParks(TreeSet<Park> parks) {
		ClimbColManager.parks = parks;
	}

}
