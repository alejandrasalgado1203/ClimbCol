
package business;

import java.util.TreeMap;
import java.util.TreeSet;

import data.*;
import ui.*;

public class ClimbCol {
	private static UIMain uiMain;
	private static TreeSet <Park> parks = new TreeSet <Park>();
	private static TreeMap<String, User> users = new TreeMap <String,User>();

	public static void main(String[] args) {

		initiComponents();
		DataSerializer.serializeParks(parks);//quitar
		uiMain = new UIMain();

		//UICreardorDeDatos cr = new UICreardorDeDatos(new DataCreator(parks));

	}

	private static void initiComponents() {
		//parks = DataDeserializer.deserializeParks(); descomentar
		users = DataDeserializer.deserializeClimbers();
		ClimbColManager.setParks(parks);
		UsersManager.setUsers(users);
	}


}
