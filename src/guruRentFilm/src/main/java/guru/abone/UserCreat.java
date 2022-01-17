package guru.abone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserCreat {
	static Scanner scan = new Scanner(System.in);
	
	public static void userCreat(Connection con, Statement st) throws SQLException, ClassNotFoundException {
		Abone abone = new Abone();
		AboneData abonedata = new AboneData();
		boolean dongu=true;
		
		while(dongu) {
		System.out.println("Lutfen adinizi giriniz:");
		
		abonedata.setAd(scan.next());
	
		if(abonedata.getAd().matches("[a-zA-Z]+")){
			abonedata.setAd(abonedata.getAd());
			dongu=false;
		}else {
				System.out.println("lutfen string bir data giriniz");
				dongu=true;
			}
		}
	
		dongu=true;
		while(dongu) {
			System.out.println("Lutfen yasinizi giriniz:");
			
			abonedata.setYas(scan.next());
		if(!abonedata.getYas().matches("-?\\d+(\\.\\d+)?")) {
			System.out.println("lutfen sayisal bir data girin");
			dongu=true;
		}
		else if((Integer.parseInt(abonedata.getYas())<18)) {
			System.out.println("18 yasindan kucukler sisteme kayit olamaz");
			abone.menu1(con, st);
		}else {
			dongu=false;
		}
		}
		
		dongu=true;
		while(dongu) {
			System.out.println("Sisteme kayit icin lutfen string olan ve alti krakterden buyuk kullanici adinizi girin");
		
			abonedata.setId(scan.next());
			if(abonedata.getId().matches("[a-zA-Z]+")&&abonedata.getId().length()>=6){
				abonedata.setId(abonedata.getId());
				dongu=false;
			}else if(!abonedata.getId().matches("[a-zA-Z]+")){
				System.out.println("Lutfen string bir deger girin ");
				dongu=true;
			}else if(abonedata.getAd().length()<6) {
				System.out.println("Lutfen alti krakter girin");
				dongu=true;
			}
			
		}
		dongu=true;
		
		while(dongu) {
			System.out.println("Lutfen sifrenizi bes haneli olarak giriniz:");
			
			abonedata.setSifre(scan.next());
		if(!abonedata.getSifre().matches("-?\\d+(\\.\\d+)?")) {
			System.out.println("lutfen sayisal bir data girin");
			dongu=true;
		}
		else if((Integer.parseInt(abonedata.getSifre())<10000)||Integer.parseInt(abonedata.getSifre())>99999) {
			System.out.println("sifrenizi bes haneli olarak girmelisiniz");
			System.out.println();
			dongu=true;
			
		}else {
			dongu=false;
		}
		}
		
	
		//AboneData a1 = new AboneData();
		AboneData a2=new AboneData(abonedata.getAd(), abonedata.getYas(), abonedata.getId(), abonedata.getSifre());
		
		PreparedStatement	ps = con.prepareStatement("insert into kayit(ad,yas,id,sifre)values(?,?,?,?)");// kayit veritabanina veri
																							// gonderecegimi
																							// soyluyorum.
		ps.setString(1, a2.getAd()); // ps nesnesine gelen id yi kayit etti.
		ps.setString(2, a2.getYas());
		ps.setString(3, a2.getId());
		ps.setString(4, a2.getSifre());
		ps.execute();// sorguyu calistirir ve 0 dan buyukse kayit basarili olur.
		System.out.println("Kayit basari ile yapilmistir.");
		System.out.println("sisteme giris yapmaniz gerekmektedir");
		System.out.println();
		abone.loginSystem(st, con);
		
		
	}
}
