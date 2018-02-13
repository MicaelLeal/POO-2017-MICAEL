package exercicio04extra;

public class Main {
	public static void main(String []args) {
		// Questão 03.
		Triangulo triangulo = new Triangulo(3, 4, 3);
		System.out.println(triangulo.formaTriangulo() ? "Forma um triangulo" : "Nao forma triangulo");
		if (triangulo.ehEquilatero())
			System.out.println("Triangulo equilatero.");
		if (triangulo.ehIsoceles())
			System.out.println("Triangulo isoceles.");
		if (triangulo.ehEscaleno())
			System.out.println("Triangulo escaleno.");
		System.out.println();
		
		// Questão 04.
		Pilha pilha = new Pilha(5);
		for (int i = 1; i <= 5; i++)
			pilha.empilhar(i);
		System.out.println(pilha.empilhar(6) ? "Coube mais um" : "Pilha cheia");
		System.out.println();
		
		// Questao 10.
		Cadastro cadastro = new Cadastro(5);
		for (int i = 1; i < 4; i++) {
			cadastro.cadastrar(new Pessoa(i, "Pessoa"+i));
		}
		Pessoa pessoa = new Pessoa(3, "Pessoa3");
		cadastro.salvar(pessoa);	
		
	}
}
