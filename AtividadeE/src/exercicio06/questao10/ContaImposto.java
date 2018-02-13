package exercicio06.questao10;

public class ContaImposto extends Conta {
	
	public ContaImposto(String numero, double saldoInicial) {
		super(numero, saldoInicial);
	}
	
	@Override
	public boolean debitar(double valor) {
		return super.debitar(valor + this.retemImposto(valor));
	}
	
	private double retemImposto(double valorDebito) {
		return valorDebito * 0.0038;
	}
}
