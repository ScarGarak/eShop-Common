package shop.common.exceptions;

import shop.common.valueobjects.Massengutartikel;

/**
 * Exception zur Signalisierung, dass der Bestand eines Massengutartikels keine Vielfache der Packungsgroesse ist. 
 * (z.B. beim hinzufuegen eines Massengutartikels in den Bestand oder Warenkorb).
 * 
 * @author Christof Ferreira Torres
 */
@SuppressWarnings("serial")
public class ArtikelBestandIstKeineVielfacheDerPackungsgroesseException extends Exception {

	/**
	 * Konstruktor
	 * 
	 * @param zusatzMsg zusaetzlicher Text fuer die Fehlermeldung
	 */
	public ArtikelBestandIstKeineVielfacheDerPackungsgroesseException(String zusatzMsg) {
		super("Der Bestand ist keine Vielfache der Packungsgroesse" + zusatzMsg);
	}
	
	/**
	 * Konstruktor
	 * 
	 * @param artikel Der Massengutartikel mit dem falschen Bestand
	 * @param zusatzMsg zusaetzlicher Text fuer die Fehlermeldung
	 */
	public ArtikelBestandIstKeineVielfacheDerPackungsgroesseException(Massengutartikel artikel, String zusatzMsg) {
		super("Der Bestand des Artikels mit der Bezeichnung " + artikel.getBezeichnung() + " und der Artikelnummer " + artikel.getArtikelnummer() 
				+ " ist keine Vielfache der Packungsgroesse" + zusatzMsg);
	}
	
}
