package exercicioEly.model.figurasGeometricas;

public class Retangulo implements FiguraGeometrica{
	private int lado1;
	private int lado2;
	
	public Retangulo(int lado1, int lado2) {
		this.lado1 = lado1;
		this.lado2 = lado2;
	}

	@Override
	public int comparar(FiguraGeometrica figura) {
		if (this.calculaArea() < figura.calculaArea())
			return -1;
		else if (this.calculaArea() == figura.calculaArea())
			return 0;
		return 1;
	}

	@Override
	public double calculaArea() {
		return this.lado1 * this.lado2;
	}

	@Override
	public double calculaPerimetro() {
		return this.lado1*2 + this.lado2*2;
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
