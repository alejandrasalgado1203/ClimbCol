
package data;

import business.FileNameConstants;
import java.io.Serializable;

public class Route implements Serializable,Comparable<Route>,Renderable{

	private static final long serialVersionUID = 8944754339534154430L;
	private String name;
	private double difficulty;
	private int numberOfPlates;
	private String routeType;
	private String height;
	private Zone zone;
	private String imagePath;

	public Route(String name) {
		super();
		this.name = name;
	}

	public String getImagePath(){
		return imagePath;
	}
	public void setImagePath(String imagePath){
		this.imagePath = imagePath;
	}
	@Override
	public String getMainImage() {
		return FileNameConstants.ROUTES_ICON;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(double difficulty) {
		this.difficulty = difficulty;
	}
	public int getNumberOfPlates() {
		return numberOfPlates;
	}
	public void setNumberOfPlates(int numberOfPlates) {
		this.numberOfPlates = numberOfPlates;
	}
	public String getRouteType() {
		return routeType;
	}
	public void setRouteType(String routeType) {
		this.routeType = routeType;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public Zone getZone() {
		return zone;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Route o) {
		return name.compareTo(o.getName());
	}
}
