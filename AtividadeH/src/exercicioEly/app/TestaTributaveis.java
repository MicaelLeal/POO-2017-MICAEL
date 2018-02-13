package exercicioEly.app;

import exercicioEly.model.tributaveis.*;

public class TestaTributaveis {
	public static void main(String[] args) {
		AuditoriaInterna auditorial = new AuditoriaInterna(10);
		
		for (int i = 1; i <= 5; i++) {
			auditorial.adicionar(new ContaCorrente(i*100));
		}
		
		for (int i = 1; i <= 5; i++) {
			auditorial.adicionar(new SeguroDeVida());
		}
		
		System.out.println("Tributos totais: "+ auditorial.calcularTributos());
		
	}
}
