package exercicio04;

public class Senha {
	private String valor;
	
	public Senha(String valor) {
		this.valor = valor;
	}
	
	public boolean iguais(String valor) {
		if (this.valor.equals(valor))
			return true;
		else
			return false;
	}
	
	public boolean iguaisTrim(String valor) {
		if (this.valor.trim().equals(valor.trim()))
			return true;
		else
			return false;
	}
	
	public boolean tamanhoSeguro() {
		return (this.valor.length() >= 6) ? true : false;
	}
	
	public boolean posuiMaiusculaMinuscula() {
		boolean maiuscula = false;
		boolean minuscula = false;
		int i = -1;
		while ((!maiuscula || !minuscula) && ++i < this.valor.length()) {
			if (this.valor.charAt(i) > 'Z')
				minuscula= true;
			else if (this.valor.charAt(i) >= 'A')
				maiuscula = true;
		}
		return (maiuscula && minuscula) ? true : false;
	}
	
	public boolean posuiNumeo() {
		for (int i = 0; i < this.valor.length(); i++) {
			if (this.valor.charAt(i) < 'A')
				return true;
		}
		return false;
	}
	
	public boolean ehValida() {
		return (this.tamanhoSeguro() && this.posuiMaiusculaMinuscula() && this.posuiNumeo()) ? true : false;
	}
	
	public String getValor() {
		return this.valor;
	}
	
}
