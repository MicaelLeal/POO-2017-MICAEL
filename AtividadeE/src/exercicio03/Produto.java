package exercicio03;

public class Produto {
	private int codigo;
	private String descricao;
	private double valor;
	private int qtd;
	private int qtdMinima;
	
	public Produto(int codigo, String descricao, double valor, int quantidade) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
		this.qtd = quantidade;
		this.qtdMinima = 10;
	}

	public boolean baixar(int quantidade) {
		if (this.qtdMinima > quantidade) {
			this.qtd -= quantidade;
			return true;
		} else
			return false;
	}
	
	public void repor(int quantidade) {
		this.qtd += quantidade;
	}
	
	public void reajusta(double taxa) {
		this.valor *= (1 + taxa/100);
	}
	
	public String toString() {
		return "Codigo do Produto: "+ this.codigo +"\n"
				+"Descricao: "+ this.descricao +"\n"
				+"Valor: "+ this.valor +"\n"
				+"Quantidade: "+ this.qtd +"\n"
				+"Qauntidade minima: "+ this.qtdMinima +"\n";
	}
	
	public boolean equals(Produto produto) {
		if (this.codigo == produto.codigo)
			return true;
		else
			return false;
	}
	
}
