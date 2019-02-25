package business;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.TreeMap;

import data.*;

public class DataDeserializer  {

	@SuppressWarnings("unchecked")
	public static TreeMap<String,Parque> deserializeParks(){

		TreeMap<String,Parque> parks = null;
		try {
			FileInputStream file = new FileInputStream (FileNameConstants.PARKS_FILE);
			ObjectInputStream reader = new ObjectInputStream (file);
			parks = (TreeMap<String,Parque>) reader.readObject();
			reader.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return parks;
	}

	@SuppressWarnings("unchecked")
	public static TreeMap<String, Escalador> deserializeClimbers(){

		TreeMap<String,Escalador> climbers = null;
		try {
			FileInputStream file = new FileInputStream (FileNameConstants.CLIMBERS_FILE);
			ObjectInputStream reader = new ObjectInputStream (file);
			climbers = (TreeMap<String,Escalador>) reader.readObject();
			reader.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return climbers;
	}

}
