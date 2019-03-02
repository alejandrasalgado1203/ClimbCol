package business;

import java.util.TreeMap;

import data.Escalador;

public class ClimbersManager {

	private static TreeMap<String, Escalador> escaladores;
	private static Escalador currentUser;

	public static void creatUser(String text, char[] password) {
		Escalador climber = new Escalador(text,password);
		escaladores.put(climber.getPassword(), climber);
	}

	public static boolean isValidPassword(char[] password) {	
		return password.length>5 && (!escaladores.containsKey(new String(password)));
	}

	public static boolean isValidName(String text) {
		for (Escalador c : escaladores.values()) {
			if(c.getName().equals(text))return false;
		}
		return true;
	}

	public static boolean doLogin(String text, char[] password) {
		boolean succesful = false;
		Escalador user = escaladores.get(new String (password));
		if(user!=null && user.getName().equals(text)) {
			succesful = true;
			currentUser = user;
		}
		return succesful;
	}




	public static TreeMap<String, Escalador> getEscaladores() {
		return escaladores;
	}

	public static void setEscaladores(TreeMap<String, Escalador> escaladores) {
		ClimbersManager.escaladores = escaladores;
	}

	public static Escalador getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(Escalador currentUser) {
		ClimbersManager.currentUser = currentUser;
	}

}
