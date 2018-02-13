package exercicio06.questao01;

public class Diarista extends Empregado {
	
	public Diarista() {	}
	
	@Override
	public double calcSalario() {
		return (super.calcSalario()/30);
	}

}
