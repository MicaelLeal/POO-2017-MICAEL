package Questao03_D;

public class Funcionario {
	private String nome;
	public Cargo cargo;
	private String cpf;
	private double salario;
	
	void recebeAumento(double valor){
		this.salario += valor;
	}
	
	double calculaGanhoAnual(){
		return this.salario * 12;
	}
	
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	Funcionario(String nome, String cpf){
		this.nome = nome;
		this.cpf = cpf;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}
	
	

}
