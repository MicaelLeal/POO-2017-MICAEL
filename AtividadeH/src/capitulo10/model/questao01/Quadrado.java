package capitulo10.model.questao01;

public class Quadrado implements AreaCalculavel {
	
	private int lado;
	
	public Quadrado(int lado) {
		this.lado = lado;
	}
	
	@Override
	public double calculaArea() {
		return this.lado * this.lado;
	}

	
	
	public int getLado() {
		return lado;
	}

	public void setLado(int lado) {
		this.lado = lado;
	}

}
