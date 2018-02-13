package exercicio04;

public class MicroBlog {
	private Postagem[] postagens;
	private int indice;
	
	public MicroBlog(int qtdMaximaDePostagens) {
		this.postagens = new Postagem[qtdMaximaDePostagens];
	}
	
	public boolean novaPostagem(Postagem postagem) {
		if (this.postagens.length > this.indice) {
			this.postagens[indice] = postagem;
			this.indice++;
			return true;
		}
		return false;
	}
	
	public boolean excluirPostagem(int id) {
		int posicao = this.pegarPosicao(id);
		if (posicao != -1) {
			for (int i = posicao; i < this.indice -1; i++){
				this.postagens[i] = this.postagens[i+1];
			}
			this.postagens[--this.indice] = null;
			return true;
		}
		return false;
	}
	
	public int pegarPosicao(int id) {
		for (int i = 0; i < this.indice; i++) {
			if(this.postagens[i].getId() == id)
				return i;
		}
		return -1; 
	}
	
	public Postagem pegarPostagemMaisCurtida() {
		Postagem postagem = this.postagens[0];
		for (int i = 0; i < this.indice; i++){
			if (this.postagens[i].getQtdCurtidas() > postagem.getQtdCurtidas()) {
				postagem = this.postagens[i];
			}
		}
		return postagem;
	}
	
	public void curtirPostagem(int id) {
		for (int i = 0; i < this.indice; i++) {
			if (this.postagens[i].getId() == id) {
				this.postagens[i].curtir();
				break;
			}
		}
	}
	
}
