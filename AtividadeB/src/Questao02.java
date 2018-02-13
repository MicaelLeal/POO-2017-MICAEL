
public class Questao02 {
	public static void main(String[] args){
		
		// Primeira imagem.
		int sum = 0;
		int number = 1;
		
		while (number <= 100){
			sum += number;
			number++;
		}
		System.out.println(number);
		
		// segunda imagem.
		sum = 0;
		number = 1;
		
		do {
			sum += number;
			number ++;
		}while(number <= 100000);
		
		System.out.println(number);
	}
}
