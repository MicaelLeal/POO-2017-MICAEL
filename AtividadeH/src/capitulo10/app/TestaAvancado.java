package capitulo10.app;

import capitulo10.model.avancados.*;
import capitulo10.model.questao02.Tributavel;

public class TestaAvancado {
	public static void main(String[] args) {
		Conta c = new ContaCorrente(1000);
		Tributavel t = new ContaCorrente(1000);
		
		System.out.println(c.getSaldo());
		System.out.println(t.calculaTributos());
		
	}
}
