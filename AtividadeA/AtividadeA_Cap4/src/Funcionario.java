
public class Funcionario {
	
	private String nome;
	public String departamento;
	public Data dataDeEntrada;
	private double salario;
	private String rg;
	
	Funcionario(String nome, String rg){
		this.nome = nome;
		this.rg = rg;
	}
	void setSalario(double valor){
		this.salario = valor;
	}
	
	void recebeAumento(double aumento){
		this.salario += aumento;
	}
	
	double calculaGanhoAnual(){
		return this.salario * 12;
	}
	
	String getNome(){
		return this.nome;
	}
	
	String getRg(){
		return this.rg;
	}
	
	double getSalario(){
		return this.salario;
	}
	
	void mostra(){
		System.out.println("Nome: "+ this.getNome());
		System.out.println("RG: "+ this.getRg());
		System.out.println("Departamento: "+ this.departamento);
		System.out.println("Data de entrada: "+ this.dataDeEntrada.formatada());
		System.out.println("Salario: "+ this.getSalario());
		System.out.println("Ganho anual: "+ this.calculaGanhoAnual());
	}

}
