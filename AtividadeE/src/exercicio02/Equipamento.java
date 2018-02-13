package exercicio02;

public class Equipamento {
	private boolean ligado;
	
	public Equipamento() {
		this.ligado = false;
	}
	
	public void liga() {
		if (!this.isLigado())
			this.ligado = true;
	}
	
	public void desliga() {
		if (this.isLigado())
			this.ligado = false;
	}
	
	public void inverte() {
		if (this.isLigado())
			this.desliga();
		else
			this.liga();
	}

	public boolean isLigado() {
		return ligado;
	}	
}
