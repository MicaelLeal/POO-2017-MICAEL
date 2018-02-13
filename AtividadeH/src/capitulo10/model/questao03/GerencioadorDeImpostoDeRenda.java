package capitulo10.model.questao03;

import capitulo10.model.questao02.Tributavel;

public class GerencioadorDeImpostoDeRenda {
	private double total;
	
	public GerencioadorDeImpostoDeRenda() { }
	
	public void adiciona(Tributavel tributavel) {
		this.total += tributavel.calculaTributos();
	}

	public double getTotal() {
		return total;
	}
	
}
