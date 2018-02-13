package exercicio03;

public class Conta {
	private String numero;
	private double saldo;
	
	public Conta(String numero, double saldoInicial) {
		this.numero = numero;
		this.saldo = saldoInicial;
	}
	
	public boolean sacar(double valor) {
		if (this.saldo > valor) {
			saldo -= valor;
			return true;
		} else
			return false;
	}
	
	public void depositar(double valor) {
		saldo += valor;
	}
	
	public boolean tranferir(Conta contaDestino, double valor) {
		if (this.sacar(valor)){
			contaDestino.depositar(valor);
			return true;
		} else
			return false;
	}
	
	public double consultarSaldo() {
		return saldo;
	}
	
	public String getNumero() {
		return this.numero;
	}
}
