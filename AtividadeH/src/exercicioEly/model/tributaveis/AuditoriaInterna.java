package exercicioEly.model.tributaveis;

public class AuditoriaInterna {
	private Tributavel lista[];
	private int pos;
	
	public AuditoriaInterna(int tamanho) {
		this.lista = new Tributavel[tamanho];
		pos = 0;
	}
	
	public boolean adicionar(Tributavel tributavel) {
		if (this.pos < this.lista.length) {
			this.lista[pos++] = tributavel;
			return true;
		}
		return false;
	}
	
	public double calcularTributos() {
		double total = 0;
		for (int i = 0; i < this.pos; i++)
			total += this.lista[i].calcularTributos();
		return total;
	}

}
