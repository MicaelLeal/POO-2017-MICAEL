package AtividadeDeFixacao5;

public class Casa {
	private String cor;
	private int totalDePortas;
	private Porta[] portas;
	
	public Casa(String cor, Porta p1, Porta p2){
		this.cor = cor;
		this.totalDePortas = 2;
		this.portas = new Porta[10];
	}
	
	public void pinta(String cor){
		this.cor = cor;
	}
	
	public int quantasPortasAbertas(){
		int cont = 0;
		for (int i = 0; i < this.totalDePortas; i++){
			if (this.portas[i].isAberta()){
				cont++;
			}
		}
		return cont;
	}
	
	public boolean adicionaPorta(Porta p){
		if (this.totalDePortas < 10){
			this.portas[this.totalDePortas++] = p;
			return true;
		}else return false;
		
	}
	
	public int totalDePortas(){
		return this.totalDePortas;
	}

	public String getCor() {
		return cor;
	}
	
	public String mostraCasa(){
		String stringCasa = "Cor:" + this.cor+ "\n"
				+ "Total de portas: " + this.totalDePortas + "\n";
		for (int i = 0; i < this.totalDePortas; i++){
			stringCasa += "\nPorta" + i + "\n"
					+ "Cor: " + this.portas[i].getCor() + "\n"
					+ "Aberta: " + this.portas[i].isAberta() + "\n";
		}
		return stringCasa;
	}
	

}
