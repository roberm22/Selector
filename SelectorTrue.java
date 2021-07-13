package es.upm.dit.prog.practica4;

public class SelectorTrue implements SelectorLocalizacion {
	public boolean esValida (Localizacion loc){ // bastante sencillo
		if (loc == null) //si es null te devuelve false
			return false;
		else return true;
	}
	
}
