package exercicioEly.model.figurasGeometricas;

public class Quadrado implements FiguraGeometrica {
	
	private int lado;
	
	public Quadrado(int lado) {
		this.lado = lado;
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
		return this.lado * this.lado;
	}

	@Override
	public double calculaPerimetro() {
		return this.lado * 4;
	}

	public int getLado() {
		return lado;
	}

	public void setLado(int lado) {
		this.lado = lado;
	}

}
