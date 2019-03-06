
package business;

import java.util.TreeMap;
import java.util.TreeSet;

import data.*;
import javax.swing.ImageIcon;
import ui.*;

public class ClimbCol {
	private static UIMain uiMain;
	private static TreeSet <Parque> parques = new TreeSet <Parque>();
	private static TreeMap<String, Escalador> escaladores = new TreeMap <String,Escalador>();

	public static void main(String[] args) {

			initiComponents();

		uiMain = new UIMain();

		//UICreardorDeDatos cr = new UICreardorDeDatos(new CreadorDeDatos(parques));

	}

	private static void initiComponents() {
            parques = DataDeserializer.deserializeParks();
            ClimbColManager.setParks(parques);
		ClimbersManager.setEscaladores(escaladores);
	}


}
