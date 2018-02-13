package exercicioPonto7;

public class Banco {
	private String nome;
	private Conta[] contas;
	private int ultimo;
	
	public Banco(String nome, int qtdContas) {
		this.contas = new Conta[qtdContas];
		this.ultimo = 0;
	}
	
	private void aumentaVetorContas() {
		Conta[] vetorContasTemp = new Conta[this.ultimo + 5];
		for (int i = 0; i < this.ultimo; i++)
			vetorContasTemp[i] = contas[i];
		this.contas = vetorContasTemp;
	}
	
	public void adiciona(Conta conta) {
		if (this.ultimo < this.contas.length){
			contas[ultimo] = conta;
			this.ultimo++;
		}
		else {
			this.aumentaVetorContas();
			this.adiciona(conta);
		}
	}
	
	public Conta pegaConta(int indice) {
		return this.contas[indice];
	}
	
	public String mostraContas() {
		String infoContas = "";
		for (int i = 0; i < this.ultimo; i++)
			infoContas += "Conta "+ (i+1) +": "+ this.contas[i].getSaldo() +"\n";		
		return infoContas;
	}
	
	public int getTotalDeContas() {
		return this.ultimo;
	}
	
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
