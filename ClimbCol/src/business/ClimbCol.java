
package business;

import java.util.TreeMap;

import data.*;
import ui.UI;

public class ClimbCol {
	private static UI ui;
	private static TreeMap <String,Parque> parques = new TreeMap <String,Parque>();
	private static TreeMap <String,Escalador> escaladores = new TreeMap <String,Escalador>();
	
	public static void main(String[] args) {
		UI ui = new UI();
		ui.showMenu();
		
	}

	
}
