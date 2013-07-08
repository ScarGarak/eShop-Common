package shop.common.exceptions;

import shop.common.valueobjects.Artikel;

/**
 * Exception zur Signalisierung, dass ein Artikel bereits existiert. 
 * (z.B. bei einem Einf�gevorgang).
 * 
 * @author Christof Ferreira Torres
 */
@SuppressWarnings("serial")
public class ArtikelExistiertBereitsException extends Exception {

	/**
	 * Konstruktor
	 * 
	 * @param zusatzMsg zus�tzlicher Text f�r die Fehlermeldung
	 */
	public ArtikelExistiertBereitsException(String zusatzMsg) {
		super("Artikel existiert bereits" + zusatzMsg);
	}
	
	/**
	 * Konstruktor
	 * 
	 * @param artikel Der bereits existierende Artikel
	 * @param zusatzMsg zus�tzlicher Text f�r die Fehlermeldung
	 */
	public ArtikelExistiertBereitsException(Artikel artikel, String zusatzMsg) {
		super("Artikel mit Bezeichnung " + artikel.getBezeichnung() + " und Artikelnummer " + artikel.getArtikelnummer() 
				+ " existiert bereits" + zusatzMsg);
	}
	
}
