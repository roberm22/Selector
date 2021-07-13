package es.upm.dit.prog.practica4;

public class PruebaRegistro {
	private static void imprimeLocs (Localizacion [] locs){
		for (Localizacion l: locs)
			System.out.println(l);		
	}
	
	public static void main (String[] args) {

		WiFi[] wifis = new WiFi[4];
		Seguridad [] segs = {
				Seguridad.ABIERTA, 
				Seguridad.WEP, 
				Seguridad.WPA2_PERSONAL,
				Seguridad.WPA2_EMPRESA
		}; 
		for (int i = 0; i < wifis.length; i++){
			wifis[i] = new WiFi("WiFi" + i, segs[i]);
		}

		Localizacion[] locs = new Localizacion [6];
		for (int i = 0; i < locs.length; i++){
			locs[i] = new Localizacion(new Coordenada (i*10, i*10), wifis.length);
			for (int j = 0; j < wifis.length; j++) {
				double potencia = - 10 * (j + i + 3);
				if (potencia > -90)
					locs[i].addLectura(new Lectura(wifis[j], potencia));
			}
		}

		Registro r = new Registro(locs.length);
		System.out.println("New Registro=" + r);

		for (int i = 0; i < locs.length; i++){
			boolean anade= r.add(locs[i]);
			System.out.println("add " + i  + "=" + anade);				
		}

		System.out.println("r.getLocalizacion(0)=" + r.getLocalizacion(0));
		System.out.println("r.getLocalizacion(6)=" + r.getLocalizacion(6));

		Localizacion[] locs2 = r.getLocalizaciones(new SelectorTrue());
		System.out.println("getLocalizaciones=");
		imprimeLocs(locs2);

		locs2 = r.getLocalizaciones(new SelectorDistancia(new Coordenada (0,0), 70));
		System.out.println("getLocalizaciones distancia (0,0), 70=");
		imprimeLocs(locs2);

		locs2 = r.getLocalizaciones(new SelectorWiFi(wifis[0], -70));
		System.out.println("getLocalizaciones SelectorWiFi(wifis[0], -70)=");
		imprimeLocs(locs2);

		locs2 = r.getLocalizaciones(new SelectorWiFi(wifis[3], -100));
		System.out.println("getLocalizaciones SelectorWiFi(wifis[3], -100)=");
		imprimeLocs(locs2);

		locs2 = r.getLocalizaciones(new SelectorAbierta(-70));
		System.out.println("getLocalizaciones SelectorAbierta(-70)=");
		imprimeLocs(locs2);

		SelectorLocalizacion sAND= new SelectorAND(
				new SelectorAbierta(-70), 
				new SelectorDistancia(new Coordenada (20,20), 15));
		locs2 = r.getLocalizaciones(sAND);
		System.out.println("getLocalizaciones SelectorAND=");
		imprimeLocs(locs2);
		
		SelectorLocalizacion sOR= new SelectorOR(
				new SelectorWiFi(wifis[0], -30), 
				new SelectorWiFi(wifis[1], -50));	
		locs2 = r.getLocalizaciones(sOR);
		System.out.println("getLocalizaciones SelectorOR=");
		imprimeLocs(locs2);
		
	}
}
