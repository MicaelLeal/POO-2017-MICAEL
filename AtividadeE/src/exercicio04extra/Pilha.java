package exercicio04extra;

public class Pilha {
	private int elementos[];
	private int ultimo;
	
	public Pilha(int tamanho) {
		this.elementos = new int[tamanho];
		this.ultimo = 0;
	}
	
	public boolean empilhar(int valor) {
		if (this.elementos.length > this.ultimo) {
			this.elementos[ultimo] = valor;
			this.ultimo++;
			return true;
		} else
			return false;
	}
}
