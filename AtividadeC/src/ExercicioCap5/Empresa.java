package ExercicioCap5;


public class Empresa {
	
	private String nome;
	private String cnpj;
	private Funcionario []empregados;
	private int pos;
	
	public Empresa(String nome, String cnpj){
		this.nome = nome;
		this.cnpj = cnpj;
		this.empregados = new Funcionario[10];
		this.pos = 0;
	}
	
	public void adiciona(Funcionario f){
		if (this.pos < this.empregados.length){
			this.empregados[this.pos] = f;
			this.pos++;
		}else{
			aumentaVagas();
			this.adiciona(f);
		}
	}
	
	private void aumentaVagas(){
		Funcionario[] empregadosTemp = new Funcionario[this.empregados.length + 5];
		for (int i = 0; i < this.pos; i++){
			empregadosTemp[i] = this.empregados[i];
		}
		this.empregados = empregadosTemp;
	}
	
	public String mostraEmpregados(){
		String stringFuncionarios = "Funcionarios:\n";
		
		for (int i = 0; i < this.pos; i++){
			stringFuncionarios += "Funcionario na posicao "+i + "\n"
					+ this.empregados[i].mostra();
		}		
		return stringFuncionarios;
	}
	
	boolean contem(Funcionario f){
		for (int i = 0; i < this.pos; i++){
			if (this.empregados[i] == f){
				return true;
			}
		}
		return false;
	}
	

	public String getNome() {
		return nome;
	}

	public String getCnpj() {
		return cnpj;
	}
	

}
