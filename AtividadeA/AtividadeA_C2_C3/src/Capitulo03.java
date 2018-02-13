import java.util.Scanner;

public class Capitulo03 {
	
	public static void main(String[] args){
		// Atividade 3.3
		
		// Quest 01.	
		int gastosJaneiro = 1500;
		int gastosFevereiro = 2300;
		int gastosMarco = 1700;
		
		int gastoTrimestral = gastosJaneiro + gastosFevereiro + gastosMarco;
		
		System.out.println("Atividade 3.3");
		System.out.println("Questao 01.");
		System.out.println("Gastos do trimestre: " + gastoTrimestral);
		
		// Quest 02.
		double mediaMensal = gastoTrimestral / 3;
		
		System.out.println("Questao 02.");
		System.out.println("Valor da media mensal = "+ mediaMensal);
		
		// Atividade 3.13
		System.out.println("\nAtividade 3.13");
		
		// Quest 01.
		System.out.println("Questao 01.\nNumeros de 150 a 300.");
		for (int i=150; i <= 300; i++){
			System.out.println(i);
		}
		
		// Quest 02.
		System.out.println("\nQuestao 02.\nSoma de 1 a 1000.");
		int soma = 0;
		for (int i=1; i <= 1000; i++){
			soma += i;
		}System.out.println(soma);
		
		// Quest 03.
		System.out.println("\nQuestao 03.\nMultiplos de 3, entre 1 e 100.");
		for (int i = 1; i < 101; i++){
			if (i%3 == 0){
				System.out.print(i+" ");
			}
		}
		
		//Quest 04 e 05.
		System.out.println("\nQuestao 04 e 05.\nFatoriais.");
		long fatorial = 1;
		for (int i = 1; i <= 30; i++){
			fatorial *= i;
			System.out.println(i+"! = " + fatorial);
		}
		
		// Quest 06 e Desafios 3.14.
		System.out.println("\nQuestao 06.\nFibonacci.");
		int f1 = 0;
		int f2 = 1;
		
		while (f1 < 100){
			System.out.println(f1);			
			f2 += f1;
			f1 = f2 - f1;
		}

		// Quest 07.
		System.out.println("\nQuestao 07.");
		
		Scanner entrada = new Scanner(System.in);
		System.out.print("Digite o valor de X. ");
		int x = entrada.nextInt();
		
		while (x != 1){
			if (x%2 == 0){
				x /= 2;
			}else{
				x = 3 *x + 1;
			}
			System.out.print("->"+x);
		}System.out.println();
		
		// Quest 08.
		System.out.println("\nQuestao 08.");
		for (int i = 1; i <= 5; i++){
			for (int j = 1; j <= i; j++){
				if (j == i){
					System.out.println(i*j);
				}else{
					System.out.print(i*j+" ");
				}
			}
		}
		
		// E FIM.
	}
}
