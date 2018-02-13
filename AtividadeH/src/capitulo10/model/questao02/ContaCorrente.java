package capitulo10.model.questao02;

public class ContaCorrente extends Conta implements Tributavel {
	
	public ContaCorrente() {	}
	
	public void atualiza(double taxa) {
		super.atualiza(taxa*2);
	}
	
	public void deposita(double valor) {
		super.deposita(valor - 0.10);
	}

	@Override
	public double calculaTributos() {
		return this.getSaldo() * 0.01;
	}

}
