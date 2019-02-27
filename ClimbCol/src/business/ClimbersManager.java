package business;

import java.util.TreeMap;

import data.Escalador;

public class ClimbersManager {

	private static TreeMap <String,Escalador> escaladores;
	
	public  static void put(Escalador es) {
		// TODO Auto-generated method stub
		
	}

	public static TreeMap <String,Escalador> getEscaladores() {
		return escaladores;
	}

	public static void setEscaladores(TreeMap <String,Escalador> escaladores) {
		ClimbersManager.escaladores = escaladores;
	}

}
