package business;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.TreeMap;

import data.Escalador;
import data.Ruta;

public class ClimbersManager {

	private static TreeMap<String, Escalador> users;
	private static Escalador currentUser;

	public static void creatUser(String text, char[] password) {
		Escalador climber = new Escalador(text,password);
		users.put(climber.getPassword(), climber);
	}

	public static boolean isValidPassword(char[] password) {	
		return password.length>5 && (!users.containsKey(new String(password)));
	}

	public static boolean isValidName(String text) {
		for (Escalador c : users.values()) {
			if(c.getName().equals(text))return false;
		}
		return true;
	}

	public static boolean doLogin(String text, char[] password) {
		boolean succesful = false;
		Escalador user = users.get(new String (password));
		if(user!=null && user.getName().equals(text)) {
			succesful = true;
			currentUser = user;
		}
		return succesful;
	}

	public static boolean hasCurrentUser() {
		return currentUser != null;
	}
	public static TreeMap<String, Escalador> getUsers() {
		return users;
	}

	public static void setUsers(TreeMap<String, Escalador> users) {
		ClimbersManager.users = users;
	}

	public static Escalador getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(Escalador currentUser) {
		ClimbersManager.currentUser = currentUser;
	}

	public static void editUser(String[] editValues) {
		if (!editValues[0].isEmpty()) 
			currentUser.setFechaDeNacimiento(LocalDate.parse(editValues[0],
					DateTimeFormatter.ofPattern("d MMMM uuuu")));
		if (!editValues[1].isEmpty())
			currentUser.setLogradas(Integer.parseInt(editValues[1]));
		if (!editValues[2].isEmpty())
			currentUser.setEscaladaFavorita(editValues[2]);
		if (!editValues[3].isEmpty())
			currentUser.setDireccionImagen(editValues[4]);
	}

	public static void saveUsers() {
		DataSerializer.serializeClimbers(users);
	}

	public static void removeRoute(Ruta r, String item) {
		if(item.equals("favorites"))
			currentUser.removeFavorite(r);
		if(item.equals("goals"))
			currentUser.removeGoal(r);
	}

	public static boolean addRoute(Ruta route, String actionCommand) {
		if (actionCommand.equals("Goals"))return currentUser.addGoalRoute(route);
		if (actionCommand.equals("Favorites"))return currentUser.addFavoriteRoute(route);
		if (actionCommand.equals("Achieveds"))return currentUser.addAchievedsRoute(route);
		return false;
	}

}
