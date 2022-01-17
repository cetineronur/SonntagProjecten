package guru.abone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import techproed.jdbc.Kayit1;



public class Abone {

	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root",
				"1234");

		Statement st = con.createStatement();
		
		AboneData a = new AboneData();
		AboneData a1=new AboneData(a.getAd(), a.getYas(), a.getId(), a.getSifre());

		//PreparedStatement ps = null; // veritabanina gonderilecek bilgileri bu nesne tutacak ve gonderecek
		ResultSet veri = st.executeQuery("select * from sys.kayit");
		while(veri.next()) {
			if(veri.getString("ad").equals(" ")) {
				st.execute("CREATE TABLE kayit" + " (ad varchar(20) ," + " yas int," + " id varchar(20),"
						+ " sifre varchar(20))");
			}else {
				menu1(con, st);
			}
		}
		
	
	}
	 static void menu1(Connection con,Statement st) throws SQLException, ClassNotFoundException {
		 UserCreat usercreat = new UserCreat();
		System.out.println("Lutfen seciminizi yapiniz:\n1-Kullanici olustur\n2-Sisteme giris yap\n3-sifreni degistir");
		String secim = scan.next();
		switch (secim) {
		case "1":
			usercreat.userCreat(con,st);
			break;
		case "2":
			loginSystem(st,con);
			break;
		case "3":
			sifreUpdate(st,con);
			break;
		default:
			System.out.println("yanlis bir giris yaptiniz. tekrar giris yapiniz");
			menu1(con, st);
			break;
		
	}
		

	}
	
	 private static void sifreUpdate(Statement st, Connection con) throws SQLException, ClassNotFoundException {
		 AboneData a = new AboneData();
			AboneData a2=new AboneData(a.getAd(), a.getYas(), a.getId(), a.getSifre());
			System.out.println("Lutfen adinizi giriniz:");
			String ad1 = scan.next();
			

			ResultSet veri = st.executeQuery("select * from kayit ");
			PreparedStatement ps = null;
			while (veri.next()) {

				if (veri.getString("ad").equals(ad1)) {
					boolean dongu=true;
					int count=0;
					while(dongu) {
						System.out.println("Lutfen kullanici adinizi giriniz");
						String id1=scan.next();
					if(veri.getString("id").equals(id1)) {
						while(dongu) {
							System.out.println("Lutfen sifrenizi bes haneli olarak giriniz:");
							
							a2.setSifre(scan.next());
						if(!a2.getSifre().matches("-?\\d+(\\.\\d+)?")) {
							System.out.println("lutfen sayisal bir data girin");
							dongu=true;
						}
						else if((Integer.parseInt(a2.getSifre())<10000)||Integer.parseInt(a2.getSifre())>99999) {
							System.out.println("sifrenizi bes haneli olarak girmelisiniz");
							System.out.println();
							dongu=true;
							
						}else {
							dongu=false;
						}
						}
					ps = con.prepareStatement("update kayit set sifre=? where id='" + id1 + "' ;");
					ps.setString(1, a2.getSifre());
					ps.executeUpdate();
					System.out.println("Kayit basari ile guncellenmistir.");
					System.out.println();
					menu1(con, st);
					}else {
						count++;
						if(count==3) {
							System.out.println("cok fazla yanlis giris yaptiniz");
							menu1(con, st);
						}else {
							System.out.println("kullanici adiniz eslesmiyor. ");
							dongu=true;
						}
					}
					}
					}
						
					
			}	System.out.println("Kayitlarimizda boyle bir isim yoktur");
			sifreUpdate(st, con);	
			con.close();
			st.close();
		
	}
	static void loginSystem(Statement st, Connection con) throws SQLException, ClassNotFoundException {
		System.out.println("Lutfen kullanici adinizi giriniz:");
		String id1=scan.next();
		System.out.println("Lutfen sifrenizi giriniz");
		String sifre1=scan.next();
		
		ResultSet veri = st.executeQuery("select * from kayit ");

		while (veri.next()) {

			if (veri.getString("id").contains(id1)&&veri.getString("sifre").contains(sifre1)) {
				menu2();
				
			}

		}
		System.out.println("Kayitlarimizda boyle bir kullanici adi veya sifre yoktur");
	
		System.out.println();
		menu1(con, st);
		
	}
	static void menu2() throws ClassNotFoundException, SQLException {
		Film film = new Film();
		
		System.out.println();
		System.out.println("Lutfen seciminizi yapiniz\n1-Film Kiralama\n2-Film SAtin alma");
		
		String secim=scan.next();
		switch (secim) {
		case "1":
			film.rentFilm();
			break;
		case "2":
			film.buyFilm();
		default:
			System.out.println("Lutfen dogru giris yapiniz:");
			break;
		}
		
		
		
	}
	

}
