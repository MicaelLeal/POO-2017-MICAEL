package exercicio05;

public class Calculadora {
	protected int operando1;
	protected int operando2;
	
	public Calculadora(int operando1, int operando2) {
		this.operando1 = operando1;
		this.operando2 = operando2;
	}

	public int somar() {
		return this.operando1 + this.operando2;
	}
	
	public int subtrair() {
		return this.operando1 - this.operando2;
	}
	
	public int multiplicar() {
		return this.operando1 * this.operando2;
	}
	
	public double dividir() {
		return this.operando1 / this.operando2;
	}

	public int getOperando1() {
		return operando1;
	}

	public int getOperando2() {
		return operando2;
	}
	
}

	