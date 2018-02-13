package exercicio05;

public class ContaImposto {
	private String numero;
	private double saldo;
	
	public ContaImposto(String numero, double saldoInicial) {
		this.numero = numero;
		this.saldo = saldoInicial;
	}
	
	public void creditar(double valor) {
		this.saldo += valor;
	}
	
	public boolean debitar(double valor) {
		valor += this.retemImposto(valor);
		if (this.saldo > valor) {
			this.saldo -= valor;
			return true;
		}
		return false;
	}
	
	private double retemImposto(double valorDebito) {
		return valorDebito * 0.0038;
	}
	 
	public double getSaldo() {
		return saldo;
	}
	
	public String getNumero() {
		return this.numero;
	}
}
