
package data;

import java.io.Serializable;
import java.util.TreeSet;
import java.text.DecimalFormat;

public class Zone implements Serializable,Comparable<Zone>,Renderable{

	private static final long serialVersionUID = 8176465641263408346L;
	private String name;
	private double maxDifficulty;
	private double minDifficulty;
	private double averageDifficulty;
	private String imagePath;
	private TreeSet <Route> routes;
	private Park park;   


	public Zone(String name, String imagePath) {
		super();
		this.name = name;
		this.imagePath = imagePath;
		this.maxDifficulty = Integer.MIN_VALUE;
		this.minDifficulty = Integer.MAX_VALUE;
		this.averageDifficulty = 0;
		this.routes = new TreeSet <Route>();
	}

	public void addRoute(Route r) {
		this.routes.add(r);
		r.setZone(this);
		this.actualizeDifficulty(r.getDifficulty());
	}

	public String getMainImage() {
		return this.imagePath;
	}

	private void actualizeDifficulty(double difficulty) {
		if(this.maxDifficulty<difficulty)this.maxDifficulty = difficulty;
		if(this.minDifficulty>difficulty)this.minDifficulty = difficulty;
		double sum = 0;
		for (Route r : this.routes) {
			sum+=r.getDifficulty();
		}
		this.averageDifficulty = sum/this.routes.size();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMaxDifficulty() {
		return maxDifficulty;
	}
	public void setMaxDifficulty(double maxDifficulty) {
		this.maxDifficulty = maxDifficulty;
	}
	public double getMinDifficulty() {
		return minDifficulty;
	}
	public void setMinDifficulty(double minDifficulty) {
		this.minDifficulty = minDifficulty;
	}
	public double getAverageDifficulty() {
		return averageDifficulty;
	}
	public void setAverageDifficulty(double averageDifficulty) {
		this.averageDifficulty = averageDifficulty;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public TreeSet <Route> getRoutes() {
		return routes;
	}
	public void setRoutes(TreeSet <Route> routes) {
		this.routes = routes;
	}
	public Park getPark() {
		return park;
	}
	public void setPark(Park park) {
		this.park = park;
	}

	@Override
	public String toString() {
		return name ;
	}

	@Override
	public int compareTo(Zone o) {
		return name.compareTo(o.getName());
	}


}
