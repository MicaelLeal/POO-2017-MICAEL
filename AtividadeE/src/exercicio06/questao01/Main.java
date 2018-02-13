package exercicio06.questao01;

public class Main {
	public static void main(String[] args) {
		Empregado empregado = new Empregado();
		Diarista diarista = new Diarista();
		Horista horista = new Horista();
		empregado.setSalario(1000);
		diarista.setSalario(1000);
		horista.setSalario(1000);
		
		System.out.println("Empregado: "+ empregado.calcSalario() +"\n"
				+"Diarista: "+ diarista.calcSalario() +"\n"
				+"Horista: "+ horista.calcSalario());
	}
}
