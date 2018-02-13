package exercicio03;

public class Main {
	public static void main(String[] args) {
		
		// Questão 07.
		Jogador jogador1 = new Jogador(5, 2, 100);
		Jogador jogador2 = new Jogador(4, 3, 100);
		
		jogador1.atacar(jogador2);
		jogador2.atacar(jogador1);
		
		System.out.println("Pontos jogador 1: "+ jogador1.getPontos());
		System.out.println("Pontos jogador 2: "+ jogador2.getPontos() + "\n");
		
		// Questão 08.
		Conta conta1 = new Conta("12345", 1000);
		conta1.depositar(1000);
		conta1.sacar(200);
		
		Conta conta2 = new Conta("12345", 500);
		conta2.depositar(900);
		
		conta1.tranferir(conta2, 200);
		
		System.out.println("Saldo conta1: " + conta1.consultarSaldo() + "\n"
				+ "Saldo conta2: "+ conta2.consultarSaldo() +"\n");
		
		// Questão 09.
		Produto produto1 = new Produto(2, "Arroz", 4.50, 20);
		Produto produto2 = new Produto(2, "Arroz", 4.00, 10);
		
		produto1.baixar(15);
		produto2.repor(10);
		produto2.reajusta(10);
		
		System.out.println(produto1 +"\n"
				+ produto2 + "\n"
				+ ((produto2.equals(produto1)) ? "Produtos de mesmo codigo" : "Produtos de codigo diferente"));
		
	}
}
