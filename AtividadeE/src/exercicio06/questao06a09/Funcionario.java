package exercicio06.questao06a09;

public class Funcionario extends Pessoa {
	private int matricula;
	private double salario;
	
	public Funcionario(int matricula, double salario) {
		this.matricula = matricula;
		this.salario = salario;
	}
	
	public double getSalarioPrimeiraParcela() {
		return this.salario * 0.6;
	}
	
	public double getSalarioSegundaParcela() {
		return this.salario * 0.4;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}
