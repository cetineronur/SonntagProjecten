package Buchladen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Buch {
	static List<Integer> buchNummerList = new ArrayList<>();
	static List<String> buchTitelList = new ArrayList<>();
	static List<String> autorenNameList = new ArrayList<>();
	static List<Integer> buchPreisList = new ArrayList<>();
	static int count = 1000;
	static int i = 0;

	Buch() {
	}

	Buchladen buchladen = new Buchladen();

	public static void buchFugen() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Lutfen eklemek icin Kitap adinizi giriniz: ");
		String buchTitel = scan.nextLine();
		buchTitelList.add(buchTitel);
		System.out.println("Kitabin yazar ismini giriniz: ");
		String autorenName = scan.nextLine();
		autorenNameList.add(autorenName);
		System.out.println("Kitabin Fiyatini giriniz:");
		int buchPreis = scan.nextInt();
		buchPreisList.add(buchPreis);

		buchNummerList.add(i, count);
		count++;
		i++;

		System.out.println("Baska Kitap eklemek istiyor musunuz? E/H");
		String wahl = scan.next().toUpperCase();
		if (wahl.contains("E")) {
			buchFugen();
		} else if (wahl.contains("H")) {
			Buchladen.menu();
		} else {
			System.out.println("Lutfen Evet yada Hayir giriniz");
		}

	}

}
