package techproed.jdbc;

public class Kayit1 {
	 static int id;
	private static int pass;
	private static String name;
	private static String nName;
	
public Kayit1(int id, int pass, String name,String nName) {
	this.id=id;
	this.pass=pass;
	this.name=name;
	this.nName=nName;
}

public Kayit1() {
	// TODO Auto-generated constructor stub
}

public static int getId() {
	return id;
}
public static void setId(int id) {
	Kayit1.id = id;
}
public static int getPass() {
	return pass;
}
public static void setPass(int pass) {
	Kayit1.pass = pass;
}
public static String getName() {
	return name;
}
public static void setName(String name) {
	Kayit1.name = name;
}
public static String getnName() {
	return nName;
}
public static void setnName(String nName) {
	Kayit1.nName = nName;
}


}