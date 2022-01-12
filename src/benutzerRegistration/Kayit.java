package techproed.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Kayit implements Ikayit {

	static String sql;

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		menu();

	}

	private static void menu() throws ClassNotFoundException, SQLException {
		Kayit kayit = new Kayit();

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root",
				"1234");

		Statement st = con.createStatement();

		System.out.println(
				"=========================================\nLutfen seciminizi yapiniz\n1-Kayit\n2-Id ile Listeleme\n3-Butun kayitlari listeleme\n4-Id ile kayit silme\n5-Kayit Guncelleme\n6-Password guncelleme\n=========================================");
		Scanner scan = new Scanner(System.in);
		int key = scan.nextInt();
		switch (key) {
		case 1:
			kayit(st, con);
			break;
		case 2:
			kayit.idList(st, con);
			break;
		case 3:
			alleList(st, con);
			break;
		case 4:
			idDelete(st, con);
			break;
		case 5:
			kayitUpdate(st, con);
			break;
		case 6:
			passUpdate(st, con);
			break;
		default:
			System.out.println("Yanlis bir giris yaptiniz");
			break;
		}
		con.close();
		st.close();

	}

	private static void passUpdate(Statement st, Connection con) throws ClassNotFoundException, SQLException {
		Kayit1 kayit = new Kayit1();

		Kayit1 kayit1 = new Kayit1(kayit.getId(), kayit.getPass(), kayit.getName(), kayit.getnName());
		System.out.println("Lutfen guncellenecek kayidin idsini giriniz:");
		int id1 = scan.nextInt();

		ResultSet veri = st.executeQuery("select * from kayit ");
		PreparedStatement ps = null;
		boolean dongu = true;
		while (veri.next()) {

			if (veri.getInt("id") == id1) {
				pass(st);
				ps = con.prepareStatement("update kayit set pass=? where id='" + id1 + "' ;");
				ps.setInt(1, kayit.getPass());
				ps.executeUpdate();
				System.out.println("Kayit basari ile guncellenmistir.");
				System.out.println();
				System.out.println("tekrar guncelleme yapmak istiyor musunuz?E/H");
				String wahl = scan.next().toUpperCase();
				if (wahl.equals("E")) {
					dongu = true;
				} else {
					dongu = false;
					menu();
				}
			}
		}System.out.println("Kayitlarimizda boyle bir id yoktur");
		passUpdate(st, con);
		con.close();
		st.close();
	}

	private static void kayitUpdate(Statement st, Connection con) throws SQLException, ClassNotFoundException {
		Kayit1 kayit = new Kayit1();

		Kayit1 kayit1 = new Kayit1(kayit.getId(), kayit.getPass(), kayit.getName(), kayit.getnName());
		System.out.println("Lutfen guncellenecek kayidin idsini giriniz:");
		int id1 = scan.nextInt();

		ResultSet veri = st.executeQuery("select * from kayit ");
		PreparedStatement ps = null;
		boolean dongu = true;
		while (veri.next()) {

			if (veri.getInt("id") == id1) {

				pass(st);
				name(st);
				nNahme(st);
				ps = con.prepareStatement("update kayit set pass=?,name=?,nName=? where id=?");
				ps.setInt(1, kayit.getPass());
				ps.setString(2, kayit.getName());
				ps.setString(3, kayit.getnName());
				ps.setInt(4, id1);
				ps.executeUpdate();
				System.out.println("Kayit basari ile guncellenmistir.");
				System.out.println();
				System.out.println("tekrar guncelleme yapmak istiyor musunuz?E/H");
				String wahl = scan.next().toUpperCase();
				if (wahl.equals("E")) {
					dongu = true;
				} else {
					dongu = false;
					menu();
				}

			}
		}System.out.println("Kayitlarimizda boyle bir id yoktur");
		kayitUpdate(st, con);
		con.close();
		st.close();

	}

	public static void kayit(Statement st, Connection con) throws SQLException, ClassNotFoundException {

		Kayit1 kayit = new Kayit1();

		Kayit1 kayit1 = new Kayit1(kayit.getId(), kayit.getPass(), kayit.getName(), kayit.getnName());

		PreparedStatement ps = null; // veritabanina gonderilecek bilgileri bu nesne tutacak ve gonderecek
		int i = 0;
		String sorgu = "CREATE TABLE kayit" + " (id int ," + " pass int," + " name  varchar(10),"
				+ " nName varchar(10))";
		st.execute(sorgu);
		boolean dongu = true;
		while (dongu) {
			kayit.id++;
			
			name(st);
			nNahme(st);
			pass(st);
			ps = con.prepareStatement("insert into kayit(id,pass,name,nName)values(?,?,?,?)");// kayit veritabanina veri
																								// gonderecegimi
																								// soyluyorum.
			ps.setInt(1, kayit.getId()); // ps nesnesine gelen id yi kayit etti.
			ps.setInt(2, kayit.getPass());
			ps.setString(3, kayit.getName());
			ps.setString(4, kayit.getnName());
			ps.executeUpdate();// sorguyu calistirir ve 0 dan buyukse kayit basarili olur.
			System.out.println("Kayit basari ile yapilmistir.\ntekrar giris yapmak istiyor musunuz?E/H");
			String wahl = scan.next().toUpperCase();
			if (wahl.equals("E")) {
				dongu = true;
			} else {
				dongu = false;
				menu();
			}

		}
		con.close();
		st.close();

	}

	private static String nNahme(Statement st) throws SQLException {

		Kayit1 kayit = new Kayit1();

		System.out.print("Please enter your surName: ");
		kayit.setnName(scan.next());
		if (kayit.getnName().matches("[a-zA-Z]+")) {
			kayit.setnName(kayit.getnName());
		} else {
			System.out.println("Please enter string data");
			nNahme(st);
		}
		return kayit.getnName();

	}

	private static String name(Statement st) throws SQLException {
		Kayit1 kayit = new Kayit1();
		System.out.print("Please enter your Name: ");
		
		kayit.setName(scan.next());

		if (kayit.getName().matches("[a-zA-Z]+")) {
			kayit.setName(kayit.getName());
		} else {
			System.out.println("Please enter string data");
			name(st);
		}
		return kayit.getName();

	}

	private static int pass(Statement st) throws SQLException {
		Kayit1 kayit = new Kayit1();
		System.out.print("please create your four digit password:");
		kayit.setPass(0);
		if (scan.hasNextInt()) {
			kayit.setPass(scan.nextInt());
			if (kayit.getPass() < 1000 || kayit.getPass() > 9999) {
				System.out.println("please enter four digit");
				pass(st);
			}
		} else if (!scan.hasNextInt()) {
			System.out.println("please enter integer nummer");
			pass(st);
		}
		return kayit.getPass();

	}

	@Override
	public void idList(Statement st, Connection con) throws SQLException, ClassNotFoundException {
		System.out.println("Lutfen aranacak kayidin idsini giriniz:");
		int id1 = scan.nextInt();

		ResultSet veri = st.executeQuery("select * from kayit ");

		while (veri.next()) {

			if (veri.getInt("id") == id1) {
				System.out.println("Adi   : " + veri.getString(3) + "\nSoyadi: " + veri.getString(4));
				menu();
			}

		}
		System.out.println("Kayitlarimizda boyle bir id yoktur");
		idList(st, con);
		con.close();
		st.close();
	}

	private static void alleList(Statement st, Connection con) throws SQLException, ClassNotFoundException {
		ResultSet sorgu = st.executeQuery("select * from kayit");
		System.out.println("Id      Adi       Soyadi\n========================");
		while (sorgu.next()) {

			System.out.println(sorgu.getInt(1) + "      " + sorgu.getString(3) + "       " + sorgu.getString(4));
		}
		System.out.println("");
		menu();
		con.close();
		st.close();

	}

	private static void idDelete(Statement st, Connection con) throws SQLException, ClassNotFoundException {
		System.out.println("Lutfen silinecek kayidin idsini giriniz:");
		int id1 = scan.nextInt();
		PreparedStatement ps = null;
		ResultSet veri = st.executeQuery("select * from kayit ");

		while (veri.next()) {

			if (veri.getInt("id") == id1) {
				ps = con.prepareStatement("delete from kayit where id=?");
				ps.setInt(1, id1);
				ps.executeUpdate();
				System.out.println(id1 + " numarali kayit basari ile silinmistir");
				menu();
			}

		}
		System.out.println("Kayitlarimizda boyle bir id yoktur");
		idDelete(st, con);
		con.close();
		st.close();

	}
	
}
