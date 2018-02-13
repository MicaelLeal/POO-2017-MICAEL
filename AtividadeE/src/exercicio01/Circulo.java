package exercicio01;

public class Circulo {
	private final double PI = 3.1415;
	private double raio;

	public Circulo(double raio) {
		this.raio = raio;
	}
	
	public double calculaArea() {
		return PI * this.raio * this.raio;
	}
	
	public double calculaPerimetro() {
		return PI * this.raio;
	}
	
	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}
	
	public double getDiametro() {
		return this.raio *2;
	}
	
}
