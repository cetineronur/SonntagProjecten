package krankenHause;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VeriBankasi {
		protected static List<String> doctorIsimleri= new ArrayList<>(Arrays.asList("Nilson", "John", "Robert", "Marry", "Alan", "Mahesh" ));
		protected static List<String> doctorSoyIsimleri= new ArrayList<>(Arrays.asList("Avery", "Abel", "Erik", "Jacob", "Pedro", "Tristen" ));
		protected static List<String> unvanlar= new ArrayList<>(Arrays.asList("Allergist", "Norolog", "Genel cerrah", "Cocukdoktoru", "Dahiliye", "Kardiolog"  ));
		protected static List<String> hastaIsimleri= new ArrayList<>(Arrays.asList("Warren", "Petanow", "Sophia", "Emma", "Darian", "Peter" ));
		protected static List<String> hastaSoyIsimleri= new ArrayList<>(Arrays.asList("Traven", "William", "George", "Tristan", "Luis", "Cole"));
		protected static List<String> durumlar= new ArrayList<>(Arrays.asList("Allerji", "Bas agrisi", "Diabet", "Sogukalginligi", "Migren", "Kalphastaliklari"));
		protected static List<Integer> hastaIDleri= new ArrayList<>(Arrays.asList(111,222,333,444,555,666));
		protected static List<String> randevu =new ArrayList<>(Arrays.asList("8","9","10","11","13"));
		protected static List<VeriBankasi> randevuKayit = new ArrayList<>();
				 	
				 	public VeriBankasi(String unvan, String string) {
						super();
					}
				 	VeriBankasi(){
					 	
				 	}
					VeriBankasi(List<String> unvan){
				 	
				 	}

					public void listeleRandevu(String unvan, String string) {
						System.out.println("\nBransi       :"+ unvan+"\nRandevu Saati: "+string+"\n");
						
					}
				}
