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
		@SuppressWarnings("resource")
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
		new Kayit1();

		new Kayit1(Kayit1.getId(), Kayit1.getPass(), Kayit1.getName(), Kayit1.getnName());
		System.out.println("Lutfen guncellenecek kayidin idsini giriniz:");
		int id1 = scan.nextInt();

		ResultSet veri = st.executeQuery("select * from kayit ");
		PreparedStatement ps = null;
		while (veri.next()) {

			if (veri.getInt("id") == id1) {
				boolean dongu=true;
				int count=0;
				while(dongu) {
					System.out.println("Lutfen sifrenizi giriniz");
					int p=scan.nextInt();
				if(veri.getInt("pass")==p) {
				pass(st);
				ps = con.prepareStatement("update kayit set pass=? where id='" + id1 + "' ;");
				ps.setInt(1, Kayit1.getPass());
				ps.executeUpdate();
				System.out.println("Kayit basari ile guncellenmistir.");
				System.out.println();
				System.out.println("tekrar guncelleme yapmak istiyor musunuz?E/H");
				String wahl = scan.next().toUpperCase();
				if (wahl.equals("E")) {
				} else {
					menu();
				}
				}else {
					count++;
					if(count==3) {
						System.out.println("cok fazla yanlis giris yaptiniz");
						menu();
					}else {
						System.out.println("Sifreniz eslesmiyor. ");
						dongu=true;
					}
				}
				}
				}
		}System.out.println("Kayitlarimizda boyle bir id yoktur");
		passUpdate(st, con);
		con.close();
		st.close();
	}

	private static void kayitUpdate(Statement st, Connection con) throws SQLException, ClassNotFoundException {
		new Kayit1();

		new Kayit1(Kayit1.getId(), Kayit1.getPass(), Kayit1.getName(), Kayit1.getnName());
		System.out.println("Lutfen guncellenecek kayidin idsini giriniz:");
		int id1 = scan.nextInt();

		ResultSet veri = st.executeQuery("select * from kayit ");
		PreparedStatement ps = null;
		while (veri.next()) {

		if (veri.getInt("id") == id1) {
			boolean dongu=true;
			int count=0;
			while(dongu) {
				System.out.println("Lutfen sifrenizi giriniz");
				int p=scan.nextInt();
			if(veri.getInt("pass")==p) {
				pass(st);
				name(st);
				nNahme(st);
				ps = con.prepareStatement("update kayit set pass=?,name=?,nName=? where id=?");
				ps.setInt(1, Kayit1.getPass());
				ps.setString(2, Kayit1.getName());
				ps.setString(3, Kayit1.getnName());
				ps.setInt(4, id1);
				ps.executeUpdate();
				System.out.println("Kayit basari ile guncellenmistir.");
				System.out.println();
				System.out.println("tekrar guncelleme yapmak istiyor musunuz?E/H");
				String wahl = scan.next().toUpperCase();
				if (wahl.equals("E")) {
				} else {
					menu();
				}
			}else {
				count++;
				if(count==3) {
					System.out.println("cok fazla yanlis giris yaptiniz");
					menu();
				}else {
					System.out.println("Sifreniz eslesmiyor. ");
					dongu=true;
				}
			}
			}
			}
		}System.out.println("Kayitlarimizda boyle bir id yoktur");
		kayitUpdate(st, con);
		con.close();
		st.close();

	}

	public static void kayit(Statement st, Connection con) throws SQLException, ClassNotFoundException {

		new Kayit1();

		new Kayit1(Kayit1.getId(), Kayit1.getPass(), Kayit1.getName(), Kayit1.getnName());

		//PreparedStatement ps = null; // veritabanina gonderilecek bilgileri bu nesne tutacak ve gonderecek
		
		st.execute("CREATE TABLE kayit" + " (id int ," + " pass int," + " name  varchar(10),"
				+ " nName varchar(10))");
		boolean dongu = true;
		while (dongu) {
			Kayit1.id++;
			
			name(st);
			nNahme(st);
			pass(st);
			PreparedStatement	ps = con.prepareStatement("insert into kayit(id,pass,name,nName)values(?,?,?,?)");// kayit veritabanina veri
																								// gonderecegimi
																								// soyluyorum.
			ps.setInt(1, Kayit1.getId()); // ps nesnesine gelen id yi kayit etti.
			ps.setInt(2, Kayit1.getPass());
			ps.setString(3, Kayit1.getName());
			ps.setString(4, Kayit1.getnName());
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

		new Kayit1();

		System.out.print("Please enter your surName: ");
		Kayit1.setnName(scan.next());
		if (Kayit1.getnName().matches("[a-zA-Z]+")) {
			Kayit1.setnName(Kayit1.getnName());
		} else {
			System.out.println("Please enter string data");
			nNahme(st);
		}
		return Kayit1.getnName();

	}

	private static String name(Statement st) throws SQLException {
		new Kayit1();
		System.out.print("Please enter your Name: ");
		
		Kayit1.setName(scan.next());

		if (Kayit1.getName().matches("[a-zA-Z]+")) {
			Kayit1.setName(Kayit1.getName());
		} else {
			System.out.println("Please enter string data");
			name(st);
		}
		return Kayit1.getName();

	}

	private static int pass(Statement st) throws SQLException {
		new Kayit1();
		System.out.print("please create your four digit password:");
		Kayit1.setPass(0);
		if (scan.hasNextInt()) {
			Kayit1.setPass(scan.nextInt());
			if (Kayit1.getPass() < 1000 || Kayit1.getPass() > 9999) {
				System.out.println("please enter four digit");
				pass(st);
			}
		} else if (!scan.hasNextInt()) {
			System.out.println("please enter integer nummer");
			pass(st);
		}
		return Kayit1.getPass();

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
