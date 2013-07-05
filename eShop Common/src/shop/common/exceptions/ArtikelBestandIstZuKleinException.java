package shop.common.exceptions;

import shop.common.valueobjects.Artikel;

/**
 * Exception zur Signalisierung, dass der Bestand eines Artikel zu klein oder leer ist.
 * (z.B. beim �ndern der St�ckzahl eines Artikel in einem Warenkorb).
 * 
 * @author Christof Ferreira Torres
 * @version 1.0.0
 */
@SuppressWarnings("serial")
public class ArtikelBestandIstZuKleinException extends Exception {

	/**
	 * Konstruktor
	 * 
	 * @param artikel Der Artikel mit dem zu kleinen oder leeren Bestand
	 * @param zusatzMsg zus�tzlicher Text f�r die Fehlermeldung
	 */
	public ArtikelBestandIstZuKleinException(Artikel artikel, String zusatzMsg) {
		super("Der Bestand des Artikels mit der Bezeichnung " + artikel.getBezeichnung() + " und der Artikelnummer " + artikel.getArtikelnummer() 
				+ " ist zu klein oder leer" + zusatzMsg);
	}
	
}
