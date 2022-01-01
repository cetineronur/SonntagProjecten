package save;

import java.util.HashMap;
import java.util.Map;

public class Data {
	 static Map<Integer,String> map = new HashMap<>();
	
	protected static  int id;
	protected static int telNummer;
	protected  static String adres;
	protected  static String name;
	
	Data(){
		
	}
	

	 Data(int id, int telNummer, String adres, String name) {
	
		this.id = id;
		this.telNummer = telNummer;
		this.adres = adres;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Data [id=" + id + ", telNummer=" + telNummer + ", adres=" + adres + ", name=" + name + "]";
	}
	

	
}
