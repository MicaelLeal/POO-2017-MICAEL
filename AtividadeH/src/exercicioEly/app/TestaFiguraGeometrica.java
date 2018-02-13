package exercicioEly.app;

import exercicioEly.model.figurasGeometricas.*;

public class TestaFiguraGeometrica {
	public static void main(String[] args) {
		Comparavel quadrado = new Quadrado(4);
		FiguraGeometrica trianglo = new Triangulo(4, 4, 4);
		Circulo circulo = new Circulo(2);
		FiguraGeometrica retangulo = new Retangulo(3, 4);
		
		System.out.println((quadrado.comparar(trianglo) == 0) ? "Areas iguais!" : "Areas diferentes");
		System.out.println("Area do circulo: "+ circulo.calculaArea());
		System.out.println("Perimetro retangulo:"+ retangulo.calculaPerimetro());
		
	}
}
