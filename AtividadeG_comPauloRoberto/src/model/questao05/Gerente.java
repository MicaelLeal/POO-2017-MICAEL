package model.questao05;

public class Gerente extends Funcionario {
	private double participacao;
	
	Gerente(String nome) {
		super(nome);
	}

	public double getBonificacao() {
		return this.salario * (1 + this.participacao/100);
	}

	public double getParticipacao() {
		return participacao;
	}

	public void setParticipacao(double participacao) {
		this.participacao = participacao;
	}
	
}
