
package business;

import java.util.TreeMap;
import java.util.TreeSet;

import data.*;
import ui.*;

public class ClimbCol {
	private static TreeSet <Park> parks;
	private static TreeMap<String, User> users;

	public static void main(String[] args) {

		initiComponents();
		UIMain uiMain = new UIMain();
		//UIDataCreator cr = new UIDataCreator(new DataCreator(parks));

	}

	private static void initiComponents() {
		parks = DataDeserializer.deserializeParks();
		users = DataDeserializer.deserializeUsers();
		ClimbColManager.setParks(parks);
		UsersManager.setUsers(users);
	}


}
