package capitulo10.app;

import capitulo10.model.questao03.GerencioadorDeImpostoDeRenda;
import capitulo10.model.questao02.*;

public class TestaGerencioadorDeImpostoDeRenda {
	public static void main(String[] args) {
		GerencioadorDeImpostoDeRenda gerenciador = new GerencioadorDeImpostoDeRenda();
		
		SeguroDeVida sv = new SeguroDeVida();
		gerenciador.adiciona(sv);
		
		ContaCorrente cc = new ContaCorrente();
		cc.deposita(1000);
		gerenciador.adiciona(cc);
		
		System.out.printf("Total de impostos: %.2f R$", gerenciador.getTotal());

	}
}
