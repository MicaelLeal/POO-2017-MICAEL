package Questao03_B;

public class Conta {
	private Titular titular;
	private int numero;
	private double saldo;
	
	Conta(Titular titular){
		this.titular = titular;
	}
	
	void depositar(double valor){
		this.saldo += valor;
	}
	
	boolean sacar(double valor){
		if (this.saldo >= valor){
			this.saldo -= valor;
			return true;
		}else{
			return false;
		}
	}
	

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Titular getTitular() {
		return titular;
	}

	public int getNumero() {
		return numero;
	}
	
	

}
