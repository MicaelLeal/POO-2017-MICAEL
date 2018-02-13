package ExercicioCap6.exercicioPonto8;
public class Main {
	public static void main(String[] args){
		Empresa empresa = new Empresa(10);
		
		for (int i = 0; i < 10; i++){
			Funcionario f2 = new Funcionario("Micael", "049218312718");
			f2.setSalario(1000 + 10*i);
			f2.dataDeEntrada = new Data(i, i, i);
			empresa.adiciona(f2);
		}
		
		System.out.println(empresa.mostraEmpregados());
		
		Funcionario f2 = new Funcionario("Micael", "0493412351238");
		if (empresa.contem(f2)){
			System.out.println("contem");
		}else{
			System.out.println("nao contem");
		}
		
		
	}
}
