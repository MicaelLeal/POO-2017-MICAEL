package AtividadeDeFixacao5;

public class Porta {
	private String cor;
	private boolean aberta;
	
	Porta(String cor){
		this.cor = cor;
		this.aberta = false;
	}
	
	public void pint(String cor){
		this.cor = cor;
	}

	public String getCor() {
		return cor;
	}

	public boolean isAberta() {
		return aberta;
	}

}
