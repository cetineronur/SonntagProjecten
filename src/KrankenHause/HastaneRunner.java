package KrankenHause;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class HastaneRunner extends VeriBankasi{

	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		String hastaDurumu;
		String unvan;
		menu1();
		
	}
	private static void menu1() {
		
		System.out.println("--------------HASTANE OTOMASYON SISTEMI---------------\n1.Poliklinik Hizmetleri\n2.Yatan Hasta Islemleri");
		int secim=scan.nextInt();
		if (secim==1) {
			menu2();
		}else if (secim==2){
			menu3();
		}else {
			System.out.println("Yanlis bir tuslama yaptiniz");
			menu1();
		}
		
	}
	private static void menu3() {
		System.out.println("-----------YATAN HASTA ISLEMLERI---------------\nLutfen Id'nizi giriniz:");
		int secim=scan.nextInt();
		boolean dongu2=true;
		while(dongu2) {
			for (int i = 0; i < hastaIDleri.size(); i++) {
				if (secim==hastaIDleri.get(i)) {
					System.out.println("Hasta ID         : "+hastaIDleri.get(i)+"\nHasta Adi       : "+hastaIsimleri.get(i)+"\nHasta Soyadi      :  "+hastaSoyIsimleri.get(i)+"\nYattigi Service : "+durumlar.get(i));
				dongu2=false;
				}
			}
		}
		
	}
	private static void menu2() {
		Hasta hasta = new Hasta();
		Durum durum = new Durum();
		VeriBankasi banka = new VeriBankasi();
		
		System.out.println("1. "+ banka.durumlar.get(0)+"\n"+"2. "+ banka.durumlar.get(1)+"\n"+"3. "+banka.durumlar.get(2)+"\n"+"4. "+banka.durumlar.get(3)+"\n"+"5. "+banka.durumlar.get(4)+"\n"+"6. "+ banka.durumlar.get(5)) ;
		durum.setAktuelDurum(scan.nextInt());
		doktorUnvan(durum.getAktuelDurum());
		
	}
	public static void doktorUnvan(int aktuelDurum) {
		Hastane hastane1 = new Hastane();
		VeriBankasi banka = new VeriBankasi(doctorIsimleri);
		
		if		 (aktuelDurum==1) {
			System.out.println("gitmeniz gereken brans: "+unvanlar.get(aktuelDurum-1));
			doktorBul(unvanlar.get(aktuelDurum-1));
		}else if (aktuelDurum==2) {
			System.out.println("gitmeniz gereken brans: "+unvanlar.get(aktuelDurum-1));
			doktorBul(unvanlar.get(aktuelDurum-1));
		}else if (aktuelDurum==3) {
			System.out.println("gitmeniz gereken brans: "+unvanlar.get(aktuelDurum-1));
			doktorBul(unvanlar.get(aktuelDurum-1));
		}else if (aktuelDurum==4) {
			System.out.println("gitmeniz gereken brans: "+unvanlar.get(aktuelDurum-1));
			doktorBul(unvanlar.get(aktuelDurum-1));
		}else if (aktuelDurum==5) {
			System.out.println("gitmeniz gereken brans : "+unvanlar.get(aktuelDurum-1));
			doktorBul(unvanlar.get(aktuelDurum-1));
		}else if (aktuelDurum==6) {
			System.out.println("gitmeniz gereken brans : "+unvanlar.get(aktuelDurum-1));
			doktorBul(unvanlar.get(aktuelDurum-1));
		}else {
			System.out.println("yanlis tuslama yaptiniz");
			menu2();
		}
	}
	public static  String doktorBul(String unvan){
		
		boolean dongu=true;
		while(dongu) {
		for (int i = 0; i < unvanlar.size(); i++) {
			if (unvanlar.get(i).equalsIgnoreCase(unvan)) {
			System.out.println("Gitmeniz gereken doktor: "+" "+doctorIsimleri.get(i)+" "+doctorSoyIsimleri.get(i));
			dongu=false;
			}
		}
	}System.out.println("\n"+"randevu almak ister misiniz?1/2");
	int secim=scan.nextInt();
	if (secim==1) {
		doktorRandevu(unvan);
	}else {
		menu2();
		}
	return unvan;
	}
	
	private static void doktorRandevu(String unvan) {
		System.out.println("Randevu saatlerinden birini seciniz:"+"  "+randevu.get(0)+"  "+randevu.get(1)+"  "+randevu.get(2)+" "+randevu.get(3)+"  "+randevu.get(4));
		String secim=scan.next();
		boolean dongu1=true;
		while(dongu1) {
		for (int i = 0; i < randevu.size(); i++) {
			if (secim.equalsIgnoreCase(randevu.get(i))) {
				System.out.println("randevunuz "+unvan+" bransi icin saat "+randevu.get(i)+" olarak kayit edilmistir.");
				VeriBankasi banka = new VeriBankasi(unvan,randevu.get(i));
				randevuKayit.add(banka);
				
				System.out.println("------------------Randevu Bilgileri-----------------");
				randevuKayit.get(i).listeleRandevu(unvan, randevu.get(i));
				randevu.remove(i);
				menu1();
				dongu1=false;
				break;
			 }else if (!secim.equalsIgnoreCase(randevu.get(i))){
				 continue;
			 }
		}
			 System.out.println("Lutfen randevu saatini dogru yaziniz");
			 doktorRandevu(unvan);
	   }
		
	}

	
	/*
	public static Durum hastaDurumuBul(String aktuelDurum) {
		Durum hastaDurumu= new Durum();
		
		if (aktuelDurum==durumlar[0]) {
			hastaDurumu.setAciliyet(false);
		}else if (aktuelDurum==durumlar[1]) {
			hastaDurumu.setAciliyet(false);
		}else if (aktuelDurum==durumlar[2]) {
			hastaDurumu.setAciliyet(false);
		}else if (aktuelDurum==durumlar[3]) {
			hastaDurumu.setAciliyet(false);
		}else if (aktuelDurum==durumlar[4]) {
			hastaDurumu.setAciliyet(true);
		}else if (aktuelDurum==durumlar[5]) {
			hastaDurumu.setAciliyet(true);
		}else {
			System.out.println("Gecerli bir durum degil");
		}
		return hastaDurumu;
		
	}
	
	public static Hasta hastaBul(String aktuelDurum) {
		Hasta hasta = new Hasta();
		hasta.
	}
	
	Loop kullaninizve aktuelDurumukiyaslayinizData classindan
	Hasta bilgilerinikullaninizve tum Hasta Objesindekibilgileriset ediniz
	Ve sonra hastaDurumuBulmethod unucagirinizve Durum Objesiniset ediniz
	Son olarak return hasta;*/
	

}
