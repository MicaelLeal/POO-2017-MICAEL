package model.questao06;

public abstract class Conta {
	protected double saldo;
	
	public Conta(double saldo) {
		this.saldo = saldo;
	}
	
	public abstract void debitar(double valor);
	public abstract void creditar(double valor);
	
}
