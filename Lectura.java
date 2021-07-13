package es.upm.dit.prog.practica4;

public class Lectura {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(potencia);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((red == null) ? 0 : red.hashCode());
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
		Lectura other = (Lectura) obj;
		if (Double.doubleToLongBits(potencia) != Double.doubleToLongBits(other.potencia))
			return false;
		if (red == null) {
			if (other.red != null)
				return false;
		} else if (!red.equals(other.red))
			return false;
		return true;
	}
	public WiFi getRed() {
		return red;
	}
	public void setRed(WiFi red) {
		this.red = red;
	}
	public double getPotencia() {
		return potencia;
	}
	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}
	@Override
	public String toString() {
		return "Lectura [red=" + red + ", potencia=" + potencia + "]";
	}
	/**
	 * @param red
	 * @param potencia
	 */
	public Lectura(WiFi red, double potencia) {
		this.red = red;
		this.potencia = potencia;
	}
	private WiFi red;
	private double potencia;
	}
