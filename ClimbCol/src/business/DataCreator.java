package business;

import java.util.ArrayList;
import java.util.TreeSet;

import data.*;

public class DataCreator {

	private TreeSet<Park> parks;

	public DataCreator(TreeSet<Park> parks) {
		super();
		this.parks = parks;

	}

	public void createPark(ArrayList<String> parkInfo) {
		Park p = new Park (parkInfo.get(0),parkInfo.get(1),parkInfo.get(2),parkInfo.get(3),
				parkInfo.get(4),parkInfo.get(5),parkInfo.get(6));
		parks.add(p);
	}	

	public void createZone(ArrayList<String> zoneInfo, Park park) {
		Zone z = new Zone (zoneInfo.get(0),zoneInfo.get(1));
		park.addZone(z);
	}

	public void createRoute(ArrayList<String> routeInfo, Zone zone) {
		Route r = new Route(routeInfo.get(0));
		r.setDifficulty(Double.parseDouble(routeInfo.get(1).trim()));
		r.setNumberOfPlates(Integer.parseInt(routeInfo.get(2).trim()));
		r.setRouteType(routeInfo.get(3));
		r.setHeight(routeInfo.get(4));
                r.setImagePath(routeInfo.get(5));
		zone.addRoute(r);
	}

	public void editPark(ArrayList<String> parkImage, Park park) {
		park.addImage(parkImage.get(0));

	}

	public void editZone(ArrayList<String> info, Zone zone) {
		zone.setImagePath(info.get(0));
	}	

	public TreeSet<Park> getParks() {
		return parks;
	}

	public void setParks(TreeSet<Park> parks) {
		this.parks = parks;
	}

	public void save() {
		DataSerializer.serializeParks(this.parks);
	}
}
