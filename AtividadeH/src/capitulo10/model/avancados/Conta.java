package capitulo10.model.avancados;

public interface Conta {
	
	public double getSaldo();
	public void deposita(double valor);
	public void saca(double valor);
	public void atualiza(double taxaSelic);

}
