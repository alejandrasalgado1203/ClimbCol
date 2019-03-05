
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
		parques.add( new Parque("parque 1","images/4.jpg"));
		parques.add( new Parque("parque 2","images/sandPile3.png"));
		parques.add( new Parque("parque 3","images/4.jpg"));
		parques.add( new Parque("parque 4","images/sandPile3.png"));
		parques.add( new Parque("parque 5","images/4.jpg"));
		parques.add( new Parque("parque 6","images/sandPile3.png"));
		parques.add( new Parque("parque 7","images/4.jpg"));
		parques.add( new Parque("parque 8","images/sandPile3.png"));
		parques.add( new Parque("parque 9","images/4.jpg"));

		uiMain = new UIMain();

		//UICreardorDeDatos cr = new UICreardorDeDatos(new CreadorDeDatos(parques));

	}

	private static void initiComponents() {
		ClimbColManager.setParks(parques);
		ClimbersManager.setEscaladores(escaladores);
	}


}
