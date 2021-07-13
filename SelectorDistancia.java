package es.upm.dit.prog.practica4;

public class SelectorDistancia implements SelectorLocalizacion{
	private double d;
	private Coordenada c;
	public SelectorDistancia (Coordenada c, double d){ // aqui tenemos el constructor
	     this.c = c;
	     this.d = d;
	}
	
	public boolean esValida(Localizacion loc){
		if (loc != null && c != null && loc.getC().distancia(c)<=d)  //comprobamos la distancia
			return true;
		else return false;
	}
	
	
}
