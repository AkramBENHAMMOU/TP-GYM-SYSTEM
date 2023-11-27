package gym_mang;

public class Coach {
private String CIN,nom_complet;
private int age , tele;
public Coach(String CIN,String nom_complet,int age,int tele) {
	this.CIN=CIN;
	this.nom_complet=nom_complet;
	this.age=age;
	this.tele=tele;
}
public String getCIN() {
	return CIN;
}
public String getNom_complet() {
	return nom_complet;
}
public int getAge() {
	return age;
}
public int getTele() {
	return tele;
}
public void setCIN(String cIN) {
	CIN = cIN;
}
public void setNom_complet(String nom_complet) {
	this.nom_complet = nom_complet;
}
public void setAge(int age) {
	this.age = age;
}
public void setTele(int tele) {
	this.tele = tele;
}

}
