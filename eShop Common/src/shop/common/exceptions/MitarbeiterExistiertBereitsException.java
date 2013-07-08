package shop.common.exceptions;

import shop.common.valueobjects.Mitarbeiter;

/**
 * Diese Exception sagt aus, dass der Mitarbeiter bereits existiert.
 * @author Migliosi Angelo
 *
 */
@SuppressWarnings("serial")
public class MitarbeiterExistiertBereitsException extends Exception{
	
	/**
	 * Konstruktor von MitarbeiterExistiertBereitsException.
	 * @param zusatzMsg Zusatz Informationen
	 */
	public MitarbeiterExistiertBereitsException(String zusatzMsg) {
		super("Dieser Mitarbeiter existiert bereits!\n"+ zusatzMsg);
	}
	
	/**
	 * Konstruktor von MitarbeiterExistiertBereitsException.
	 * @param m Die Instanz des Mitarbeiters, um den es sich handelt
	 * @param zusatzMsg Zusatz Informationen
	 */
	public MitarbeiterExistiertBereitsException(Mitarbeiter m, String zusatzMsg) {
		super("Der Mitarbeiter mit der ID '"+m.getId()+"' existiert bereits!\n"+ zusatzMsg);
	}

}
