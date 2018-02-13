package exercicio03extra;

public class Main {
	public static void main(String[] args) {
		//Questão 08.
		Carro carro1 = new Carro("ASD1234", 1224134, "Hilux", "2020");
		Carro carro2 = new Carro("ASD1234", 1224134, "Hilux", "2020");
		
		System.out.println("Carro clonado? ->"+ carro1.clonado(carro2)+ "\n");
		
		// Questão 09.
		ImpostoDeRenda imposto = new ImpostoDeRenda(1000000);
		System.out.println("Renda bruta: " + imposto.getRendaBruta() +"\n"
				+"Imposto: "+ imposto.calculaImposto() +"\n"
				+"Renda liquida: "+ imposto.calculaRendaLiquida() +"\n");
		
		// Questão 10.
		Jogador jogador1 = new Jogador();
		Jogador jogador2 = new Jogador();
		
		for (int i = 0; i < 5; i++)
			jogador1.perdeVida();
		
		jogador2.perdeVida();
		jogador1.doarVida(jogador2);
		
		System.out.println("Vidas jogador1: " + jogador1.getVidas() +"\n"
				+"Vidas jogador2: "+ jogador2.getVidas());
		
		jogador2.doarVida(jogador1);
		
		System.out.println("Vidas jogador1: " + jogador1.getVidas() +"\n"
				+"Vidas jogador2: "+ jogador2.getVidas());
		
	}
}
