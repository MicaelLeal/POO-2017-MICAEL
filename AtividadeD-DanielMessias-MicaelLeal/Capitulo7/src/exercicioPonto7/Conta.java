package exercicioPonto7;

public class Conta {
	private double saldo;
	
	public Conta() {/*.*/}
	
	public void atualiza(double taxa) {
		this.saldo += this.saldo * taxa;
	}
	
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
