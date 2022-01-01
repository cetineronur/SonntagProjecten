package schuleVerwaltung;

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
			System.exit(0);
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
		boolean dongu2=true;
		giris=scan.nextInt();
		
		while(dongu2) {
		for (int i = 0; i <schulerList.size(); i++) {
			if(i==giris-1) {
		
		schulerList.get(giris-1).schulerListeleme();
		dongu2=false;
		System.out.println("Andere Suchen Sie :1/2");
		giris=scan.nextInt();
		if (giris==1) {
			schulerArama();
		}else {
			schulerIslemler();
		}

		}
	}if(giris-1>=schulerList.size()) {
		System.out.println("Boyle bir kayit yok.");
		schulerArama();
	}
		}
		
	}
		public void schulerListeleme() {
		if (schulerList.size()>0) {
			for (int i = 0; i < schulerList.size(); i++) {
				schulerList.get(i).schulerListeleme();
				}
		}else {
			System.out.println("Ogrenci Listesi bostur.");
		}
			
		}

		public void schulerEkle() {

			int secim=0;
			while(dongu) {
				System.out.println("Id Nummer: ");
				schulerIdNummer=scan.nextInt();
				
				scan.nextLine();// dummy 
				System.out.println("Vor-Nachname: ");
				schulerName=scan.nextLine();
				
		
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
				for (int i = 0; i <schulerList.size(); i++) {
					if(i==giris-1) {
						schulerList.remove(giris-1);
						System.out.println("baska silmek istiyor musunuz:1/2");
						giris=scan.nextInt();
						if (giris==1) {
							dongu1=true;
						}else {
							dongu1=false;
						}
					}
					
				}
					System.out.println("boyle bir kayit yok.");
					dongu=true;		
			}

		}
}
