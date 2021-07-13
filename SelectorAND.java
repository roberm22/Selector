package es.upm.dit.prog.practica4;

public class SelectorAND implements SelectorLocalizacion {
	private SelectorLocalizacion s1;
	private SelectorLocalizacion s2;
	public SelectorAND (SelectorLocalizacion s1, SelectorLocalizacion s2){
		this.s1 = s1;
		this.s2 = s2;

	}
	// identico a SELECTOROR, solo cambia la sentencia logica
	public boolean esValida (Localizacion loc){
		if (loc != null && s1 != null && s2 != null){  // ademas de s1 y s2, comprobamos que loc es diferente de null para que no nos de error
			return s1.esValida(loc) & s2.esValida(loc); // nos devuelve el booleano de la operacion
		}	
		else return false;
	}
}
