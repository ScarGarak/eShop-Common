package shop.common.exceptions;

import shop.common.valueobjects.Artikel;

/**
 * Exception zur Signalisierung, dass der Bestand eines Artikel zu klein oder leer ist.
 * (z.B. beim aendern der Stueckzahl eines Artikel in einem Warenkorb).
 * 
 * @author Christof Ferreira Torres
 */
@SuppressWarnings("serial")
public class ArtikelBestandIstZuKleinException extends Exception {

	/**
	 * Konstruktor
	 * 
	 * @param zusatzMsg zusaetzlicher Text fuer die Fehlermeldung
	 */
	public ArtikelBestandIstZuKleinException(String zusatzMsg) {
		super("Der Bestand ist zu klein oder leer" + zusatzMsg);
	}
	
	/**
	 * Konstruktor
	 * 
	 * @param artikel Der Artikel mit dem zu kleinen oder leeren Bestand
	 * @param zusatzMsg zusaetzlicher Text fuer die Fehlermeldung
	 */
	public ArtikelBestandIstZuKleinException(Artikel artikel, String zusatzMsg) {
		super("Der Bestand des Artikels mit der Bezeichnung " + artikel.getBezeichnung() + " und der Artikelnummer " + artikel.getArtikelnummer() 
				+ " ist zu klein oder leer" + zusatzMsg);
	}
	
}
