package exercicio01;

public class SituacaoFinanceira {
	private double valorCreditos;
	private double valorDebitos;
	
	public SituacaoFinanceira(double creditos, double debitos) {
		this.valorCreditos = creditos;
		this.valorDebitos = debitos;
	}

	public double saldo() {
		return this.valorCreditos - this.valorDebitos;
	}
	
	public double getValorCreditos() {
		return valorCreditos;
	}

	public double getValorDebitos() {
		return valorDebitos;
	}
	
}
