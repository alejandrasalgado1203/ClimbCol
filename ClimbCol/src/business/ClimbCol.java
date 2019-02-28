
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
		parques.put("parque 1", new Parque("parque 1","images/4.jpg"));
		parques.put("parque 2", new Parque("parque 2","images/sandPile3.png"));
		parques.put("parque 3", new Parque("parque 3","images/sandPile3.png"));
		parques.put("parque 4", new Parque("parque 4","images/sandPile3.png"));
		parques.put("parque 5", new Parque("parque 5","images/sandPile3.png"));
		parques.put("parque 6", new Parque("parque 6","images/sandPile3.png"));
		parques.put("parque 7", new Parque("parque 7","images/sandPile3.png"));
		parques.put("parque 8", new Parque("parque 8","images/sandPile3.png"));
		parques.put("parque 9", new Parque("parque 9","images/sandPile3.png"));
		
		ui = new UIWelcome();
		ui.showAll();
		//UICreardorDeDatos cr = new UICreardorDeDatos(new CreadorDeDatos(parques));
	}

	private static void initiComponents() {
		ClimbColManager.setParks(parques);
		ClimbersManager.setEscaladores(escaladores);
	}


}
