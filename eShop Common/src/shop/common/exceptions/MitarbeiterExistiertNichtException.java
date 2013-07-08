package shop.common.exceptions;

/**
 * Diese Exception sagt aus, dass fuer eine gegebene ID keine Mitarbeiter-Instanz existiert.
 * @author Migliosi Angelo
 *
 */
@SuppressWarnings("serial")
public class MitarbeiterExistiertNichtException extends Exception{

	/**
	 * Konstruktor von MitarbeiterExistiertNichtException.
	 * @param id Die ID, fuer die es keinen Mitarbeiter gibt
	 * @param zusatzMsg Zusatz Informationen
	 */
	public MitarbeiterExistiertNichtException(int id, String zusatzMsg) {
		super("Der Mitarbeiter mit der ID '"+id+"' existiert nicht!\n"+ zusatzMsg);
	}
}
