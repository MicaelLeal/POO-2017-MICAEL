package exercicio04extra;

public class Cadastro {
	private Pessoa[] listaCadastro;
	private int ultimo;
	
	public Cadastro(int tamanho) {
		this.listaCadastro = new Pessoa[tamanho];
		this.ultimo = 0;
	}
	
	public void cadastrar(Pessoa pessoa) {
		if (this.listaCadastro.length > this.ultimo) {
			this.listaCadastro[ultimo] = pessoa;
			this.ultimo++;
		}
	}
	
	public Pessoa buscarPorId(int id) {
		for (int i = 0; i < this.ultimo; i++) {
			if (this.listaCadastro[i].getId() == id)
				return this.listaCadastro[i];
		}
		return null;
	}
	
	public void atualizar(Pessoa pessoa) {
		Pessoa pessoa2 = this.buscarPorId(pessoa.getId());
		if (pessoa2 != null)
			pessoa2 = pessoa;
	}
	
	public void salvar(Pessoa pessoa) {
		if(this.buscarPorId(pessoa.getId()) != null)
			this.atualizar(pessoa);
		else
			this.cadastrar(pessoa);
	}
	
}
