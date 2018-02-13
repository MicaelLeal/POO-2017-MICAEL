
public class Porta {
	
	boolean aberta = false;
	String cor;
	double dimensaoX, dimensaoY, dimensaoZ;
	
	void abre(){
		this.aberta = true;
	}
	void fecha(){
		this.aberta = false;
	}
	
	void pinta(String s){
		this.cor = s;
	}
	
	boolean estaAberta(){
		return (this.aberta) ? true : false;
	}

}
