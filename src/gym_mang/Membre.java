package gym_mang;

public class Membre {
	private String CIN , Nom , Prénom,sexe,téléphone;
	private int payé;
	public Membre(String CIN ,String Nom ,String Prénom,String téléphone,int payé,String sexe) {
		this.CIN=CIN;
		this.Nom=Nom;
		this.Prénom=Prénom;
		this.téléphone=téléphone;
		this.sexe=sexe;
		this.payé=payé;
	}
	public String getCIN() {
		return CIN;
	}
	public String getNom() {
		return Nom;
	}
	public String getPrénom() {
		return Prénom;
	}
	public String getTéléphone() {
		return téléphone;
	}
	public String getSexe() {
		return sexe;
	}
	public int getPayé() {
		return payé;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public void setPrénom(String prénom) {
		Prénom = prénom;
	}
	public void setAdresse(String téléphone) {
		this.téléphone = téléphone;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public void setAge(int payé) {
		this.payé = payé;
	}
	
	

}
