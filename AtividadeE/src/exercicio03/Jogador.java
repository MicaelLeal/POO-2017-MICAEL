package exercicio03;

public class Jogador {
	private int forca;
	private int nivel;
	private int pontos;
	
	public Jogador(int forca, int nivel, int pontos) {
		this.forca = forca;
		this.nivel = nivel;
		this.pontos = pontos;
	}
	
	public int calcularAtaque() {
		return this.forca * this.nivel;
	}
	
	public void atacar(Jogador adversario) {
		adversario.pontos -= this.calcularAtaque();
	}

	public int getPontos() {
		return pontos;
	}	
}
