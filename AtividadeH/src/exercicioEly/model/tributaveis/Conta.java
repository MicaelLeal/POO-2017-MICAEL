package exercicioEly.model.tributaveis;

public abstract class Conta {
	
	private String nome;
	private double saldo;
	
	public Conta(double saldoInicial) {
		this.saldo = saldoInicial;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
