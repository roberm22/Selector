package es.upm.dit.prog.practica4;

import java.util.Arrays;

public class Localizacion {	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c == null) ? 0 : c.hashCode());
		result = prime * result + Arrays.hashCode(lecturas);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Localizacion other = (Localizacion) obj;
		if (c == null) {
			if (other.c != null)
				return false;
		} else if (!c.equals(other.c))
			return false;
		if (!Arrays.equals(lecturas, other.lecturas))
			return false;
		return true;
	}
	private Coordenada c;
	private Lectura [] lecturas;
	/**
	 * @param c
	 * @param lecturas
	 */
	public Localizacion(Coordenada c, int lecturas) {
		super();
		this.c = c;
		this.lecturas = new Lectura [lecturas];
	}
	public Coordenada getC() {
		return c;
	}
	public void setC(Coordenada c) {
		this.c = c;
	}
	public void setLectura(Lectura l, int n){
		if ((n>=0)&&(n <= lecturas.length-1)){
			lecturas [n] = l;
		}
	}
	public Lectura getLectura (int n){
		if ((n>=0)&&(n <= lecturas.length-1)){
			return lecturas [n];
		}
		return null;
	}
	public void intercambia (int n1, int n2){
		if ( (n1>=0)&&(n1 <= lecturas.length-1) && (n2>=0)&&(n2 <= lecturas.length-1) ){
			Lectura t = lecturas [n1];
			Lectura o = lecturas [n2];
			lecturas [n2] = t;
			lecturas [n1] = o;
		}
	}
		
	@Override
	public String toString() {
		return "Localizacion [c=" + c + ", lecturas=" + Arrays.toString(lecturas) + "]";    
	}
	
	public boolean addLectura ( Lectura l){      //solo devolvera como resultado true o false
		if (l == null)
			return false;
		
		for (int i = 0 ; i<lecturas.length ; i++){
			if (lecturas[i] == null){
				lecturas [i] = l;
				return true;
			}			
		}
		return false;
			
	}

	private int getPosicionLectura (WiFi w){   //metodo privado que usaremos mas adelante
		if (w == null){
			return -1;
		}
		for (int i = 0 ; i<lecturas.length ; i++ ){ 
			  if (lecturas[i] != null){
	    	   if(w.equals(lecturas[i].getRed()))
				   return i;
			  }
		}	  
		return -1;	
	}
	
	public Lectura getLectura (WiFi w){
		if (getPosicionLectura(w) != -1)
			return lecturas [getPosicionLectura(w)];
		return null;
	}
	
	public Lectura masPotente (){       //metodo dificil revisar mas tarde
		if (lecturas.length < 1)
			return null;

		Lectura Nummayor = lecturas[0];
		for (int i = 1 ; i<lecturas.length ; i++ ){ 
			if (lecturas[i] != null){
				if (lecturas[i].getPotencia () > Nummayor.getPotencia())	{
					Nummayor = lecturas [i];
				}
			}	
		}		
		return Nummayor;
		
	}
	
	public Lectura [] copiaDeLecturas(){
		int l = lecturas.length;  //declaras una variable para lecturas.length para que sea mas eficaz
		int m = 0;
		int x = 0;
		for (int i = 0 ; i<l ; i++ ){ 
			if (lecturas[i] == null)
				x++;	
		}
		int Numcasillas = l - x;
		Lectura [] validas = new Lectura [Numcasillas];
		
		for (int i = 0 ; i<l ; i++ ){ 
			if (lecturas[i] != null)
				validas [m++] = lecturas [i];	
		}
	    return validas;
	}
	
	
    public void borraLectura (WiFi w){     //aqui borras
    	int l = lecturas.length;
     	if (getPosicionLectura(w) != -1){     
            for (int i = getPosicionLectura(w) ; i<l-1 ;  i++ )	
            	lecturas[i] = lecturas [i+1];	
            lecturas[l-1] = null;
            
     	}   
	 }}
