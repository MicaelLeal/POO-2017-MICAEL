package exercicio03extra;

public class Jogador {
	private int vidas;
	
	public Jogador() {
		this.vidas = 5;
	}
	
	public boolean isLimiteMaxVidas() {
		return (this.vidas == 5) ? true : false;
	}
	
	public boolean  isLimiteMinVidas() {
		return (this.vidas == 0) ? true : false;
	}
	
	public void ganhaVida() {
		if (!this.isLimiteMaxVidas())
			this.vidas++;
	}
	
	public void perdeVida() {
		if (!this.isLimiteMinVidas())
			this.vidas--;
	}
	
	public boolean doarVida(Jogador jogador) {
		if (!this.isLimiteMinVidas() && !jogador.isLimiteMaxVidas()) {
			this.perdeVida();
			jogador.ganhaVida();
			return true;
		} else
			return false;
	}

	public int getVidas() {
		return vidas;
	}
	
}
