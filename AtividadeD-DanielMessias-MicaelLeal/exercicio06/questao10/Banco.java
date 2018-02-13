package exercicio06.questao10;

public class Banco {
	private Conta contas[];
	private int indice;
	
	public Banco(int tamanho) {
		this.contas = new Conta[tamanho];
	}
	
	public boolean inserir(Conta conta) {
		if (this.contas.length > this.indice) {
			if (this.consultar(conta.getNumero()) == null) {
				this.contas[this.indice++] = conta;
				return true;
			}
		}
		return false;
	}
	
	public void excluir(String numero) {
		int posicao = this.consultarPosicao(numero);
		if (posicao != -1){
			for (int i = posicao; i < this.indice-1; i++)
				this.contas[i] = this.contas[i+1];
			this.contas[--indice] = null;
		}
	}
	
	public Conta consultar(String numero) {
		for (int i = 0; i < this.indice; i++) {
			if (this.contas[i].getNumero() == numero)
				return this.contas[i];
		}
		return null;
	}
	
	private int consultarPosicao(String numero) {
		for(int i = 0; i < indice; i++) {
			if(contas[i].getNumero() == numero)
				return i;
		}
		return -1; 
	}
	
	public double consultarSaldo(String numero) {
		Conta conta = this.consultar(numero);
		if (conta != null)
			return conta.getSaldo();
		return -1;
	}
	
	public boolean alterar(Conta conta) {
		Conta conta2 = this.consultar(conta.getNumero());
		if (conta2 != null){
			conta2 = conta;
			return true;
		}
		return false;
	}
	
	public boolean creditar(String numero, double valor) {
		Conta conta = this.consultar(numero);
		if (conta != null) {
			conta.creditar(valor);
			return true;
		}
		return false;
	}
	
	public boolean debitar(String numero, double valor) {
		Conta conta = this.consultar(numero);
		if (conta != null) {
			return conta.debitar(valor);
		} return false;
	}
	
	public boolean tranferir(String numDeb, String numCred, double valor) {
		Conta contaDebitante = this.consultar(numDeb);
		Conta contaDestino = this.consultar(numCred);
		if (contaDebitante != null && contaDestino != null) {
			return contaDebitante.transferir(contaDestino, valor);
		}
		return false;
	}
	
	public boolean atualizarPoupanca(String numero, double taxa) {
		Conta conta = this.consultar(numero);
		if (conta != null && (conta instanceof ContaPoupanca)) {
			((ContaPoupanca) conta).atualiza(taxa);
			return true;
		} return false;
	}
	
	public int qtdContas() {
		return this.indice;
	}
	
	public double getSaldoTotal() {
		double saldo = 0;
		for (int i = 0; i < this.indice; i++) {
			saldo += this.contas[i].getSaldo();
		}
		return saldo;
	}
	
	public double mediaSaldos() {
		return this.getSaldoTotal() / this.qtdContas();
	}
}
