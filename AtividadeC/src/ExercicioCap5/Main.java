package ExercicioCap5;


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
		
		Funcionario f2 = new Funcionario("Hugo", "1234134");
		f2.setSalario(100);
		f2.recebeAumento(50);
		Data data2 = new Data();
		f2.dataDeEntrada = data2;
		f2.dataDeEntrada.dia = 24;
		f2.dataDeEntrada.mes = 5;
		f2.dataDeEntrada.ano = 17;

		
		Empresa empresaX = new Empresa("MagnuSoft", "JFJS4J5H");
		
		empresaX.adiciona(f1);
		empresaX.adiciona(f2);
		
		System.out.println(empresaX.mostraEmpregados());
		
		

	}
}