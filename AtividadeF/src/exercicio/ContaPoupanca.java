package exercicio;

public class ContaPoupanca extends Conta {
	
	public ContaPoupanca() {/*.*/}
	
	@Override
	public void atualiza(double taxa) {
		this.saldo += this.saldo * taxa *3;
	}
	
}
