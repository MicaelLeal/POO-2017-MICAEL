package exercicio06.questao06a09;

public class Professor extends Funcionario {
	private String titulacao;
	
	public Professor(int matricula, double salario, String titulacao){
		super(matricula, salario);
		this.titulacao = titulacao;
	}
	
	@Override
	public double getSalarioPrimeiraParcela() {
		return super.getSalario();
	}
	
	@Override
	public double getSalarioSegundaParcela() {
		return 0.0;
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}
	
}
