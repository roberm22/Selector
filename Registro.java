package es.upm.dit.prog.practica4;

import java.util.Arrays;

public class Registro {
    private Localizacion [] locs;  
	
	public Registro (int maxloc){
		locs = new Localizacion [maxloc];  //creamos locs teniendo como tamaño de dicho array maxloc
	}
	
	public boolean add (Localizacion l){   //aqui te piden lo mismo que en la clase localizacion
		if (l == null)
			return false;
		int j = locs.length;
		
		for (int i = 0 ; i<j ; i++){
			if (locs[i] == null){
				locs [i] = l;
				return true;
			}			
		}
		return false;
	}
	public Localizacion  getLocalizacion (int n){
		if (n>=0 && n<= locs.length -1)
			return locs[n];
		return null;
		    
	}

	@Override
	public String toString() {
		return "Registro [locs=" + Arrays.toString(locs) + "]";  //para que no salga el error de lo de package...
	}
	
	public Localizacion [] getLocalizaciones (SelectorLocalizacion s){
		
		if (s == null)
			return new Localizacion [0];
		
		int x = 0;
		int r = locs.length;        // creamos una variable para que sea menor el tiempo de ejecucion
		for (int i = 0; i<r; i++){
			if(locs[i] != null){
				if(s.esValida(locs[i]))     // esto es lo que hemos cambiado con respecto a la practica anterior
				   x++;
			}
		    if (r==0)
				return new Localizacion [0];
		}
		Localizacion [] lascercanas = new Localizacion [x];
		int p = 0;
		for (int i = 0; i<r; i++){
			if(locs[i] != null){
				if(s.esValida(locs[i]))    // aqui es lo mismo
				    lascercanas[p++]=locs[i];
			}	
		}		
		return lascercanas;
			
			
	}

}
