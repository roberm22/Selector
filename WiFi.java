package es.upm.dit.prog.practica4;

public class WiFi {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((seguridad == null) ? 0 : seguridad.hashCode());
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
		WiFi other = (WiFi) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (seguridad != other.seguridad)
			return false;
		return true;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Seguridad getSeguridad() {
		return seguridad;
	}
	public void setSeguridad(Seguridad seguridad) {
		this.seguridad = seguridad;
	}
	@Override
	public String toString() {
		return "WiFi [nombre=" + nombre + ", seguridad=" + seguridad + "]";
	}
	/**
	 * @param nombre
	 * @param seguridad
	 */
	public WiFi(String nombre, Seguridad seguridad) {
		this.nombre = nombre;
		this.seguridad = seguridad;
	}
	private String nombre;
	private Seguridad seguridad;
	}
