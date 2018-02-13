package exercicio02;

public class Desconto {
	private double valorOriginal;
	private double desconto;
	
	public Desconto(double valorOriginal, int desconto) {
		this.valorOriginal = valorOriginal;
		this.desconto = desconto;
	}
	
	public double calcula() {
		return (this.valorOriginal * (1- this.desconto/100));
	}

	public double getValorOriginal() {
		return valorOriginal;
	}

	public void setValorOriginal(double valorOriginal) {
		this.valorOriginal = valorOriginal;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}	
}
