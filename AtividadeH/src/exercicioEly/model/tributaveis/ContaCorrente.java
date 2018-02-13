package exercicioEly.model.tributaveis;

public class ContaCorrente extends Conta implements Tributavel {
	
	public ContaCorrente(double saldo) {
		super(saldo);
	}

	@Override
	public double calcularTributos() {
		return this.getSaldo() * 0.1;
	}
	
}
