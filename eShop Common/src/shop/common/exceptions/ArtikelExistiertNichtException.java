package shop.common.exceptions;

import shop.common.valueobjects.Artikel;

/**
 * Exception zur Signalisierung, dass ein Artikel nicht existiert. 
 * (z.B. bei einem Loeschvorgang).
 * 
 * @author Christof Ferreira Torres
 */
@SuppressWarnings("serial")
public class ArtikelExistiertNichtException extends Exception {

	/**
	 * Konstruktor
	 * 
	 * @param zusatzMsg zusaetzlicher Text fuer die Fehlermeldung
	 */
	public ArtikelExistiertNichtException(String zusatzMsg) {
		super("Der Artikel existiert nicht" + zusatzMsg);
	}
	
	/**
	 * Konstruktor
	 * 
	 * @param artikel Der nicht existierende Artikel
	 * @param zusatzMsg zusaetzlicher Text fuer die Fehlermeldung
	 */
	public ArtikelExistiertNichtException(Artikel artikel, String zusatzMsg) {
		super("Der Artikel mit der Artikelnummer " + artikel.getArtikelnummer() + " und der Bezeichnung " + 
				artikel.getBezeichnung() + " existiert nicht" + zusatzMsg);
	}
	
	/**
	 * Konstruktor
	 * 
	 * @param artikelnummer Die Artikelnummer des nicht existierenden Artikels
	 * @param zusatzMsg zusaetzlicher Text fuer die Fehlermeldung
	 */
	public ArtikelExistiertNichtException(int artikelnummer, String zusatzMsg) {
		super("Der Artikel mit der Artikelnummer " + artikelnummer + " existiert nicht" + zusatzMsg);
	}
	
	/**
	 * Konstruktor
	 * 
	 * @param bezeichnung Die Bezeichnung des nicht existierenden Artikels
	 * @param zusatzMsg zusaetzlicher Text fuer die Fehlermeldung
	 */
	public ArtikelExistiertNichtException(String bezeichnung, String zusatzMsg) {
		super("Der Artikel mit der Bezeichnung " + bezeichnung + " existiert nicht" + zusatzMsg);
	}
	
}
