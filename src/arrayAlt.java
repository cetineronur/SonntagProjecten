

import java.util.ArrayList;
import java.util.List;

public class arrayAlt {
	public static void main(String[] args) {
		/*
		 * From a given array find all pairs whose sum is a given number verilen bir
		 * arraydeki, toplamı belirli bir sayı olan tüm çiftleri bulun For example;
		 * input : {4, 6, 5, -10, 8, 5, 20} ==> 10 
		 * Output : 4 + 6 = 10, 5 + 5 = 10, -10+ 20 = 10
		 */

		int arr[] = {4, 6, 5, -10, 8, 5, 20};
		int istenenSayi = 10;
		String sonuc = "";
		
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = i+1; j < arr.length; j++) {
				
				if (istenenSayi == (arr[i]+arr[j])) {
					sonuc+=arr[i] + " + " + arr[j] + " = " + (arr[i]+arr[j]) +", ";
				}			
			}			
		}
		System.out.println(sonuc);	
		
	}
}
