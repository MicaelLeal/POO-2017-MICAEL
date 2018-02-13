package exercicio06.questao10;

public class Main {
	public static void main(String[] args) {
		Banco banco = new Banco(10);
		
		Conta conta1 = new ContaPoupanca("001", 1000);
		Conta conta2 = new ContaImposto("002", 2000);
		
		banco.inserir(conta1);
		banco.inserir(conta2);
		
		banco.debitar("002", 500);
		System.out.println(conta2.getSaldo());
		
		System.out.println(banco.atualizarPoupanca("002", 0.1) ? "Conta atualizada" : "Poupanca inesistente");
	}
}
