package emlakProjesi;

public class Calisan {

	private int calisanId=2;
	private int calisanPassword=2;
	
	
	
	
	public void calisan() {
		KalipHane kalip = new KalipHane();
		Patron patron = new Patron();
		
		System.out.println("Emekcimiz Hosgeldiniz\n1.Emlak Listesi\n2.Emlak ekleme\n3.Cikis");
		int secim=kalip.scan.nextInt();
		switch (secim) {
		case 1:
			patron.listeleme();
			calisan();
			break;
		case 2:
			patron.ekleme();
			calisan();
			break;
		case 3: 
			System.out.println("Gule gule");
			break;
			default:
				System.out.println("Y<nlis bir giris yaptiniz:\n------------");
				calisan();
		}
	}
	
	public int getCalisanId() {
		return calisanId;
	}



	public int getCalisanPassword() {
		return calisanPassword;
	}
	public void setCalisanId(int calisanId) {
		this.calisanId = calisanId;
	}
	public void setCalisanPassword(int calisanPassword) {
		this.calisanPassword = calisanPassword;
	}
}
