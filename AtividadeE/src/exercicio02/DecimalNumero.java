package exercicio02;

public class DecimalNumero {
	private double number;
	
	public DecimalNumero(double number) {
		this.number = number;
	}
	
	public int getParteInteira() {
		return (int)this.number;
	}
	
	public double getParteDecimal() {
		return this.number - this.getParteInteira();
	}
	
	public double getNumber() {
		return this.number;
	}	
}
