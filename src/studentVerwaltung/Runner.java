package studentVerwaltung;

import java.lang.reflect.Array;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Runner extends Schuler implements Istudenten {

	private int reggiePassword = 1;
	private int reggieBenutzerName = 1;
	private int asistentPassword = 2;
	private int asistentBenutzerName = 2;

	public static void main(String[] args)  {
		System.out.println(
				"==================================================\n Herzlich Wilkommen Stundent Verwaltung Programme\n==================================================");
		Runner run = new Runner();
		Scanner scan = new Scanner(System.in);
		boolean dongu = true;
		int count = 0;
		while (dongu) {

			System.out.println("Bitte geben Sie BenutzerName ein: ");
			int BenutzerName = scan.nextInt();
			System.out.println("Bitte geben Sie Ihren Password ein:  ");
			int Password = scan.nextInt();

			if ((BenutzerName == run.reggieBenutzerName) && (Password == run.reggiePassword)) {
				System.out.println("Sie werden in das System als Manager angemeldet");
				System.out.println();
				dongu = false;
				menu();
			} else if ((BenutzerName == run.asistentBenutzerName) && (Password == run.asistentPassword)) {
				System.out.println("Sie werden in das System als Asistent angemeldet");
				System.out.println();
				dongu = false;
				menu();
			} else {
				count++;
				System.out.println("Sie haben den falschen Benutzernamen oder das falsche Passwort eingegeben" + "\n"
						+ (3 - count) + " giris hakkiniz kaldi");
				if (count == 3) {
					System.out.println("Sie haben drei mal falsche gegeben. ");
					dongu = false;
					System.exit(0);
				}

			}
	   	}

	}

	private static void menu() {
		Scanner scan = new Scanner(System.in);
		System.out.println(
				"Bitte treffen Sie Ihre Wahl\n1-Schuler Anmeldung\n2-Schuler Zeigen\n3-Schüler unterricht\n4-Schuler Note Eintrag");
		int secim = scan.nextInt();
		Runner run = new Runner();
		switch (secim) {
		case 1:
			run.schulerAnmeldung();
			menu();
			break;
		case 2:
			run.schulerRekordAnsehen();
			menu();
			break;
		case 3:
			run.schulerUnterrich();
			menu();
			break;
		case 4:
			run.schulerNotizEintrag();
			menu();
			break;
		
		default:
			System.out.println("Yanlis giris yaptiniz");
			menu();
		}
	}
	@Override
	public void schulerAnmeldung() {
		Schuler schuler = new Schuler();
		Scanner scan = new Scanner(System.in);
		boolean dongu = true;

		while (dongu) {

			SCHULERID++;

			System.out.println("Bitte geben Sie Name von Schuler ein: ");
			schuler.setSchulerName(scan.next());

			System.out.println("Bitte geben Sie NAhname von Schuler ein: ");
			schuler.setSchulerNahName(scan.next());

			System.out.println("Bitte geben Sie alter von Schuler ein : ");
			schuler.setSchulerAlter(scan.next());

			System.out.println("Bitte geben Sie geburtsdatum von Schuler ein: ");
			schuler.setGeburtsDatum(scan.next());

			anmeldung.put(SCHULERID, schuler.getSchulerName() + ", " + schuler.getSchulerNahName() + ", "
					+ schuler.getSchulerAlter() + ", " + schuler.getGeburtsDatum());
			System.out.println("Willst du wiederholen: 1/2");
			int secim = scan.nextInt();
			if (secim == 1) {
				dongu = true;
			} else {
				dongu = false;
			}
		}
	}
	@Override
	public void schulerNotizEintrag() {

		for (int i = 1; i <= schulerUnterrich.size(); i++) {
			String[] part = schulerUnterrich.get(i).split(", ");
			System.out.println(part[0] + " ogrencisinin notlarini girin: ");
			System.out.println();
			Scanner scan = new Scanner(System.in);
			System.out.println("Bitte geben Sie Mathe Note ein: ");
			matheNote = scan.next();

			System.out.println("Bitte geben Sie Deutsch Note ein: ");
			deutschNote = scan.next();

			System.out.println("Bitte geben Sie Sport Note ein: ");
			sportNote = scan.next();

			System.out.println("Bitte geben Sie Wirtschaft Note ein: ");
			WirtschaftNote = scan.next();

			System.out.println("Bitte geben Sie Physik Note ein: ");
			PhysikNote = scan.next();

			System.out.println("Bitte geben Sie Chemie Note ein: ");
			ChemieNote = scan.next();
			Schuler schuler = new Schuler(matheNote, deutschNote, sportNote, WirtschaftNote, PhysikNote, ChemieNote);

			// schulerNote.put(i,schuler);
			schulerNote.put(i,
					part[0] + ", " + part[1] + ", " + schuler.matheNote + ", " + part[2] + ", " + schuler.deutschNote
							+ ", " + part[3] + ", " + schuler.sportNote + ", " + part[4] + ", " + schuler.WirtschaftNote
							+ ", " + part[5] + ", " + schuler.PhysikNote + ", " + part[6] + ", " + schuler.ChemieNote);
						
			System.out.println("Wollen Sie  Note von andere Schuler eingeben 1/2 ");
			int secim = scan.nextInt();
			if (secim == 1) {
				continue;
			} else {
				schulerNoteAnsehen();
				menu();
			}
		}
	}

	@Override
	public void schulerNoteAnsehen() {
		
	for (int i = 1; i <=schulerNote.size(); i++) {
		String[] parts2 = schulerNote.get(i).split(", ");
		
		System.out.println(i + ".Schuler " +       "\nName-Nahnahme: " + parts2[0] +    "\nMathe        : " + parts2[2]
				+ "\nDeutsch      : " + parts2[4] +  "\nSport        : " + parts2[6] +    "\nWirtschaft   : " + parts2[8]
				+ "\nPhysik       : " + parts2[10] + "\nChemie       : " + parts2[12]);
		System.out.println();
		}
		menu();
	}

	@Override
	public void schulerRekordAnsehen() {

		for (int i = 1; i <= anmeldung.size(); i++) {

			String[] parts = anmeldung.get(i).split(", ");
			schulerUnterrich.put(i, parts[0] + " " + parts[1] + ", " + "Mathe" + ", " + "Deutsch" + ", " + "Sport"
					+ ", " + "Wirtschaft" + ", " + "Physik" + ", " + "Chemie");
			System.out.println(i + ".Schuler " + "\nName        : " + parts[0] + "\nNahname     : " + parts[1]
					+ "\nAlter       : " + parts[2] + "\nGeburtsDatum: " + parts[3]);
			System.out.println();
		}
		menu();

	}

	public void schulerUnterrich() {
		System.out.println();
		for (int i = 1; i <= schulerUnterrich.size(); i++) {
			String[] parts1 = schulerUnterrich.get(i).split(", ");

			System.out.println(i + ".Schuler " + "\nName-Nahnahme       : " + parts1[0] + "\n verilecek dersler: "
					+ "\n" + parts1[1] + "\n" + parts1[2] + "\n" + parts1[3] + "\n" + parts1[4] + "\n" + parts1[5]
					+ "\n" + parts1[6]);
			System.out.println();
		}
		menu();

	}

}
