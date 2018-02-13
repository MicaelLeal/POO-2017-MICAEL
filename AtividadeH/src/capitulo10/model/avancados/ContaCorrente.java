package capitulo10.model.avancados;

public class ContaCorrente implements ContaTributavel {

	private double saldo;
	
	public ContaCorrente(double saldoInicial) {
		this.saldo = saldoInicial;
	}
	
	@Override
	public double getSaldo() {
		return this.saldo;
	}

	@Override
	public void deposita(double valor) {
		this.saldo += valor;
	}

	@Override
	public void saca(double valor) {
		if (this.saldo > valor)
			this.saldo -= valor;
	}

	@Override
	public void atualiza(double taxaSelic) {
		this.saldo *= (1 + taxaSelic*2);
	}

	@Override
	public double calculaTributos() {
		return this.getSaldo() * 0.01;
	}

}
