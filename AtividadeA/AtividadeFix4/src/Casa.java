
public class Casa {
	String cor;
	Porta p1 = new Porta();
	Porta p2 = new Porta();
	Porta p3 = new Porta();
	
	void pinta(String s){
		this.cor = s;
	}
	
	int quantasPortasAbertas(){
		int qtd = 0;
		if (this.p1.estaAberta()){
			qtd++;
		}
		if (this.p2.estaAberta()){
			qtd++;
		}
		if (this.p3.estaAberta()){
			qtd++;
		}
		return qtd;
	}
}
