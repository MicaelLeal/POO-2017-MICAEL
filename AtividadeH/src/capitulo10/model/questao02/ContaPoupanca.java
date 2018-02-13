package capitulo10.model.questao02;

public class ContaPoupanca extends Conta {
	
	public ContaPoupanca() {/*.*/}
	
	public void atualiza(double taxa) {
		super.atualiza(taxa*3);
	}
	
}
