package exercicioPonto7;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		Banco banco = new Banco("CEF", 10);
		
		Conta conta = new Conta();
		Conta contaCorrente = new ContaCorrente();
		Conta contaPoupanca = new ContaPoupanca();
		
		conta.deposita(1000);
		contaCorrente.deposita(1000);
		contaPoupanca.deposita(1000);
		
		banco.adiciona(conta);
		banco.adiciona(contaCorrente);
		banco.adiciona(contaPoupanca);
		
		AtualizadorDeContas atualizador = new AtualizadorDeContas(0.01);
		
		for (int i = 0; i < banco.getTotalDeContas(); i++) {
			atualizador.roda(banco.pegaConta(i));
		}
		
		JOptionPane.showMessageDialog(null, banco.mostraContas()
		+ "Saldo banco: " + atualizador.getSaldoTotal());
	}
}
