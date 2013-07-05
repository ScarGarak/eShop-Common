package shop.common.exceptions;

import shop.common.valueobjects.Kunde;

@SuppressWarnings("serial")
public class KundeExistiertBereitsException extends Exception {

	public KundeExistiertBereitsException(Kunde k, String zusatzMsg) {
		super("Der Kunde mit der ID '"+k.getId()+"' existiert bereits!\n"+ zusatzMsg);
	}
	
}
