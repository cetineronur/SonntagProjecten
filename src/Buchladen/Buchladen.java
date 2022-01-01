package buchladen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Buchladen {

	static int wahl2 = 0;
	Scanner scan = new Scanner(System.in);
	// String buchTitel ="";

	public static void main(String[] args) {
		/*
		 * ====================PAZAR PROJEMIZ============================== bir kitapci
		 * icin program yazalim kitap no 1000'den baslayacak sirali no olsun program
		 * baslayinca menu isminde bir method calissin 1-kitap ekle 2-numara ile kitap
		 * goruntule 3-bilgi ile kitap goruntule 4-numara ile kitap sil 5-tum kitaplari
		 * listele 6-cikis
		 ************************************
		 * 1.olarak her kitaba ait kitap no olacak, sonra kitap adi olacak, buna ait
		 * yazar adi olacak ve kitap fiyati olacak bu bilgilerin tutulacagi bir yer
		 * olmali yani bir list'te tutmamiz gerek 2-kitap numarasi 1000'den
		 * baslamali,her kitap eklendiginde bir artacagi icin sayac gibi dusunulebilinir
		 * count=1000; menu isminde bir method olusturmaliyim, 3-kitap ekle diye bir
		 * method olusturmliyim,bu method farkli bir classda 4-kullanicidn kitap adi
		 * yazar adi ve fiyat bilgileri istenmeli
		 */

		Buch buch = new Buch();
		menu();

	}

	public static void menu() {
		Scanner scan = new Scanner(System.in);
		System.out.println(
				"1.Kitap Ekle\n2.Numara ile goruntule\n3.Bilgi ile kitap goruntule\n4.Numara ile Kitap sil\n5.Tum Kitaplari Listele\n6.Cikis");
		wahl2 = scan.nextInt();
		switch (wahl2) {

		case 1:
			Buch.buchFugen();
			break;
		case 2:
			mitNummerBuchZeigt();
			break;
		case 3:
			mitInfoBuchZeigt();
			break;
		case 4:
			mitNummerBuchLosch();
			break;
		case 5:
			alleBucherList();
			break;
		}
	}

	public static void alleBucherList() {
		for (int i = 0; i < Buch.buchTitelList.size(); i++) {
			System.out.println("---------" + (i + 1) + "----------");
			System.out.println("yazarin adi: " + Buch.autorenNameList.get(i));
			System.out.println("Kitabin adi: " + Buch.buchTitelList.get(i));
			System.out.println("Kitabin fiyati: " + Buch.buchPreisList.get(i));
			System.out.println();
		}
		Buchladen.menu();

	}

	public static void mitInfoBuchZeigt() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Hangi bilgi ile kitap goruntulemek istiyorsunuz:\nyazar ismi Y yada kitap adi K ");
		char info = scan.nextLine().toUpperCase().charAt(0);
		if (info == 'Y') {
			System.out.println("Lutfen Yazar adini dogru olarak giriniz:");
			String autorenName = scan.nextLine();
			for (int i = 0; i < Buch.autorenNameList.size(); i++) {
				if (Buch.autorenNameList.get(i).equals(autorenName)) {
					System.out.println("yazarin adi: " + Buch.autorenNameList.get(i));
					System.out.println("Kitabin adi: " + Buch.buchTitelList.get(i));
					System.out.println("Kitabin fiyati: " + Buch.buchPreisList.get(i));
					System.out.println();
					System.out.println("baska bir arama yapmak istiyor musunuz? E/H");
					String secim = scan.next().toUpperCase();
					if (secim.contains("E")) {
						mitInfoBuchZeigt();
					} else if (secim.contains("H")) {
						Buchladen.menu();
					} else {
						System.out.println("Lutfen Evet yada Hayir giriniz");
					}
					break;
				} else if (!Buch.autorenNameList.get(i).equals(autorenName)) {
					System.out.println("Boyle bir yazar ismi bulunamamistir");
					System.out.println();
					mitInfoBuchZeigt();
				}
			}
		} else if (info != 'Y') {
			System.out.println("Lutfen dogru giris yapin");
			System.out.println();
			mitInfoBuchZeigt();
		}
	}

	public static void mitNummerBuchLosch() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Lutfen silmek isediginiz Kitabin Numarasini giriniz:");
		int wahl1 = scan.nextInt();
		for (int i = 0; i < Buch.buchTitelList.size(); i++) {
			if (Buch.buchNummerList.get(i).equals(wahl1)) {
				Buch.buchNummerList.remove(wahl1 - 1000);
				Buch.buchTitelList.remove(wahl1 - 1000);
				Buch.autorenNameList.remove(wahl1 - 1000);
				Buch.buchPreisList.remove(wahl1 - 1000);
				System.out.println();
				System.out.println("Istediginiz yerine getirilmistir.");
				System.out.println("Sizi ana menuye yonlendiriyorum...");
				System.out.println();
				Buchladen.menu();
				break;
			}
			if (!Buch.buchNummerList.get(i).equals(wahl1)) {
				System.out.println("Boyle bir kitap bulunamamistir\nLutfen tekrar konrol edin.");
				System.out.println();
				mitNummerBuchLosch();
			}
		}
	}

	public static void mitNummerBuchZeigt() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Lutfen Kitap Numarasini giriniz:");
		int wahl1 = scan.nextInt();
		// int i=wahl1-1000;
		for (int j = 0; j < Buch.buchNummerList.size(); j++) {

			if (Buch.buchNummerList.get(j).equals(wahl1)) {
				System.out.println("Kitap Ismi: " + Buch.buchTitelList.get(j));
				System.out.println("YAzarin ismi: " + Buch.autorenNameList.get(j));
				System.out.println("Kitabin fiyati: " + Buch.buchPreisList.get(j));
				System.out.println();
				System.out.println("baska bir arama yapmak istiyor musunuz? E/H");
				String secim = scan.next().toUpperCase();
				if (secim.contains("E")) {
					mitNummerBuchZeigt();
				} else if (secim.contains("H")) {
					Buchladen.menu();
				} else {
					System.out.println("Lutfen Evet yada Hayir giriniz");
				}
				break;
			} else if (!Buch.buchNummerList.contains(wahl1)) {
				System.out.println("Boyle bir numara ile kayit bulunamamistir.");
				System.out.println();
				mitNummerBuchZeigt();
			}
		}
	}

}
