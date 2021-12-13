package EmlakProjesi;

import java.util.ArrayList;
import java.util.List;

public class Patron extends KalipHane {
	private int patronId=1;
	private int patronPassword=1;
	boolean giris=true;
	
	protected void patron() {
		
		
		System.out.println("Patron Hosgeldin\n1.Emlak Listesi\n2.Emlak ekleme\n3.Emlak Silme\n4.Cikis");
		int secim=scan.nextInt();
		switch (secim) {
		case 1:
			listeleme();
			patron();
			break;
		case 2:
			ekleme();
			patron();
			break;
		case 3: 
			silme();
			patron();
			break;
		case 4:
			System.out.println("Gule gule");
			break;
			default:
				System.out.println("Y<nlis bir giris yaptiniz:\n------------");
				patron();
		}	
	}
	private void silme() {
		System.out.println("hangi Liste numarasini silmek istiyorsunuz:");
		int a=scan.nextInt();
		list.remove(a-100);
		
	}
	public void ekleme() {
		boolean dongu=true;

		while(dongu) {

		ilanNo++;
		
		System.out.println("Evin metrekaresini giriniz:");	
		metre=scan.nextInt();
		
		System.out.println("Evin oda sayisini giriniz:");	
		odaSayisi=scan.nextInt();
		
		System.out.println("Evin bulundugu kati giriniz:");	
		bulunduguKat=scan.nextInt();
		
		System.out.println("Evin fiyatini giriniz:");	
		setFiyat(scan.nextInt());
		KalipHane kalip2 = new KalipHane(ilanNo,metre,odaSayisi,bulunduguKat,getFiyat());

		list.add(kalip2);
	
		System.out.println("Baska veri girmek istiyor musunuz?1/2");
		int secim=scan.nextInt();
		if (secim==1) {
			dongu=true;
		}else if(secim==2) {
			dongu=false;
		}else {
			System.out.println("yanlis giris yaptiniz");
		}
		}
		
	}
	protected void listeleme() {
		System.out.println("***************");
		for (int i = 0; i < list.size(); i++) {
			list.get(i).ListeleEmlak();
			
		}
		
	}
	

	public int getPatronId() {
		return patronId;
	}

	public int getPatronPassword() {
		return patronPassword;
	}
	public void setPatronId(int patronId) {
		this.patronId = patronId;
	}
	public void setPatronPassword(int patronPassword) {
		this.patronPassword = patronPassword;
	}
	
	public boolean isGiris() {
		return giris;
	}
	public void setGiris(boolean giris) {
		this.giris = giris;
	}

	
	
}
