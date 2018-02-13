package exercicio02;

public class Main {
	public static void main(String[] args) {
		// Questão 06.
		System.out.println("Olá.. Tudo bem!");
		
		// Questão 07 e 08.
		Saudacao saudacao = new Saudacao("Irineu");
		System.out.println(saudacao.obterSaudacao() +"\n");
		
		// Questao 10.
		Soma soma = new Soma(4, 5);
		System.out.println("Soma: " + soma.calculaSoma() +"\n");
		
		// Questão 11.
		DecimalNumero numeroDecimal = new DecimalNumero(5.5);
		System.out.println(numeroDecimal.getNumber());
		System.out.println(numeroDecimal.getParteInteira());
		System.out.println(numeroDecimal.getParteDecimal() +"\n");
		
		// Questão 12.
		Desconto desconto = new Desconto(120, 10);
		System.out.println(desconto.calcula() +"\n");
		
		// Questão 13.
		NumberUtils number = new NumberUtils(9);
		System.out.println(number.isPair());
		System.out.println(number.isOdd());
		System.out.println(number.isPrime());
		System.out.println(number.printCount());
		System.out.println(number.reversePrintCount());
		
		// Questões 14 e 15.
		Equipamento equipamento1 = new Equipamento();
		Equipamento equipamento2 = new Equipamento();
		equipamento1.liga();
		equipamento1.inverte();
		equipamento2.inverte();
		
		if (equipamento1.isLigado())
			System.out.println("Ligado!");
		else
			System.out.println("Desligado!");
		
		if (equipamento2.isLigado())
			System.out.println("Ligado");
		else
			System.out.println("Desligado!");
	}
}
