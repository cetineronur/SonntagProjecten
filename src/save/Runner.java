package save;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Runner extends Data {

	public static void main(String[] args) {

		menu();

	}

	private static void menu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("======Lutfen seciminizi yapiniz=======\n1-Anmelden\n2-Information\n3-Remove Data");
		int secim = 0;
		if (scan.hasNextInt()) {
			secim = scan.nextInt();
			switch (secim) {

			case 1:
				getSave();
				break;
			case 2:
				getInfo();
				break;
			case 3:
				removeInfo();
				break;
			default:
				System.out.println("you made a wrong entry:");
				System.out.println();
				menu();
				break;
			}
		} else {

			System.out.println("You made a wrong entry. please enter integer nummer");
			System.out.println();
			menu();
		}

	}

	private static void getSave() {
		id();
		name();
		adres();
		tel();

		Data data = new Data();
		Data data1 = new Data(id, telNummer, adres, name);
		map.put(id, telNummer + ", " + adres + ", " + name);
		System.out.println(map);
		selectOption();

	}

	private static void selectOption() {
		System.out.println("Tekrar kayit eklemek istiyor musunuz?1/2");
		Scanner scan = new Scanner(System.in);
		int kayit = scan.nextInt();
		if (kayit == 1) {
			getSave();
		} else {
			System.out.println();
			menu();
		}

	}

	private static void tel() {
		Data data = new Data();
		Scanner scan = new Scanner(System.in);

		int tel = 0;
		System.out.println("Please enter Tel number: ");

		if (scan.hasNextInt()) {
			tel = scan.nextInt();
			if (tel < 1000000 || tel > 9999999) {
				System.out.println("please enter four digit");
				tel();
			} else {
				data.telNummer = tel;
			}
		} else if (!scan.hasNextInt()) {
			System.out.println("please enter integer nummer");
			tel();
		}

	}

	private static void adres() {
		Data data = new Data();
		Scanner scan = new Scanner(System.in);

		String adres = null;
		System.out.println("Please enter your Adresse: ");
		adres = scan.nextLine();
		if (adres.length() < 10) {
			System.out.println("please enter ten krakter ");
			adres();
		} else {
			data.adres = adres;
		}

	}

	private static void name() {
		Data data = new Data();
		Scanner scan = new Scanner(System.in);

		String name = null;
		System.out.println("Please enter your Name: ");
		name = scan.next();
		if (name.matches("[a-zA-Z]+")) {
			data.name = name;
		} else {
			System.out.println("Please enter string data");
			name();
		}

	}

	private static void id() {
		Data data = new Data();
		Scanner scan = new Scanner(System.in);

		int tc = 0;
		System.out.println("Please enter Tc number: ");

		if (scan.hasNextInt()) {
			tc = scan.nextInt();
			if (tc < 1000 || tc > 9999) {
				System.out.println("please enter four digit");
				System.out.println();
				id();
			}
			if (map.keySet().contains(tc)) {
				System.out.println("Diese tc nummer ist registriert. Please enter another tc nummer ");
				id();
			} else {

				data.id = tc;
			}
		} else if (!scan.hasNextInt()) {
			System.out.println("please enter integer nummer");
			id();
		}

	}

	private static void getInfo() {
		if (map.isEmpty()) {
			System.out.println("database su an bostur");
			System.out.println();
			menu();
		}
		Data data = new Data();
		Scanner scan = new Scanner(System.in);
		System.out.println("please enter tc Nummer");
		int a = scan.nextInt();
		if (map.containsKey(a)) {
			System.out.println(map.get(a));
			System.out.println();
			menu();
		} else {
			System.out.println("boyle bir kayit bulunmamaktadir");
			System.out.println();
			menu();
		}

	}

	private static void removeInfo() {
		if (map.isEmpty()) {
			System.out.println("database su an bostur");
			System.out.println();
			menu();
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("please enter tc Nummer");
		int a = scan.nextInt();
		if (map.containsKey(a)) {
			map.remove(a);
			System.out.println("Verilen kayit silinmisir");
			System.out.println();
			menu();
		} else {
			System.out.println("boyle bir kayit bulunmamaktadir");
			System.out.println();
			menu();
		}

	}

}
