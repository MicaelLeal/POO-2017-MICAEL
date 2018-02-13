package ExercicioCap6.exercicioPonto8;
public class Empresa {
	
	private String nome;
	private String cnpj;
	private Funcionario[] empregados;
	private String endereco;
	private int ultimo = 0;
	
	public Empresa(int qtdFuncionarios){
		this.empregados = new Funcionario[qtdFuncionarios];
	}
	
	public void aumentaVagas(){
		Funcionario[] novoVetorFunc = new Funcionario[this.ultimo + 5];
		for (int i = 0; i < this.ultimo; i++){
			novoVetorFunc[i] = this.empregados[i];
		}
		this.empregados = novoVetorFunc;
	}
	
	public void adiciona(Funcionario f){
		if (this.empregados.length > this.ultimo){
			this.empregados[this.ultimo] = f;
			this.ultimo++;
		}else{
			this.aumentaVagas();
			this.adiciona(f);
		}
	}
	
	public String mostraEmpregados(){
		String atributosFuncionarios = "";
		for (int i = 0; i < this.ultimo; i++){
			atributosFuncionarios += "\nFuncionario na posicao " + i +":" + "\n"
					+ this.empregados[i].mostra();
		}
		return atributosFuncionarios;
	}
	
	public boolean contem(Funcionario f){
		for (Funcionario x : this.empregados){
			if (x == f){
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

	public String getEndereco() {
		return endereco;
	}

	public Funcionario getFuncionarios(int posica) {
		return this.empregados[posica];
	}
	
}
