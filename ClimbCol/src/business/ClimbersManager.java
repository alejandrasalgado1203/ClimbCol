package business;

import java.util.TreeMap;

import data.Escalador;

public class ClimbersManager {

	private static TreeMap <String,Escalador> escaladores;

	public  static void put(Escalador es) {
		escaladores.put(es.getPassword(), es);
	}

	public static TreeMap <String,Escalador> getEscaladores() {
		return escaladores;
	}

	public static void setEscaladores(TreeMap <String,Escalador> escaladores) {
		ClimbersManager.escaladores = escaladores;
	}

}
