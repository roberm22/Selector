package es.upm.dit.prog.practica4;

public class SelectorWiFi implements SelectorLocalizacion {
	private double umbral;
	private WiFi red;
	public SelectorWiFi(WiFi red, double umbral){ // aqui creamos el constructor
		this.red = red;
		this.umbral = umbral;
	}
	public boolean esValida (Localizacion loc){
		
		if (red == null)  // comprobamos que el wifi no es null
			return false;
		if (loc != null){ // comprobamos que loc no es null y entonces ejecutamos el codigo
			int x = loc.copiaDeLecturas().length;  // variable para reducir el tiempo de ejecucion
			for (int i = 0; i< x; i++){
			   if(loc.copiaDeLecturas()[i].getRed() == red){ // miramos si el wifi es igual al que damos como parametro
				   if(loc.copiaDeLecturas()[i].getPotencia() >= umbral) // y por ultimo vemos si es mayor que la potencia umbral
				       return true;
			   }
			}
			return false;
		}	
		else return false;
	}
}
