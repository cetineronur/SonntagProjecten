package emlakProjesi;

public class Runner {

	public static void main(String[] args) {
		KalipHane kalip = new KalipHane();
		
		System.out.println("Onur Emlaga hosgeldiniz....\n---------------------");
		
		int deneme =0;
		while(kalip.giris) {
			Calisan calis = new Calisan();
			Patron patron = new Patron();
			System.out.println("Lutfen id giriniz:\nLutfen sifrenizi giriniz. ");
			int id = kalip.scan.nextInt();
			int password = kalip.scan.nextInt();
			if (calis.getCalisanId()==id&&calis.getCalisanPassword()==password) {
				kalip.giris=false;
				calis.calisan();
			}else if (id==patron.getPatronId()&&password==patron.getPatronPassword()) {
				kalip.giris=false;
				patron.patron();
			}else {
				System.out.println("yanlis bir giris yaptiniz.");
				deneme++;
				if (deneme==2) {
					System.out.println("3 kere yanlis giris yaptiniz. ");
					System.exit(0);
				}
				kalip.giris=true;
			}
		}
		
	}

}
