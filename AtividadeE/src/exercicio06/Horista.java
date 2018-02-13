package exercicio06;

public class Horista extends Diarista {
	
	public Horista() {	}
	
	@Override
	public double calcSalario() {
		return super.calcSalario() / 24.0;
	}
}
