package exercicio05;
import exercicio04.Banco;
import exercicio04.Conta;
import java.util.Scanner;

public class ExecutaBanco {
	public static Scanner scanner;
	
	public static void main(String[] args) {
		Banco banco = new Banco(10);
		scanner = new Scanner(System.in);
		String opcao = "";
		
		do {
			System.out.println("\n1-Cadastrar \n"
					+ "2-Alterar \n"
					+ "3-Excluir \n"
					+ "4-Consultar \n"
					+ "5-Creditar \n"
					+ "6-Debitar \n"
					+ "7-Transferir \n"
					+ "9-Sair \n >>> ");
			opcao = scanner.next();
			
			switch (opcao) {
			case "1" :
				System.out.println("\nDigite o número: ");
				String numero = scanner.next();
				
				System.out.println("Digite o saldo inicial: ");
				double saldo = scanner.nextDouble();
				
				System.out.println(banco.inserir(new Conta(numero, saldo)) ? "Cadastro efetuado." : "Erro no cadastro.");
				break;
				
			case "2" : 
				System.out.println("\nDigite o número da conta a ser atualizada: ");
				numero = scanner.next();
				
				System.out.println("Digite novo saldo: ");
				saldo = scanner.nextDouble();
				
				System.out.println(banco.alterar(new Conta(numero, saldo)) ? "Conta atualizada." : "Conta nao encontrada.");
				break;
				
			case "3" :
				System.out.println("\nNumero da conta: ");
				numero = scanner.next();
				
				banco.excluir(numero);
				System.out.println("Conta excluida.");
				break;
				
			case "4" :
				System.out.println("\nNumero da conta a ser consultada: ");
				numero = scanner.next();
				
				Conta conta = banco.consultar(numero);
				if (conta != null)
					System.out.println("Saldo da respectiva conta - "+ conta.getSaldo());
				else
					System.out.println("Conta inezistente");
				break;
				
			case "5" :
				System.out.println("\nNumero da conta: ");
				numero = scanner.next();
				
				System.out.println("Valor a ser depositado: ");				
				System.out.println(banco.creditar(numero, scanner.nextDouble()) ? "Deosito efetuado." : "Conta inesistente.");
				break;
				
			case "6" :
				System.out.println("\nNumero da conta: ");
				numero = scanner.next();
				
				System.out.println("Valor a ser sacado: ");
				System.out.println(banco.debitar(numero, scanner.nextDouble()) ? "Saque efetuado." : "Falha ao sacar");
				break;
				
			case "7" :
				System.out.println("\nNumero da conta debitante: ");
				numero = scanner.next();
				System.out.println("Numero da conta destino: ");
				String numero2 = scanner.next();
				
				System.out.println("Valor a ser tranferido: ");
				System.out.println(banco.tranferir(numero, numero2, scanner.nextDouble()) ? "Transferencia efetuada" : "Erro ao tranferir");
				
			}
		} while (!opcao.equals("9"));
	}
}