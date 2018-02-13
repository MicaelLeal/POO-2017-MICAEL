package exercicio04extra;

public class Triangulo {
	private int lado1;
	private int lado2;
	private int lado3;
	
	public Triangulo(int lado1, int lado2, int lado3) {
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado3;
	}
	
	public boolean formaTriangulo() {
		int modulo = lado2 - lado3;
		if (modulo < 0)	{	modulo *= -1;}
		if (modulo < this.lado1 && this.lado1 < (this.lado2 + this.lado3))
			return true;
		return false;
	}
	
	public boolean ehIsoceles() {
		if (this.formaTriangulo())
			if (this.lado1 == this.lado2 || this.lado2 == this.lado3 || this.lado3 == this.lado1)
				return true;
		return false;
	}
	
	public boolean ehEquilatero() {
		if (this.formaTriangulo())
			if (this.lado1 == this.lado2 && this.lado1 == this.lado3)
				return true;
		return false;
	}
	
	public boolean ehEscaleno() {
		if (this.formaTriangulo())
			if (!this.ehIsoceles() & !this.ehEquilatero())
				return true;
		return false;
	}
	
}
