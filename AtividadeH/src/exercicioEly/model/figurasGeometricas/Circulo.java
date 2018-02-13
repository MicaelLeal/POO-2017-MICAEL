package exercicioEly.model.figurasGeometricas;

public class Circulo implements FiguraGeometrica {
	
	private int raio;
	
	public Circulo(int raio) {
		this.raio = raio;
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
		return this.raio * this.raio * 3.14159;
	}

	@Override
	public double calculaPerimetro() {
		return 3.14159 * this.raio;
	}

	public int getRaio() {
		return raio;
	}

	public void setRaio(int raio) {
		this.raio = raio;
	}
	
	public int getDiametro() {
		return this.raio *2;
	}
	
}
