package exercicio02;

public class Saudacao {
	private String texto;
	private String destinatario;
	
	public Saudacao(String destinatario) {
		this.destinatario = destinatario;
		this.texto = "Bom dia, ";
	}
	
	public String obterSaudacao() {
		return this.texto + this.destinatario + "!";
	}
}
