package exercicio05;

public class Hora {
	private int hora;
	private int minuto;
	private int segundo;
	
	public Hora(int hora, int minuto, int segunco) {
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segunco;
	}
	
	public String formatada() {
		return ""+ this.hora +":"+ this.minuto +":"+ this.segundo;
	}

	public int getHora() {
		return hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public int getSegunco() {
		return segundo;
	}	
}
