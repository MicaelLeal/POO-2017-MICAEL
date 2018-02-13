package exceptions;

@SuppressWarnings("serial")
public class SaldoInsuficienteException extends RuntimeException{
	public SaldoInsuficienteException(Double valor) {
		super("Saldo insuficiente para sacar valor de: "+ valor +" R$");
	}
}
