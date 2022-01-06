package save;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Runner extends Data implements Idata{

	public static void main(String[] args) {

		menu();

	}

	private static void menu() {
		Runner run = new Runner();
		Scanner scan = new Scanner(System.in);
		System.out.println("======Lutfen seciminizi yapiniz=======\n1-Anmelden\n2-Information\n3-Remove Data");
		int secim = 0;
		if (scan.hasNextInt()) {
			secim = scan.nextInt();
			switch (secim) {

			case 1:
				run.getSave();
				break;
			case 2:
				run.getInfo();
				break;
			case 3:
				run.removeInfo();
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

	public void getSave() {
		id();
		name();
		adres();
		tel();

		Data data = new Data();
		Data data1 = new Data(data.id, data.getName(),data.getAdres(),data.getTelNummer());
		map.put(data1.getId(), data1.getName() + ", " + data1.getAdres() + ", " + data1.getTelNummer());
		System.out.println(map);
		selectOption();

	}

	private static void selectOption() {
		Runner run = new Runner();
		System.out.println("Tekrar kayit eklemek istiyor musunuz?1/2");
		Scanner scan = new Scanner(System.in);
		int kayit = scan.nextInt();
		if (kayit == 1) {
			run.getSave();
		} else {
			System.out.println();
			menu();
		}

	}

	private  void tel() {
		Data data = new Data();
		Scanner scan = new Scanner(System.in);

		
		System.out.println("Please enter Tel number: ");
		String tel = scan.next();
		data.setTelNummer(tel);

	}

	private  void adres() {
		Data data = new Data();
		Scanner scan = new Scanner(System.in);

		
		System.out.println("Please enter your Adresse: ");
		String adres = scan.nextLine();
		if (adres.length() < 10) {
			System.out.println("please enter ten krakter ");
			adres();
		} else {
			data.setAdres(adres); 
			}

	}

	private  void name() {
		Data data = new Data();
		Scanner scan = new Scanner(System.in);

		
		System.out.println("Please enter your Name: ");
		String name = scan.nextLine();
		if (name.matches("[a-zA-Z]+")) {
			data.setName(name);
		} else {
			System.out.println("Please enter string data");
			name();
		}

	}

	private  void id() {
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

				data.setId(tc);
			}
		} else if (!scan.hasNextInt()) {
			System.out.println("please enter integer nummer");
			id();
		}

	}
	@Override
	public void getInfo() {
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
			
				
				String[] part = map.get(a).split(", ");
				System.out.println(a+ " nolu kayit "+  "\nName-Nahname: "+part[0]+"\nAdresse     : "+part[1]+"\nTel Nummer  : "+part[2]);
			
			System.out.println();
			
			menu();
		} else {
			System.out.println("boyle bir kayit bulunmamaktadir");
			System.out.println();
			menu();
		}
	

	}
	@Override
	public void removeInfo() {
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
		}scan.close();

	}

}
