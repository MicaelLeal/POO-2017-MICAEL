package exercicioEly.model.figurasGeometricas;

public class Triangulo implements FiguraGeometrica {
	
	private int lado1;
	private int lado2;
	private int lado3;
	
	public Triangulo(int lado1, int lado2, int lado3) {
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado3;
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
		return 0;
	}

	@Override
	public double calculaPerimetro() {
		return this.lado1 + this.lado2 + this.lado3;
	}

	public int getLado1() {
		return lado1;
	}

	public int getLado2() {
		return lado2;
	}

	public int getLado3() {
		return lado3;
	}
}
