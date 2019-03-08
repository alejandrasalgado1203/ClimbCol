package business;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.TreeMap;
import java.util.TreeSet;

import data.*;

public class DataDeserializer  {

	@SuppressWarnings("unchecked")
	public static TreeSet<Park> deserializeParks(){

		TreeSet<Park> parks = null;
		try {
			FileInputStream file = new FileInputStream (FileNameConstants.PARKS_FILE);
			ObjectInputStream reader = new ObjectInputStream (file);
			parks = (TreeSet<Park>) reader.readObject();
			reader.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return parks;
	}

	@SuppressWarnings("unchecked")
	public static TreeMap<String, User> deserializeClimbers(){

		TreeMap<String,User> users = null;
		try {
			FileInputStream file = new FileInputStream (FileNameConstants.USERS_FILE);
			ObjectInputStream reader = new ObjectInputStream (file);
			users = (TreeMap<String,User>) reader.readObject();
			reader.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return users;
	}

}
