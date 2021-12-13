package SchuleVerwaltung;

public class SchulVerwaltungRunner extends Islemler{

	public static void main(String[] args) {
		
		anaMenu();

}

	public static void anaMenu() {
		
		Islemler islem = new Islemler();
		Schuler islem1=new Schuler();
		Lehrer islem2=new Lehrer();
		String secim=""; 
		System.out.println("===================================\nSCHULERIN UND LEHREREN VERWALTUNG\n===================================\n1-Lehrer Transaktionen\n2-Studenten Transaktionen\nQ-Exit" );
	
		while(!secim.equalsIgnoreCase("q")) {
			secim=islem.scan.next().toUpperCase();
			switch(secim) {
			case "1":
				islem2.lehrerIslemler();
				break;
			case "2":
				islem1.schulerIslemler();
				break;
			case "Q":
				System.out.println("Gule gule");
				break;
				default:
					System.out.println("Lutfen dogru bir tuslama yapiniz");
					System.out.println();
					anaMenu();
			}
		}
	}
		
	}
