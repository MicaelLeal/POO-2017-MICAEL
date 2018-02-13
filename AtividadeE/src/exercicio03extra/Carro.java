package exercicio03extra;

public class Carro {
	private String placa;
	private long chassi;
	private String modelo;
	private String ano;
	
	public Carro(String placa, long chassi, String modelo, String ano) {
		this.placa = placa;
		this.chassi = chassi;
		this.modelo = modelo;
		this.ano = ano;
	}
	
	boolean clonado(Carro carro) {
		return (this.placa == carro.placa && this.chassi == carro.chassi) ? true : false;
	}

	public String getPlaca() {
		return placa;
	}

	public long getChassi() {
		return chassi;
	}

	public String getModelo() {
		return modelo;
	}

	public String getAno() {
		return ano;
	} 
}
