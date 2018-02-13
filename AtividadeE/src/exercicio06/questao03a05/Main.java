package exercicio06.questao03a05;

public class Main {
	public static void main(String[] args) {
		// Questão 03.
		Animal animal1 = new Animal();
		Animal animal2 = new Bovino();
		Animal animal3 = new Peixe();
		animal1.setEspecie("Lobo");
		((Bovino)animal2).setProducaoLeite(50.0);
		((Peixe)animal3).setProfundidade(5);
		
		// Questao 05.
		Animal[] animais  = new Animal[7];
		animais[0] = animal1;
		animais[1] = animal2;
		animais[2] = animal3;
		animais[3] = new Animal();
		animais[4] = new Bovino();
		animais[5] = new Peixe();
		animais[6] = new Bovino();
		
		for (int i = 0; i < 7; i++) {
			System.out.println("\nElemento"+i +":");
			if (animais[i] instanceof Animal) {
				System.out.println("Animal");
			}
			if (animais[i] instanceof Bovino) {
				System.out.println("Bovino");
			}
			if (animais[i] instanceof Peixe) {
				System.out.println("Peixe");
			}
		}
	}
}
