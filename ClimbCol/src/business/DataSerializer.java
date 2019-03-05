package business;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.TreeMap;
import java.util.TreeSet;

import data.*;

public class DataSerializer {

	public static void serializeParks(TreeSet<Parque> parques) {
		FileOutputStream file;
		try {
			file = new FileOutputStream (FileNameConstants.PARKS_FILE);
			ObjectOutputStream  writer = new ObjectOutputStream (file);
			writer.writeObject(parques);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public static void serializeClimbers(TreeMap<String,Escalador> climbers) {
		FileOutputStream file;
		try {
			file = new FileOutputStream (FileNameConstants.CLIMBERS_FILE);
			ObjectOutputStream  writer = new ObjectOutputStream (file);
			writer.writeObject(climbers);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
