package exercicio05;

public class Main {
	public static void main(String[] args) {
		// Quest�o 03.
		Calculadora calculadora = new Calculadora(4, 4);
		System.out.println("Soma = "+ calculadora.somar());
		System.out.println();
		
		// Quest�o 04.
		ContaImposto conta = new ContaImposto("123", 10000);
		conta.debitar(500);
		
		// Questao 05.
		Hora hora = new Hora(12, 34, 59);
		
		System.out.println(hora.formatada());
		System.out.println();
		
		// Quest�es 06 e 07.
		// Feitas no exercicio 04.
		
	}
}
