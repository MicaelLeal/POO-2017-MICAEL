package ExercicioCap6.exercicioPonto8;

public class Data {
	private int dia, mes, ano;
	
	Data(int dia, int mes, int ano){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	String formatada(){
		return dia+"/"+mes+"/"+ano;
	}

}
