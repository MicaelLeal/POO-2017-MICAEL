package Questao04;

public class Split {
	private String marca;
	private String modelo;
	public boolean ligado;
	public int temperaturaAlvo;
	public int velocidadeVentilador;
	public String modo;
	
	Split(String marca, String modelo){
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	void liga(){
		this.ligado = true;
	}
	
	void desliga(){
		this.ligado = false;
	}
	
	void aumentaTemperatura(int qtd){
		this.temperaturaAlvo += qtd;
	}
	
	void diminuiTemperatura(int qtd){
		this.temperaturaAlvo -= qtd;
	}

	public void setModo(String modo) {
		this.modo = modo;
	}
	

}
