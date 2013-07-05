package shop.common.valueobjects;

import java.util.List;
import java.util.Vector;

public class Kunde extends Person {

	private static final long serialVersionUID = 4664724545004822767L;
	
	// Attribute zur Beschreibung des Kunden	
	private String strasse;
	private int plz;
	private String wohnort;
	private transient List<WarenkorbArtikel> warenkorb;
	
	public Kunde(int id, String username, String passwort, String name, String strasse, int plz, String wohnort) {
		super(id, username, passwort, name, PersonTyp.Kunde);
		this.strasse = strasse;
		this.plz = plz;
		this.wohnort = wohnort;
		this.warenkorb = new Vector<WarenkorbArtikel>();
	}
	
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	
	public String getStrasse() {
		return strasse;
	}
	
	public void setPlz(int plz) {
		this.plz = plz;
	}
	
	public int getPlz() {
		return plz;
	}
	
	public void setWohnort(String wohnort) {
		this.wohnort = wohnort;
	}
	
	public String getWohnort() {
		return wohnort;
	}
	
	public void setWarenkorb(List<WarenkorbArtikel> warenkorb) {
		this.warenkorb = warenkorb;
	}
	
	public List<WarenkorbArtikel> getWarenkorb() {
		return warenkorb;
	}
	
	public String toString() {
		return "Kundennummer: " + getId() + "\n\n" + getName() + "\n" + strasse + "\n" + plz + " " + wohnort + "\n";
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Kunde) {
			return ((Kunde) o).getId() == this.getId();
		} else {
			return false;
		}
	}
	
}
