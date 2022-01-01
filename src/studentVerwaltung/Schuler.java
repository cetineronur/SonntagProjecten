package studentVerwaltung;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Schuler  {

	static int SCHULERID=0;
	private String schulerName;
	private String schulerNahName;
	private String schulerAlter;
	private String geburtsDatum;
	protected String matheNote;
	protected String deutschNote;
	protected String sportNote;
	protected String WirtschaftNote;
	protected String ChemieNote;
	protected String PhysikNote;
	//Runner run = new Runner();
	

	static Map<Integer, String> anmeldung = new HashMap<>();
	static Map<Integer, String> schulerUnterrich = new HashMap<>();
	protected Map<Integer,String> schulerNote = new HashMap<>(); 

	public Schuler(String matheNote, String deutschNote, String sportNote, String wirtschaftNote, String physikNote ,
			String chemieNote) {
		super();
		this.matheNote = matheNote;
		this.deutschNote = deutschNote;
		this.sportNote = sportNote;
		this.WirtschaftNote = wirtschaftNote;
		this.ChemieNote = chemieNote;
		this.PhysikNote = physikNote;
	}


	public Schuler() {
		// TODO Auto-generated constructor stub
	}
	

	public String getSchulerName() {
		return schulerName;
	}

	public void setSchulerName(String schulerName) {
		this.schulerName = schulerName;
	}

	
	public void schulerZeigen() {
		System.out.println("\nSchuler Nummer       : "+SCHULERID+"\nSchuler Vor-Nachname : "+schulerName+"\nSchuler Alter        : "+schulerAlter+"\nGeburts Datum        : "+geburtsDatum);
		System.out.println();
	}

	public String getSchulerAlter() {
		return schulerAlter;
	}

	public void setSchulerAlter(String schulerAlter) {
		this.schulerAlter = schulerAlter;
	}

	public String getGeburtsDatum() {
		return geburtsDatum;
	}

	public void setGeburtsDatum(String geburtsDatum) {
		this.geburtsDatum = geburtsDatum;
	}

	public String getSchulerNahName() {
		return schulerNahName;
	}

	public void setSchulerNahName(String schulerNahName) {
		this.schulerNahName = schulerNahName;
	}
	

	
}
