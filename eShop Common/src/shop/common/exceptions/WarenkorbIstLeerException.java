package shop.common.exceptions;

/**
 * Exception zur Signalisierung, dass der Warenkorb eines Kunden leer ist. 
 * (z.B. beim Kaufen).
 * 
 * @author Christof Ferreira Torres
 */
@SuppressWarnings("serial")
public class WarenkorbIstLeerException extends Exception {

	/**
	 * Konstruktor
	 * 
	 * @param artikel Der Artikel mit dem zu kleinen oder leeren Bestand
	 * @param zusatzMsg zusätzlicher Text für die Fehlermeldung
	 */
	public WarenkorbIstLeerException(String zusatzMsg) {
		super("Der Warenkorb ist leer" + zusatzMsg);
	}
	
}
