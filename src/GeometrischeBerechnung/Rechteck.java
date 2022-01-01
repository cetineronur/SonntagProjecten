package geometrischeBerechnung;

public class Rechteck {

	 double kisaKenar;
	private double uzunKenar;
	protected double kare;
	
	Rechteck(){
		
	}
	
	public Rechteck(double kare) {
		super();
		this.kare = kare;
	}
	public Rechteck(double kisaKenar, double uzunKenar) {
		super();
		this.kisaKenar = kisaKenar;
		this.uzunKenar = uzunKenar;
	}

	public double getKisaKenar() {
		return kisaKenar;
	}

	public void setKisaKenar(double kisaKenar) {
		this.kisaKenar = kisaKenar;
	}

	public double getUzunKenar() {
		return uzunKenar;
	}

	public void setUzunKenar(double uzunKenar) {
		this.uzunKenar = uzunKenar;
	}

	public double getKare() {
		return kare;
	}

	public void setKare(double kare) {
		this.kare = kare;
	}
	
	
}
