package exercicio06.questao02;

public class Main {
	public static void main(String[] args) {
		CalculadoraCientifica calc = new CalculadoraCientifica(5, 2);
		System.out.println("Exponencicao: "+ calc.exponenciar());
		System.out.println("Dividir e arredondar: "+ calc.dividir(true) +"\n");
	}
}
