package ExercicioCap6.exercicioPonto8;
public class Funcionario {
	
	private static int contadorDeIdentificadores;
	private int identificador;
	private String nome;
	public String departamento;
	public Data dataDeEntrada;
	private double salario;
	private String rg;
	
	public Funcionario(){
		this(null, null);
	}	
	public Funcionario(String nome, String rg){
		this.identificador = ++Funcionario.contadorDeIdentificadores;
		this.nome = nome;
		this.rg = rg;

	}
	public void setSalario(double valor){
		this.salario = valor;
	}
	
	public void recebeAumento(double aumento){
		this.salario += aumento;
	}
	
	public double getGanhoAnual(){
		return this.salario * 12;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getRg(){
		return this.rg;
	}
	
	public double getSalario(){
		return this.salario;
	}
	
	public int getIdentificador(){
		return this.identificador;
	}
	
	public String mostra(){
		String atributosFuncionario = "Identificador: "+ this.getIdentificador() + "\n"
				+ "Nome: "+ this.getNome() + "\n"
				+ "RG: "+ this.getRg() + "\n"
				+ "Departamento: "+ this.departamento + "\n"
				+ "Data de entrada: "+ this.dataDeEntrada.formatada() + "\n"
				+ "Salario: "+ this.getSalario() + "\n"
				+ "Ganho anual: "+ this.getGanhoAnual() + "\n";
		return atributosFuncionario;
	}

}
