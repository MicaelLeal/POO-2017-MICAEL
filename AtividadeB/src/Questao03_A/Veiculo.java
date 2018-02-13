package Questao03_A;

public class Veiculo {
	public int ano;
	public String modelo;
	private Montadora montadora;
	private boolean ligado;
	
	Veiculo(String modelo){
		this.modelo = modelo;
		this.ligado = false;
	}
	
	public Montadora getMontadora(){
		return this.montadora;
	}
	
	void liga(){
		this.ligado = true;
		System.out.println("Ligado");
	}
	
	void desliga(){
		this.ligado = false;
		System.out.println("Desligado");
	}
	
	
	
}
