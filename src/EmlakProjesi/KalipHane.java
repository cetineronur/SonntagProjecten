package emlakProjesi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KalipHane {
	
	protected int ilanNo=99;
	protected int metre;
	protected int odaSayisi;
	protected int bulunduguKat;
	private int fiyat;
	boolean giris=true;
	
	
	static List<KalipHane> list = new ArrayList<>();
	protected Scanner scan= new Scanner(System.in);
	KalipHane(){
		
	}
	
	KalipHane(int ilanNo,int metre,int odaSayisi,int bulunduguKat,int fiyat ){
		
		this.ilanNo=ilanNo;
		this.metre=metre;
		this.odaSayisi=odaSayisi;
		this.bulunduguKat=bulunduguKat;
		this.fiyat=fiyat;
		
		//
	}
	public void ListeleEmlak() {
		System.out.println("\nListe no      :"+ ilanNo +"\nMetre Kare    :"+metre+"\nOda Sayisi    :"+ odaSayisi 
				+"\nBulundugu Kat :"+bulunduguKat+ "\nFiyat         :"+getFiyat());
	}

	

	public int getFiyat() {
		return fiyat;
	}


	public void setFiyat(int fiyat) {
		this.fiyat = fiyat;
	}
	
	
}
