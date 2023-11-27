package gym_mang;

public class Payement {
	private String periode , membre , montant;
	public Payement(String periode ,String membre,String montant ) {
		this.periode=periode;
		this.membre=membre;
		this.montant = montant;
	}
	public String getPeriode() {
		return periode;
	}
	public String getMembre() {
		return membre;
	}
	public String getMontant() {
		return montant;
	}
	public void setPeriode(String periode) {
		this.periode = periode;
	}
	public void setMembre(String membre) {
		this.membre = membre;
	}
	public void setMontant(String montant) {
		this.montant = montant;
	}
	

}
