package GeometrischeBerechnung;

import java.util.Scanner;

public class DataRunner extends Rechteck {

	public static void main(String[] args) {
		/* 1-asagidaki hiyarasiye gore class creat ediniz...

	     sekil <--Cember
	     sekil <--Dikdortgen<--Kare

	    2- Turetilen class'a uygun olanlarina yaricap,  uzunluk ve genislik ekleyiniz.
	    3- Runner class'da obj'lerin  alan ve cevre hesaplamasi yaptirip sonuclari yazdiriniz.
	    */
		Kreis kreis = new Kreis();
		Rechteck rechteck = new Rechteck();
		menu();
		
	}

	private static void menu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("=====Was mochten Sie machen======\n1.Kreis\n2.Rechteck\n3.Karree");
		int secim=scan.nextInt();
		
		switch (secim) {
		
		case 1:
			int a=0;
			while(a==0) {
			System.out.println("Lutfen yaricapi giriniz");
			Kreis kreis1 = new Kreis();
			kreis1.setYaricap(scan.nextDouble());
			cember(kreis1.getYaricap());
			System.out.println();
			System.out.println("Tekrar yapmak istiyor musunuz?1/2");
			a=scan.nextInt();
			if(a==1) {
				a=0;
			}else {
				a=1;
				menu();
			}
			}
			case 2:
				int b=0;
				while(b==0) {
				System.out.println("Bitte geben Sie die lange Seite des Rechtecks ​​ein:");
				Rechteck rechteck = new Rechteck();
				rechteck.setUzunKenar(scan.nextDouble());
				System.out.println("Bitte geben Sie ein Kurze Kante: ");
				rechteck.setKisaKenar(scan.nextDouble());
				dikdortgen(rechteck.getKisaKenar(),rechteck.getUzunKenar());
				System.out.println("Willst du es wieder tun?1/2");
				b=scan.nextInt();
				if(b==1) {
					b=0;
				}else {
					b=1;
					menu();
				}
				}
			case 3: 
				b=0;
				while(b==0) {
				System.out.println("Lutfen karenin kenarini giriniz:");
				Rechteck rechteck = new Rechteck();
				rechteck.setKare(scan.nextDouble());
				kare(rechteck.getKare());
				System.out.println("Tekrar yapmak istiyor musunuz?1/2");
				b=scan.nextInt();
				if(b==1) {
					b=0;
				}else {
					b=1;
					menu();
				}
				}
				
			}
	}
		
	private static void kare(double kare) {
		Rechteck kare1 = new Rechteck(kare);
		System.out.println("Karenin alani: "+(kare*kare1.kare));
	}

	private static void dikdortgen(double uzunKenar, double kisaKenar) {
		Rechteck rechteck = new Rechteck(uzunKenar,kisaKenar);
		System.out.println("Dikdortgenin Cevresi: "+(2*rechteck.kisaKenar+2*rechteck.getUzunKenar()));
		System.out.println("Dikdortgenin alani  : "+(rechteck.getKisaKenar()*rechteck.getUzunKenar()));

	}

	private static void cember(double yaricap) {
		Kreis kreis2 = new Kreis(yaricap);
		System.out.println("Cemberin Cevresi: "+(2*kreis2.pi*kreis2.getYaricap()));
		System.out.println("Cemberin Alani: "+(kreis2.pi*kreis2.getYaricap()*kreis2.getYaricap()));
	}

}
