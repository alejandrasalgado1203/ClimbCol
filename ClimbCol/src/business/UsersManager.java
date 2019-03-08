package business;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.TreeMap;

import data.User;
import data.Route;

public class UsersManager {

	private static TreeMap<String, User> users;
	private static User currentUser;

	public static void creatUser(String text, char[] password) {
		User climber = new User(text,password);
		users.put(climber.getPassword(), climber);
	}

	public static boolean isValidPassword(char[] password) {	
		return password.length>5 && (!users.containsKey(new String(password)));
	}

	public static boolean isValidName(String text) {
		for (User c : users.values()) {
			if(c.getName().equals(text))return false;
		}
		return true;
	}

	public static boolean doLogin(String text, char[] password) {
		boolean succesful = false;
		User user = users.get(new String (password));
		if(user!=null && user.getName().equals(text)) {
			succesful = true;
			currentUser = user;
		}
		return succesful;
	}

	public static boolean hasCurrentUser() {
		return currentUser != null;
	}
	public static TreeMap<String, User> getUsers() {
		return users;
	}

	public static void setUsers(TreeMap<String, User> users) {
		UsersManager.users = users;
	}

	public static User getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(User currentUser) {
		UsersManager.currentUser = currentUser;
	}

	public static void editUser(String[] editValues) {
		if (!editValues[0].isEmpty()) 
			currentUser.setBirthdate(LocalDate.parse(editValues[0],
					DateTimeFormatter.ofPattern("d MMMM uuuu")));
		if (!editValues[1].isEmpty())
			currentUser.setFavoriteClimbing(editValues[2]);
		if (!editValues[2].isEmpty())
			currentUser.setImagePath(editValues[4]);
	}

	public static void saveUsers() {
		DataSerializer.serializeUsers(users);
	}

	public static void removeRoute(Route r, String item) {
		if(item.equals("favorites"))
			currentUser.removeFavorite(r);
		if(item.equals("goals"))
			currentUser.removeGoal(r);
	}

	public static boolean addRoute(Route route, String actionCommand) {
		if (actionCommand.equals("Goals"))return currentUser.addGoalRoute(route);
		if (actionCommand.equals("Favorites"))return currentUser.addFavoriteRoute(route);
		if (actionCommand.equals("Achieveds"))return currentUser.addAchievedsRoute(route);
		return false;
	}

}
