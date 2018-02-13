package exercicio04;

public class ParametroArgs {
	private int[] argsOrdenado;
	
	public ParametroArgs(String []args) {
		argsOrdenado = new int[args.length];
		for (int i = 0; i < args.length; i++) {
			argsOrdenado[i] = Integer.parseInt(args[i]);
			System.out.println(args[i]);
		}
	}
	
	public void ordena() {
		int temp;
		for (int i = 0; i < this.argsOrdenado.length -1; i++) {
			for (int j = i+1; j < this.argsOrdenado.length; i++) {
				if (argsOrdenado[i] < argsOrdenado[j]) {
					temp = argsOrdenado[i];
					argsOrdenado[i] = argsOrdenado[j];
					argsOrdenado[j] = temp;
				}
			}
		}
	}
	
}
