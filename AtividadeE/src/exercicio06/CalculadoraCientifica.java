package exercicio06;
import exercicio05.Calculadora;

public class CalculadoraCientifica extends Calculadora {

	public CalculadoraCientifica(int operando1, int operando2) {
		super(operando1, operando2);
	}
	
	public double exponenciar() {
		double resultado = this.operando1;
		for (int i = 0; i < this.operando2-1; i++) {
			resultado *= this.operando1;
		}
		return resultado;
	}

	public double dividir(boolean arredondar) {
		if (arredondar)
			return (int)super.dividir() + this.operando1%this.operando2;
		return super.dividir();
	}
	
	
	
}
