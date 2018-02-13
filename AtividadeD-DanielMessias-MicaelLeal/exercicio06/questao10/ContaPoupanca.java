package exercicio06.questao10;

public class ContaPoupanca extends Conta {
	
	public ContaPoupanca(String numero, double saldoInicial) {
		super(numero, saldoInicial);
	}
	
	public void atualiza(double taxa) {
		this.saldo += this.saldo * taxa;
	}
	
}
