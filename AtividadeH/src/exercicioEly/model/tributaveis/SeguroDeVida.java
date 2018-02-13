package exercicioEly.model.tributaveis;

public class SeguroDeVida implements Tributavel {
	
	public SeguroDeVida() {	}
	
	@Override
	public double calcularTributos() {
		return 50.00;
	}
	
}
