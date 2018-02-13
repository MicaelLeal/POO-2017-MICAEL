package capitulo10.app;

import capitulo10.model.questao02.*;

public class TesteTributavel {
	public static void main(String[] args) {
		ContaCorrente cc = new ContaCorrente();
		cc.deposita(100);
		System.out.println(cc.calculaTributos());
		
		// testando polimorfismo:
		Tributavel t = cc;
		System.out.println(t.calculaTributos());
	}
}
