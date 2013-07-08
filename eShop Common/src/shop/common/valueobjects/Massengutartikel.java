package shop.common.valueobjects;

import shop.common.exceptions.ArtikelBestandIstKeineVielfacheDerPackungsgroesseException;

/**
 * Klasse zur Repraesentation von Massengutartikeln.
 * 
 * @author Christof Ferreira Torres
 */
public class Massengutartikel extends Artikel {

	private static final long serialVersionUID = 2184308579779058138L;
	
	// Attribute zur Beschreibung eines Massengutartikels:
	private int packungsgroesse;	

	public Massengutartikel(int artikelnummer, String bezeichnung, double preis, int packungsgroesse, int bestand) throws ArtikelBestandIstKeineVielfacheDerPackungsgroesseException {
		super(artikelnummer, bezeichnung, preis, bestand);
		this.packungsgroesse = packungsgroesse;
		if (bestand % packungsgroesse != 0)
			throw new ArtikelBestandIstKeineVielfacheDerPackungsgroesseException(this, " - in Massengutartikel()'");
	}
	
	public void setBestand(int bestand) throws ArtikelBestandIstKeineVielfacheDerPackungsgroesseException {
		if (bestand % packungsgroesse != 0)
			throw new ArtikelBestandIstKeineVielfacheDerPackungsgroesseException(this, " - in setBestand()'");
		super.setBestand(bestand);
	}
	
	public int getPackungsgroesse() {
		return packungsgroesse;
	}
	
	public String toString() {
		return (super.toString() + "\t Packungsgroesse: " + packungsgroesse);
	}
	
	public boolean equals(Object andererArtikel) {
		if (andererArtikel instanceof Massengutartikel) {
			return (this.getArtikelnummer() == ((Massengutartikel) andererArtikel).getArtikelnummer());
		} else {
			return false;
		}
	}

}
