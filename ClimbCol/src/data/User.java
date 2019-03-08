
package data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.TreeSet;

import business.FileNameConstants;

public class User implements Serializable{

	private static final long serialVersionUID = -819014890345586134L;
	private String name;
	private char[] password;
	private LocalDate birthdate;
	private TreeSet <Route> goals;
	private TreeSet <Route> favorites;
	private TreeSet <Route> achieveds;
	private String favoriteClimbing;
	private String imagePath;
	private double maxDifficultyAchieved;


	public User(String name, char[] password2){
		this.name = name;
		this.setPassword(password2);
		this.birthdate = LocalDate.of(1900, 1, 1);
		this.goals = new TreeSet <Route>();
		this.favorites = new TreeSet <Route>();
		this.achieveds = new TreeSet <Route>();
		this.favoriteClimbing = "not specified";
		this.imagePath = FileNameConstants.DEFAULT_USER_IMAGE;
		this.maxDifficultyAchieved = 0.0;
	}



	public void removeFavorite(Route r) {
		this.favorites.remove(r);
	}

	public void removeGoal(Route r) {
		this.goals.remove(r);
	}

	public boolean addFavoriteRoute(Route route) {
		return favorites.add(route);
	}

	public boolean addGoalRoute(Route route) {
		return achieveds.add(route);
	}

	public boolean addAchievedsRoute(Route route) {
		if (route.getDifficulty()>this.maxDifficultyAchieved)
			this.maxDifficultyAchieved = route.getDifficulty();
		return achieveds.add(route);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	public int getLogradas() {
		return achieveds.size();
	}
	public TreeSet <Route> getGoals() {
		return goals;
	}
	public void setGoals(TreeSet <Route> goals) {
		this.goals = goals;
	}
	public TreeSet <Route> getFavorites() {
		return favorites;
	}
	public void setFavorites(TreeSet <Route> favorites) {
		this.favorites = favorites;
	}
	public String getFavoriteClimbing() {
		return favoriteClimbing;
	}
	public void setFavoriteClimbing(String favoriteClimbing) {
		this.favoriteClimbing = favoriteClimbing;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public double getMaxDifficultyAchieved() {
		return maxDifficultyAchieved;
	}
	public void setMaxDifficultyAchieved(double maxDifficultyAchieved) {
		this.maxDifficultyAchieved = maxDifficultyAchieved;
	}
	public String getPassword() {
		return new String(password);
	}
	public void setPassword(char[] password) {
		this.password = password;
	}

	public TreeSet <Route> getAchieveds() {
		return achieveds;
	}

	public void setAchieveds(TreeSet <Route> logrados) {
		this.achieveds = logrados;
	}
}
