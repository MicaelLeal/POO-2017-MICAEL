package exercicio04;

public class Conta {
	private String numero;
	private double saldo;
	
	public Conta(String numero, double saldoInicial) {
		this.numero = numero;
		this.saldo = saldoInicial;
	}
	
	public void creditar(double valor) {
		this.saldo += valor;
	}
	
	public boolean debitar(double valor) {
		if (this.saldo > valor) {
			this.saldo -= valor;
			return true;
		}
		return false;
	}
	
	public boolean transferir(Conta contaDestino, double valor) {
		if (this.debitar(valor)){
			contaDestino.creditar(valor);
			return true;
		}
		return false;
	}

	public String getNumero() {
		return this.numero;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
}
