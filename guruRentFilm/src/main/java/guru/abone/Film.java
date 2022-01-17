package guru.abone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

		public class Film {
				public void buyFilm() {
				System.out.println("Film satin almaya hosgeldiniz");
		
				}
		public void rentFilm() throws ClassNotFoundException, SQLException {
			
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root",
					"1234");

			Statement st = con.createStatement();
	
			ResultSet sorgu = st.executeQuery("select * from film");
			System.out.println("Id        fILM ADI                       TURU              YILI\n==============================================================");
			while (sorgu.next()) {

				System.out.println(sorgu.getInt(1) + "       " + sorgu.getString(2) + "            " + sorgu.getString(3)+"           "+sorgu.getInt(4));
			}
			sorgu.close();
			System.out.println();
			int a=0;
			boolean dongu=true;
		while(dongu) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Lutfen  kiralamak istediginiz filmin idsini giriniz");
			int id=scan.nextInt();
			ResultSet sorgu1 = st.executeQuery("select * from film");
			while (sorgu1.next()) {
				
				if(sorgu1.getInt("id")==id) {
					System.out.println("Kiralamak istediginiz film:");
					PreparedStatement ps = null;
					ps = con.prepareStatement("update film set kiralama=kiralama+1 where id='" + id + "' ;");
					//ps.setInt(1, sorgu1.getInt("kiralama"));
					ps.executeUpdate();
					System.out.println(sorgu1.getInt(1) + "       " + sorgu1.getString(2) + "            " + sorgu1.getString(3)+"           "+sorgu1.getInt(4)+"  "+"Kiralanma sayisi: "+sorgu1.getInt(5));
					a=sorgu1.getInt(5);
				}
				
				}
			System.out.println("baska bir film kiralamak isiyor musunuz 1/2");
			int secim= scan.nextInt();
			if(secim==1) {
				dongu=true;
				}else {
					dongu=false;
					odeme(a);
				}
			
	
	}

	}
		public void odeme(int a) throws ClassNotFoundException, SQLException {
			System.out.println("Bir film kiralama 5 Euro'dur\nSiz toplam "+a+" tane film kiraladiniz.\nToplam: "+5*a+" Euro odemeniz gerekmektedir.");
			System.out.println();
			Abone abone = new Abone();
			abone.menu2();
		}
}
