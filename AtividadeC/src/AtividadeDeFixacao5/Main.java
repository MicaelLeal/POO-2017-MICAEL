package AtividadeDeFixacao5;

public class Main {
	public static void main(String[] args){
		Casa casa1 = new Casa("Preta", new Porta("Verde"), new Porta("Verde"));
		
		casa1.pinta("Azul");
		
		System.out.println(casa1.totalDePortas());
		
	}
}
