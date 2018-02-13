package ExercicioCap5;


public class Funcionario {
	
	private String nome;
	private String departamento;
	public Data dataDeEntrada;
	private double salario;
	private String rg;
	
	Funcionario(String nome, String rg){
		this.nome = nome;
		this.rg = rg;
	}
	
	void recebeAumento(double aumento){
		this.salario += aumento;
	}
	
	double calculaGanhoAnual(){
		return this.salario * 12;
	}

	
	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public String getRg() {
		return rg;
	}

	public String mostra(){
		return "\nNome: " + this.getNome() + "\n"
				+ "Departamento: " + this.getDepartamento() + "\n"
				+ "RG: " + this.getRg() + "\n"
				+ "Data de entrada: " + this.dataDeEntrada.formatada() + "\n"
				+ "Salario: " + this.getSalario() + "\n"
				+ "Ganho anual: " + this.calculaGanhoAnual();
	}


}