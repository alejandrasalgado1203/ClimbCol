package business;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.TreeMap;
import java.util.TreeSet;
import ui.UIMain;
import data.*;

public class DataDeserializer {

    @SuppressWarnings("unchecked")
    public static TreeSet<Park> deserializeParks() {

        TreeSet<Park> parks = null;
        try {
            FileInputStream file = new FileInputStream(FileNameConstants.PARKS_FILE);
            ObjectInputStream reader = new ObjectInputStream(file);
            parks = (TreeSet<Park>) reader.readObject();
            reader.close();
        } catch (IOException | ClassNotFoundException e) {
            UIMain.reportProblem("there were problems loading park information");
            return new TreeSet<Park>();
        }
        return parks;
    }

    @SuppressWarnings("unchecked")
    public static TreeMap<String, User> deserializeUsers() {

        TreeMap<String, User> users = null;
        try {
            FileInputStream file = new FileInputStream(FileNameConstants.USERS_FILE);
            ObjectInputStream reader = new ObjectInputStream(file);
            users = (TreeMap<String, User>) reader.readObject();
            reader.close();
        } catch (IOException | ClassNotFoundException e) {
            UIMain.reportProblem("there were problems loading users information");
            return new TreeMap<String, User>();
        }
        return users;
    }

}
