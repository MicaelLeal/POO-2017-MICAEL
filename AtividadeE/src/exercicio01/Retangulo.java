package exercicio01;

public class Retangulo {
	private int lado1;
	private int lado2;
	
	public Retangulo() {	}
	
	public int calculaArea() {
		return this.lado1 * this.lado2;
	}
	
	public int calculaPerimetro() {
		return (this.lado1 + this.lado2) *2;
	}
	
	public String getLados() {
		return "lado1: "+ this.lado1 +"\n"
				+"lado2: "+ this.lado2 +"\n";
	}
	
	public void setLados(int lado1, int lado2) {
		this.lado1 = lado1;
		this.lado2 = lado2;
	}
}
