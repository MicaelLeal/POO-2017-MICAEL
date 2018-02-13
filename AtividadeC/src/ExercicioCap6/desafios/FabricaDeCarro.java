package ExercicioCap6.desafios;

public class FabricaDeCarro {
	private static FabricaDeCarro instancia;
	private String nome;
	private String cnpj;
	private String endereco;
	
	private FabricaDeCarro(String nome, String cnpj) {
		this.nome = nome;
		this.cnpj = cnpj;
	}
	
	public static FabricaDeCarro getInstancia() {
		return instancia;
	}
	
	public static FabricaDeCarro instaciar(String nome, String cnpj) {
		if (instancia == null) {
			instancia = new FabricaDeCarro(nome, cnpj);
			return instancia;
		}
		return instancia;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
