package schuleVerwaltung;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
	BİR OKUL YÖNETİM PLATFORMU KODALYINIZ.

	1.	Bu programda, Öğrenci ve Öğretmen Kayıtları ile ilgili işlemler yapılabilmelidir.
		Kayıtlarda şu bilgiler olabilmelidir.

		Öğretmen: Ad-Soyad,  kimlik No, yaş, bölüm, ve sicil No bilgileri içermelidir.
		Öğrenci: Ad-Soyad,  kimlik No, yaş, numara, sınıf bilgileri içermelidir.

	2.	Program başladığında Kullanıcıya, Öğretmen ve Öğrenci işlemlerini seçebilmesi için
		Aşağıdaki gibi bir menü gösterilsin.

	====================================
	 ÖĞRENCİ VE ÖĞRETMEN YÖNETİM PANELİ
	====================================
	 1- ÖĞRENCİ İŞLEMLERİ
	 2- ÖĞRETMEN İŞLEMLERİ
	 Q- ÇIKIŞ

	3.	Seçilen Kişi türüne göre aşağıdaki işlemleri gösteren bir alt menü daha gösterilsin.

	============= İŞLEMLER =============
		 1-EKLEME
		 2-ARAMA
		 3-LİSTELEME
		 4-SİLME
		 5-ANA MENÜ
		 Q-ÇIKIŞ

	SEÇİMİNİZ:

	4.	İşlemler menüsünde seçilen işleme göre bir önceki menüde seçilen Kişi türü ile ilgili
	    ekleme, kimlik no ile silme ve arama, var olan tüm kişileri listeleme gibi işlemler yapılabilmelidir.
		Bunun yanında bir üst menüye dönme veya çıkış işlemleri de yapılabilmelidir.

 */

public class Islemler {
	
	
	protected String lehrerName;
	
	protected int lehrerIdNummer;
	
	protected int lehrerAlt;
	
	protected String fach;
	
	protected int RegistrationsNummer=99;
	
protected String schulerName;
	
	protected int schulerIdNummer;
	
	protected int schulerAlt;
	
	protected String clas;
	
	protected static int nummer=0;
	
	protected  boolean dongu=true;
	
	static List<Islemler> lehrerList =new ArrayList<>();
	static List<Islemler> schulerList =new ArrayList<>();
	protected Scanner scan= new Scanner(System.in);
	
	

	Islemler(String lehrerName, int lehrerIdNummer, int lehrerAlt, String fach, int registrationsNummer) {
		
		
		this.lehrerName=lehrerName;
		this.lehrerIdNummer=lehrerIdNummer;
		this.lehrerAlt=lehrerAlt;
		this.fach=fach;
		this.RegistrationsNummer=registrationsNummer;
		}
	Islemler( int schulerIdNummer,String schulerName, int schulerAlt, String clas, int nummer) {
		
		this.schulerIdNummer=schulerIdNummer;
		this.schulerName=schulerName;
		this.schulerAlt=schulerAlt;
		this.clas=clas;
		this.nummer=nummer;
		}
	
	
		public Islemler() {
	
		}

	protected void schulerListeleme() {
		System.out.println("\nId Nummer   : "+schulerIdNummer+"\nVor-Nachname:"+schulerName+"\nYas         : "+schulerAlt+"\nSinifi      : "+clas+"\nNumara      : "+nummer);
		System.out.println();
	}

	protected void lehrerListeleme() {
		System.out.println("Vor-Nachname       :"+lehrerName+"\nId Nummer          : "+lehrerIdNummer+"\nYas                : "+lehrerAlt+"\nFach               : "+fach+"\nRegistrationsnummer: "+RegistrationsNummer+"\n");
		System.out.println();
	}
	
	

}
