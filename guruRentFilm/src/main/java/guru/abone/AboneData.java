package guru.abone;

public class AboneData {
    private String ad;
    private String yas;
    private String id;
    private String sifre;

    public AboneData(String ad, String yas, String id, String sifre) {
        this.ad = ad;
        this.yas = yas;
        this.id = id;
        this.sifre = sifre;
    }

    public AboneData() {
		// TODO Auto-generated constructor stub
	}

	public String getAd() {
        return ad;
    }

    public String getYas() {
        return yas;
    }

    public String getId() {
        return id;
    }

    public String getSifre() {
        return sifre;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public void setYas(String yas) {
        this.yas = yas;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
}
