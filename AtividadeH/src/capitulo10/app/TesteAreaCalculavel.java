package capitulo10.app;

import capitulo10.model.questao01.*;

public class TesteAreaCalculavel {
	public static void main(String[] args) {
		AreaCalculavel objeto1 = new Retangulo(3, 2);
		AreaCalculavel objeto2 = new Quadrado(4);
		AreaCalculavel objeto3 = new Circulo(3);
		
		System.out.println("Area do objeto1: "+ objeto1.calculaArea());
		System.out.println("Area do objeto2: "+ objeto2.calculaArea());
		System.out.printf("Area do objeto3: %.1f", objeto3.calculaArea());
	}
}
