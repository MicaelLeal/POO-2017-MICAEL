package model;

public class ContaCorrente extends Conta{
	
	public ContaCorrente() {/*.*/}
	
	@Override
	public void atualiza(double taxa) {
		this.saldo = this.saldo * taxa*2;
	}
	
	@Override
	public void deposita(double valor) {
		super.deposita(valor - 0.10);
	}

}
