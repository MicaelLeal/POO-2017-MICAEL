package model.questao06;

public class ContaCorrente extends Conta {
	
	public ContaCorrente(double saldo) {
		super(saldo);
	}
	
	public void debitar(double valor) {
		this.saldo -= valor;
	}
	public void creditar(double valor) {
		this.saldo += valor;
	}
	
	
	
}
