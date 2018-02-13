import java.util.Scanner;

public class Main {
	public static void main(String[] args){

		Funcionario f1 = new Funcionario("Hugo", "1234134");
		f1.setSalario(100);
		f1.recebeAumento(50);
		Data data = new Data();
		f1.dataDeEntrada = data;
		f1.dataDeEntrada.dia = 24;
		f1.dataDeEntrada.mes = 5;
		f1.dataDeEntrada.ano = 17;
		f1.mostra();
		
		Funcionario f2 = new Funcionario("Hugo", "1234134");
		f2.setSalario(100);
		f2.recebeAumento(50);
		Data data2 = new Data();
		f2.dataDeEntrada = data2;
		f2.dataDeEntrada.dia = 24;
		f2.dataDeEntrada.mes = 5;
		f2.dataDeEntrada.ano = 17;
		f2.mostra();
		
		System.out.println("\nTeste questao 04.");
		if (f1 == f2){
			System.out.println("iguai");
		}else{
			System.out.println("diferentes");
		}
		
		Funcionario f3 = f1;
		System.out.println("\nTeste questao 05.");
		if (f1 == f3){
			System.out.println("Iguais");
		}else{
			System.out.println("Diferentes");
		}
		
		// DESAFIOS
		Fibonacci fibonacci = new Fibonacci();
		Scanner entrada = new Scanner(System.in);
		System.out.print("Valor de n: ");
		int n = entrada.nextInt();
		for (int i = 1; i <= n; i++){
			System.out.println(fibonacci.calculaFibonacci(i));
		}
		
		//FIM.
	}
}
