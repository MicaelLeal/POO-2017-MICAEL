package capitulo10.model.questao01;

public class Circulo implements AreaCalculavel {
	private int raio;
	
	public Circulo(int raio) {
		this.raio = raio;
	}
	
	@Override
	public double calculaArea() {
		return Math.PI * this.raio * this.raio;
	}

	public int getRaio() {
		return raio;
	}

	public void setRaio(int raio) {
		this.raio = raio;
	}

}
