package capitulo10.model.questao01;

public class Retangulo implements AreaCalculavel{
	private int lado1;
	private int lado2;
	
	
	public Retangulo(int lado1, int lado2) {
		this.lado1 = lado1;
		this.lado2 = lado2;
	}

	@Override
	public double calculaArea() {
		return this.lado1 * this.lado2;
	}

	public int getLado1() {
		return lado1;
	}

	public void setLado1(int lado1) {
		this.lado1 = lado1;
	}

	public int getLado2() {
		return lado2;
	}

	public void setLado2(int lado2) {
		this.lado2 = lado2;
	}
		
}
