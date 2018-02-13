package exercicio06;

public class Main {
	public static void main(String[] args) {
		// Questão 01.
		Horista horista = new Horista();
		horista.setSalario(1000);
		System.out.println(horista.calcSalario());
		
		// Questão 02.
		CalculadoraCientifica calc = new CalculadoraCientifica(5, 2);
		System.out.println("Exponencicao: "+ calc.exponenciar());
		System.out.println("Dividir e arredondar: "+ calc.dividir(true));
		
		// Questão 03.
		Animal animal1 = new Animal();
		Bovino animal2 = new Bovino();
		Peixe animal3 = new Peixe();
		animal1.setEspecie("Lobo");
		animal2.setProducaoLeite(50.0);
		animal3.setProfundidade(5);

		
	}
}
