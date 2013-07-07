package shop.common.exceptions;

/**
 * Diese Exception sagt aus, dass der gegebene Username schon vergeben ist.
 * @author Migliosi Angelo
 *
 */

@SuppressWarnings("serial")
public class UsernameExistiertBereitsException extends Exception{

	/**
	 * Konstruktor von UsernameExistiertBereitsException.
	 * @param username Der Username der schon vergeben ist.
	 * @param zusatzMsg Zusatz Informationen
	 */
	public UsernameExistiertBereitsException(String username, String zusatzMsg){
		super("Der Username '"+username+"' existiert bereits!"+zusatzMsg);
	}
}
