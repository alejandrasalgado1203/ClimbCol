package business;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.TreeMap;
import java.util.TreeSet;

import data.*;

public class DataSerializer {

	public static void serializeParks(TreeSet<Park> parks) {
		FileOutputStream file;
		try {
			file = new FileOutputStream (FileNameConstants.PARKS_FILE);
			ObjectOutputStream  writer = new ObjectOutputStream (file);
			writer.writeObject(parks);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public static void serializeUsers(TreeMap<String,User> users) {
		FileOutputStream file;
		try {
			file = new FileOutputStream (FileNameConstants.USERS_FILE);
			ObjectOutputStream  writer = new ObjectOutputStream (file);
			writer.writeObject(users);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
