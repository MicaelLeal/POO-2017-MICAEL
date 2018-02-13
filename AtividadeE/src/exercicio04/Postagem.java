package exercicio04;

public class Postagem {
	private int id;
	private String texto;
	private int qtdCurtidas;
	
	public Postagem(int id) {
		this.id = id;
	}
	
	public void curtir() {
		this.qtdCurtidas++;
	}
	
	public String toString() {
		return this.texto +"\n"
				+"Curtidas: "+ this.qtdCurtidas +"\n";
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getQtdCurtidas() {
		return this.qtdCurtidas;
	}
}
