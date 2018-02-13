package exercicio;

public abstract class Conta {
	protected double saldo;
	
	public Conta() {/*.*/}
	
	public abstract void atualiza(double taxa);
	
	public void deposita(double valor) {
		this.saldo += valor;
	}
	
	public boolean saca(double valor) {
		if (valor <= this.saldo) {
			this.saldo -= valor;
			return true;
		}else
			return false;
	}
	
	public double getSaldo() {
		return this.saldo;
	}

}
