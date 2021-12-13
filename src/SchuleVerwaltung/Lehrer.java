package SchuleVerwaltung;

import java.util.Iterator;

@SuppressWarnings("unused")
public class Lehrer extends Islemler{

@SuppressWarnings("static-access")
protected void lehrerIslemler() {
		
		SchulVerwaltungRunner run = new SchulVerwaltungRunner();
		
		String secim="";
		System.out.println("===========PROCESS==========\n1-Ekleme\n2-Arama\n3-Listeleme\n4-Silme\n5-Ana Menu\nQ-Cikis");
		
		
		while(!secim.equalsIgnoreCase("q")) {
			secim=scan.next().toUpperCase();
			switch(secim) {
			case "1":
				lehrerEkle();
				lehrerIslemler();
				break;
			case "2":
				lehrerArama();
				lehrerIslemler();
				break;
			case "3":
				LehrerListeleme();
				lehrerIslemler();
				break;
			case "4":
				lehrerSil();
				lehrerIslemler();
				break;
			case "5":
				run.anaMenu();
				break;
			case "Q":
				System.out.println("Gule Gule");
				break;
				default:
					System.out.println("yanlis tuslama yaptiniz:");
					lehrerIslemler();
			}
		}
		
	}

private void lehrerArama() {
	
	int giris=0;
	System.out.println("Bitte RegistrationsNummer gibt ein: ");
	giris=scan.nextInt();
	lehrerList.get(giris-100).lehrerListeleme();
	System.out.println("Andere Suchen Sie :1/2");
	giris=scan.nextInt();
	if (giris==1) {
		lehrerArama();
	}else {
		lehrerIslemler();
	}
	
}

private void LehrerListeleme() {
	for (int i = 0; i < lehrerList.size(); i++) {
		lehrerList.get(i).lehrerListeleme();
	}
}

public void lehrerEkle() {
	
	int secim=0;
	while(dongu) {
	System.out.println("Vor-Nachname: ");
	String lehrerName=scan.next();
	
	System.out.println("Fach: ");
	String fach=scan.next();
	
	System.out.println("Id Nummer: ");
	lehrerIdNummer=scan.nextInt();
	
	System.out.println("Yas: ");
	lehrerAlt=scan.nextInt();
	
	RegistrationsNummer++;
	
	Islemler lehrer = new Islemler(lehrerName,lehrerIdNummer,lehrerAlt,fach,RegistrationsNummer);
	lehrerList.add(lehrer);
	
	System.out.println("Baska kayit girmek istiyor musunuz? 1/2");
	secim=scan.nextInt();
	if (secim==1) {
		lehrerEkle();
	}else if (secim==2) {
		dongu=false;
	}
	}

}
public void lehrerSil() {
	boolean dongu1=true;
	int giris=0;
	while(dongu1) {
		System.out.println("Bitte RegistrationsNummer gibt ein: ");
		giris=scan.nextInt();
		lehrerList.remove(giris-100);
		System.out.println("baska silmek istiyor musunuz:1/2");
		giris=scan.nextInt();
		if (giris==1) {
			dongu1=true;
		}else {
			dongu1=false;
		}
	}scan.close();
	
}


}

