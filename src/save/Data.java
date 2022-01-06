package save;

import java.util.HashMap;
import java.util.Map;

public class Data {
	 
	static Map<Integer,String> map = new HashMap<>();
	
	protected  static int    id;
	private static  String telNummer;
	private static  String adres;
	private static  String name;
	
	public Data(int id, String name, String adres, String telNummer){
		this.id = id;
		this.telNummer = telNummer;
		this.adres = adres;
		this.name = name;
		
	}
	
	Data(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTelNummer() {
		return telNummer;
	}
	public void setTelNummer(String telNummer) {
		this.telNummer = telNummer;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	



	
}
