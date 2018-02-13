package Questao03_C;

public class Proprietario {
	private String nome;
	private String cpf;
	
	Proprietario(String nome, String cpf){
		this.nome = nome;
		this.cpf = cpf;
	}
	
	void compraApartamento(Apartamento ap){
		ap.setProprietario(this);
	}
		

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

}
