package SchuleVerwaltung;

public class Schuler extends Islemler {
	
	protected void schulerIslemler() {
	SchulVerwaltungRunner run = new SchulVerwaltungRunner();
	
	String secim="";
	System.out.println("===========PROCESS==========\n1-Ekleme\n2-Arama\n3-Listeleme\n4-Silme\n5-Ana Menu\nQ-Cikis");
	
	
	while(!secim.equalsIgnoreCase("q")) {
		secim=scan.next().toUpperCase();
		switch(secim) {
		case "1":
			schulerEkle();
			schulerIslemler();
			break;
		case "2":
			schulerArama();
			schulerIslemler();
			break;
		case "3":
			schulerListeleme();
			schulerIslemler();
			break;
		case "4":
			schulerSil();
			schulerIslemler();
			break;
		case "5":
			run.anaMenu();
			break;
		case "Q":
			System.out.println("Gule Gule");
			break;
			default:
				System.out.println("yanlis tuslama yaptiniz:");
				schulerIslemler();
		}
	}
	
}

	private void schulerArama() {

		int giris=0;
		System.out.println("Bitte Nummer gibt ein: ");
		giris=scan.nextInt();
		schulerList.get(giris-100).schulerListeleme();
		System.out.println("Andere Suchen Sie :1/2");
		giris=scan.nextInt();
		if (giris==1) {
			schulerArama();
		}else {
			schulerIslemler();
		}

		}

		public void schulerListeleme() {
		for (int i = 0; i < schulerList.size(); i++) {
			schulerList.get(i).schulerListeleme();
			}
		}

		public void schulerEkle() {

			int secim=0;
			while(dongu) {
				System.out.println("Vor-Nachname: ");
				schulerName=scan.next();

				System.out.println("Id Nummer: ");
				schulerIdNummer=scan.nextInt();

				System.out.println("wie alt : ");
				schulerAlt=scan.nextInt();

				System.out.println("welche klasse : ");
				clas=scan.next();

				nummer++;

				Islemler schuler = new Islemler(schulerIdNummer,schulerName,schulerAlt,clas,nummer);
				schulerList.add(schuler);

				System.out.println("Baska kayit girmek istiyor musunuz? 1/2");
				secim=scan.nextInt();
				if (secim==1) {
					schulerEkle();
				}else if (secim==2) {
					dongu=false;
				}
			}
		}
			public void schulerSil() {
				boolean dongu1=true;
				int giris=0;
				while(dongu1) {
				System.out.println("Bitte Nummer gibt ein: ");
				giris=scan.nextInt();
				schulerList.remove(giris-100);
				System.out.println("baska silmek istiyor musunuz:1/2");
				giris=scan.nextInt();
				if (giris==1) {
					dongu1=true;
				}else {
					dongu1=false;
				}
			}

		}
}
