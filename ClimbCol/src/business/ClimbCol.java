
package business;

import java.util.TreeMap;

import data.*;
import ui.*;

public class ClimbCol {
	private static UIWelcome ui;
	private static TreeMap <String,Parque> parques = new TreeMap <String,Parque>();
	private static TreeMap <String,Escalador> escaladores = new TreeMap <String,Escalador>();

	public static void main(String[] args) {

		initiComponents();

		ui = new UIWelcome();
		ui.showAll();
		//UICreardorDeDatos cr = new UICreardorDeDatos(new CreadorDeDatos(parques));
	}

	private static void initiComponents() {
		ClimbColManager.setParks(parques);
		ClimbersManager.setEscaladores(escaladores);
	}


}
