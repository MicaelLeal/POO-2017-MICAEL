package model;

import exceptions.SaldoInsuficienteException;

public abstract class Conta {
	protected double saldo;
	
	public abstract void atualiza(double taxa);
	
	public void deposita(double valor) {
		if (valor < 0)
			throw new IllegalArgumentException("Valor negativo inserido!");
		else
			this.saldo += valor;
	}
	
	public void saca(double valor) {
		if  (valor < 0)
			throw new IllegalArgumentException("Valor negativo inserido!");
		else if (valor > this.saldo)
			throw new SaldoInsuficienteException(valor);
		else
			this.saldo -= valor;
	}
	
	public double getSaldo() {
		return this.saldo;
	}

}
