package exercicio06.questao06a09;

public class Main {
	public static void main(String[] args) {
		Funcionario funcionario1 = new Funcionario(123, 1000);
		Professor funcionario2 = new Professor(123, 10000, "Doutor");
		System.out.println("Funcionario: \n" 
				+"Salario parcela 1: "+ funcionario1.getSalarioPrimeiraParcela() +"\n"
				+"Salario parcela 2: "+ funcionario1.getSalarioSegundaParcela() +"\n"
				+"\nProfossor: \n"
				+"Salario parcela 1: "+ funcionario2.getSalarioPrimeiraParcela() +"\n"
				+"Salario parcela 2: "+ funcionario2.getSalarioSegundaParcela() +"\n");
	}
}
