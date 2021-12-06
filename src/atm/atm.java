package atm;

import java.util.Scanner;

public class atm {
	static int sifre=1234;
	static String kartNo ="123412341234";
	static String kartNo1 ="1234 1234 1234";
	static int musteriSifre = 0;
	static String musteriKartNo= "";
	static int wahl=0;
	static int bakiye=5000;
	static int yatirma=0;
	static int cekme=0, gonderme=0, sifreYeni=0;
	static String harf="",iban="";

	public static void main(String[] args) {
		/*ATM 
		Kullaniciya giriş için kart numarasi ve şifresini isteyin, eger herhangi birini yanlis girerse tekrar isteyin.
		Kart numarasi aralarda boşluk ile girerse de eger doğruysa kabul edin.
		Kart numarasi ve sifre dogrulanirsa kullanicinin yapabileceği işlemleri ekrana yazdirin,
		Bakiye sorgula, para yatirma, para çekme, para gönderme, sifre değiştirme ve cikis.
		Para çekme ve para gonderme işleminde mevcut bakiyeden buyuk para çekilemez,
		Para gönderme işleminde istenen iban TR ile baslamali ve toplam 26 karakterli olmali, eger değilse menü ekranina geri donsun.
		Sifre değiştirme işleminde mevcut şifreyi teyit ettikten sonra, sifre değişiklik işlemini yapmali,*/

		
		
		Scanner scan=new Scanner(System.in);
		KartNoKontrol(scan);
		sifreKontrol(scan, false);
		System.out.println("Sizi Musteri menusune yonlendiriyorum...");
		musteriMenu(scan);
	}

	private static void musteriMenu(Scanner scan) {
		System.out.println("1.Bakiye sorgula\n2.para yatirma\n3.para çekme\n4.para gönderme\n5.Sifre Degistirme\n6.Cikis");
		wahl=scan.nextInt();
		switch (wahl) {
		case 1:
			System.out.println("Bakiyeniz: "+bakiye);
			System.out.println();
			
			baskaIslem(scan);
			
		case 2:	
			System.out.println("Ne kadar para yatirmak istiyorsunuz: ");
			yatirma=scan.nextInt();
			bakiye+=yatirma;
			System.out.println("Yeni Bakiyeniz: "+bakiye);
			System.out.println();
			
			baskaIslem(scan);
			break;
			
		case 3:
			System.out.println("Ne kadar para cekmek istiyorsunuz: ");
			cekme=scan.nextInt();
			if (cekme>bakiye) {
				System.out.println("Hesabinizda "+cekme+" tl bulunmamaktadir.");
				musteriMenu(scan);
			}else {
				bakiye-=cekme;
				System.out.println("Yeni Bakiyeniz: "+bakiye);
				System.out.println();
			}
			baskaIslem(scan);
			break;
			
		case 4:
			System.out.println("Ne kadar para gondermek istiyorsunuz: ");
			gonderme=scan.nextInt();
			if (gonderme>bakiye) {
				System.out.println("Hesabinizda yeterli miktar bulunmamaktadir.");
				musteriMenu(scan);
			}else {
				System.out.println("Lutfen IBANI basinda TR yazarak toplam 26 krakter olarak yazin.");
				iban=scan.next();
				if(iban.length()==26&&iban.substring(0, 2).toUpperCase().contains("TR")) {
					bakiye-=gonderme;
					System.out.println("Paraniz gonderilmistir.");
					System.out.println("Yeni Bakiyeniz: "+bakiye);
				}else {
					System.out.println("Lutfen IBANI basinda TR yazarak toplam 26 krakter olarak tekrar yazin. ");
					iban=scan.next();
				}
			}
			
			baskaIslem(scan);
			break;
			
		case 5:
			//sifreKontrol(scan,false);
			
			sifreOlusturma(sifre,scan,musteriSifre);
			
			baskaIslem(scan);
			break;}
	}

	private static void sifreOlusturma(int sifre, Scanner scan, int musteriSifre) {
		System.out.println("Lutfen sifrenizi dogrulayiniz...");
		int yeniSifre = scan.nextInt();
		if (sifre == yeniSifre) {
			System.out.println("Sifreniz dogrulandi\nLutfen yeni sifrenizi giriniz...");
			sifre = scan.nextInt();
		}else {
			System.out.println("Sifreniz eslesmedi !");
			System.out.println("*****************************************");
		}
		
	}

	private static void baskaIslem(Scanner scan) {
		System.out.println("Baska bir islem yapmak istiyor musunuz: E yada H: ");
		harf=scan.next();
		if(harf.toUpperCase().charAt(0)=='E') {
			musteriMenu(scan);	
		}else if (harf.toUpperCase().charAt(0)=='H') {
			System.exit(0);
		}else {
			System.out.println("yanlis bir giris yaptiniz. ");
			musteriMenu(scan);	
		}
		
	}

	@SuppressWarnings("unused")
	private static boolean KartNoKontrol(Scanner scan) {
		boolean donut=false;
		System.out.println("Lutfen Kart numaranizi giriniz");
		musteriKartNo=scan.next();
		//int kartNo2=Integer.valueOf(kartNo);
		//int kartNo3=Integer.valueOf(kartNo1);
		if (!(kartNo.equals(musteriKartNo))) {
			System.out.println("yanlis giris yaptiniz. ");
			KartNoKontrol(scan);
		}else  { 
			donut=true;
		}
		return donut;
	}

	public static boolean sifreKontrol(Scanner scan, boolean donut) {
		//donut=false;
		int a=0;
		while(a<3) {
		System.out.println("Lutfen sifrenizi giriniz:");
		musteriSifre = scan.nextInt();
		
		if (sifre!=musteriSifre) {
		System.out.println("Yanlis giris yaptiniz.");
			a++;
		//sifreKontrol(scan,sifre,musteriSifre);
			}else if(sifre==musteriSifre) {
				donut=true;
				return donut;
		}
		if(a>=3) {
			System.out.println("Sifrenizi 3 kere yanlis girdiniz. kartiniz bloke edilmistir.");
			System.out.println("Lutfen bankaniza basvurunuz.");
			System.out.println("Iyi gunler dileriz...");
			System.exit(0);
			}
		}
		return donut;
	}
}
