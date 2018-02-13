package exercicio01;

public class Main {
	public static void main(String[] args){
		// Questão 07.
		Retangulo retangulo = new Retangulo();
		retangulo.setLados(10, 20);
		
		System.out.println(retangulo.calculaArea());
		System.out.println(retangulo.calculaPerimetro());
		
		// Questão 08.
		Circulo circulo = new Circulo(5);
		
		System.out.println(circulo.calculaArea());
		System.out.println(circulo.calculaPerimetro());
		
		// Questão 09.
		SituacaoFinanceira minhaSituacao = new SituacaoFinanceira(100.00, 1000);
		System.out.println(minhaSituacao.saldo());
	}
}
