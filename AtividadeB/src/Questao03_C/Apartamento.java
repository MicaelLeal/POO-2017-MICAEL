package Questao03_C;

public class Apartamento {
	
	private Proprietario proprietario;
	public String endereco;
	
	Apartamento(Proprietario proprietario){
		this.proprietario = proprietario;
	}
	
	public Proprietario getProprietario() {
		return proprietario;
	}
	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	public String getEndereco() {
		return endereco;
	}
	
	
	

}
