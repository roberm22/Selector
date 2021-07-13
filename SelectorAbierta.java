package es.upm.dit.prog.practica4;

public class SelectorAbierta implements SelectorLocalizacion {
	private double umbral;
	public SelectorAbierta(double umbral){    // creamos el constructor con el parametro que nos dicen
		this.umbral=umbral;
	}
	public boolean esValida (Localizacion loc){
		if (loc != null){
			int x = loc.copiaDeLecturas().length;    // creamos una variable para reducir el tiempo de ejecucion
			for (int i = 0; i< x; i++){
			   if(loc.copiaDeLecturas()[i].getRed().getSeguridad() == Seguridad.ABIERTA && loc.copiaDeLecturas()[i].getRed() != null){
				   if(loc.copiaDeLecturas()[i].getPotencia() >= umbral)
				       return true;
			   }
			   
			  // aqui hemos mirado que la seguridad es ABIERTA y que el WiFi es diferente de null
			   // posteriormente comprobamos que la potencia es mayor que la umbral
			 }
			return false; // si no se cumple es falso
		}	
		else return false;
	}
	
}
