package es.upm.dit.prog.practica4;

public class SelectorOR implements SelectorLocalizacion {
	private SelectorLocalizacion s1;
	private SelectorLocalizacion s2;
	public SelectorOR (SelectorLocalizacion s1, SelectorLocalizacion s2){
		this.s1 = s1;
		this.s2 = s2;
	}	
	// identico a SELECTOROR, solo cambia la sentencia logica
	public boolean esValida (Localizacion loc){
		if (loc != null && s1 != null && s2 != null){ // aqui hacemos igual que en selectorand
			return s1.esValida(loc) | s2.esValida(loc);// y nos devuelve el booleano
		}	
		else return false;
	}
}
