package exercicio;

public class Main {
	public static void main(String[] args) {
		Conta conta = new ContaCorrente();
		Conta contaCorrente = new ContaCorrente();
		Conta contaPoupanca = new ContaPoupanca();
		
		conta.deposita(1000);
		contaCorrente.deposita(1000);
		contaPoupanca.deposita(1000);
		
		conta.atualiza(0.1);
		contaCorrente.atualiza(0.1);
		contaPoupanca.atualiza(0.1);
	}
}
