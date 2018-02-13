
public class TestaCasa {
	public static void main(String[] args){
		
		Casa casa = new Casa();
		casa.cor = "Salmao";
		casa.p1.cor = "Marron";
		casa.p2.cor = "Marron";
		casa.p3.cor = "Marron";
		
		casa.p1.abre();
		casa.p3.abre();
		
		System.out.println(casa.quantasPortasAbertas());
		System.out.println(casa.cor);
	}
}
