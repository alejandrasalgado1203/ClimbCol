
package business;

import java.util.TreeMap;

import data.*;
import ui.*;

public class ClimbCol {
	private static UIWelcome ui;
	private static TreeMap <String,Parque> parques = new TreeMap <String,Parque>();
	private static TreeMap <String,Escalador> escaladores = new TreeMap <String,Escalador>();
    private static ClimbersManager climbersManager= new ClimbersManager();
    private static ClimbColManager climbcolManager = new ClimbColManager(parques);
    
	public static void main(String[] args) {
		
		UIWelcome ui = new UIWelcome(climbersManager,climbcolManager);
		ui.showAll();
		//UICreardorDeDatos cr = new UICreardorDeDatos(new CreadorDeDatos(parques));
	}


}
