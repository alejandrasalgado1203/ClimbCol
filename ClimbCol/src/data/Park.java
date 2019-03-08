
package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeSet;

public class Park implements Serializable,Comparable<Park>,Renderable{

	private static final long serialVersionUID = -1715829727108363741L;
	private String name;        
	private String location;
	private String linkLocation;
	private String averageTemperature;
	private String altitude;
	private String linkPatk;
	private ArrayList<String> imagesPaths;
	private TreeSet<Zone> zones;


	public Park(String name, String location, String linkLocation, String averageTemperature, String altitude,
			String linkPark, String imagePath) {
		super();
		this.name = name;
		this.location = location;
		this.linkLocation = linkLocation;
		this.averageTemperature = averageTemperature;
		this.altitude = altitude;
		this.linkPatk = linkPark;
		this.imagesPaths = new ArrayList<String> ();
		this.imagesPaths.add(imagePath);
		this.zones = new TreeSet<Zone> ();
	}

	public Park(String string, String string2) {
		this.name = string;
		this.imagesPaths = new ArrayList<String> ();
		this.imagesPaths.add(string2);
		this.zones = new TreeSet<Zone> ();
	}

	public void addZone(Zone z) {
		this.zones.add(z);
		z.setPark(this);
	}

	public void addImage(String string) {
		this.imagesPaths.add(string);
	}

	public String getMainImage() {
		for (String string : imagesPaths) {
			if (string.contains("main"))return string;
		}
		return this.imagesPaths.get(0);
	}

	//getters y setters 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLinkLocation() {
		return linkLocation;
	}
	public void setLinkLocation(String linkLocation) {
		this.linkLocation = linkLocation;
	}
	public String getAverageTemperature() {
		return averageTemperature;
	}
	public void setAverageTemperature(String averageTemperature) {
		this.averageTemperature = averageTemperature;
	}
	public String getAltitude() {
		return altitude;
	}
	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}
	public String getLinkPatk() {
		return linkPatk;
	}
	public void setLinkPatk(String linkPatk) {
		this.linkPatk = linkPatk;
	}
	public ArrayList<String> getImagesPaths() {
		return imagesPaths;
	}
	public void setImagesPaths(ArrayList<String> imagesPaths) {
		this.imagesPaths = imagesPaths;
	}
	public TreeSet<Zone> getZones() {
		return zones;
	}
	public void setZones(TreeSet<Zone> zones) {
		this.zones = zones;
	}

	@Override
	public String toString() {
		return name ;
	}

	@Override
	public int compareTo(Park o) {
		return name.compareTo(o.getName());
	}


}
