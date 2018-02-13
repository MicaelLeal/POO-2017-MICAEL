package exercicio06.questao01;

public class Horista extends Diarista {
	
	public Horista() {	}
	
	@Override
	public double calcSalario() {
		return super.calcSalario() / 24.0;
	}
}
