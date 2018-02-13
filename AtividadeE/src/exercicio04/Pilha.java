package exercicio04;

public class Pilha {
	private int elementos[];
	private int ultimo;
	
	public Pilha() {
		this.elementos = new int[5];
		this.ultimo = 0;
	}
	
	public boolean empilhar(int valor) {
		if (!this.estaCheia()) {
			this.elementos[ultimo] = valor;
			this.ultimo++;
			return true;
		} else
			return false;
	}
	
	public boolean estaCheia() {
		return (this.ultimo == 5) ? true : false;
	}
	
	public void desempilhar() {
		this.ultimo--;
	}
	
	public int retornaTopo() {
		return this.elementos[ultimo-1];
	}
	
	public String exibir() {
		String elementos = ""+ this.elementos[0];
		for (int i = 1; i < this.ultimo; i++) {
			elementos += ", "+ this.elementos[i];
		}
		return elementos;
	}
	
}
