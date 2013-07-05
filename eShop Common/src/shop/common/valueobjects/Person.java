package shop.common.valueobjects;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Person implements Serializable{

	private int id;
	private String username;
	private String passwort;
	private String name;
	private PersonTyp typ;
	private boolean blockiert;
	
	/**
	 * Konstruktor
	 * @param id Id der Person.
	 * @param username Username der Person.
	 * @param passwort Passwort der Person.
	 * @param name Name der Person.
	 * @param typ Der Typ der Person, d.h. Mitarbeiter oder Kunde.
	 */
	public Person(int id, String username, String passwort, String name, PersonTyp typ){
		this.id = id;
		this.username = username;
		this.passwort = passwort;
		this.name = name;
		this.typ = typ;
		this.blockiert = false;
	}
	
	
	////////// id //////////
	
	/**
	 * Setter f�r "id".
	 * @param id Die ID Nummer der Person.
	 */
	public void setId(int id){
		this.id = id;
	}
	
	/**
	 * Getter f�r "id".
	 * @return Die ID Nummer der Person.
	 */
	public int getId(){
		return this.id;
	}
	
	////////// username //////////
	
	/**
	 * Setter f�r "username".
	 * @param username Der username der Person.
	 */
	public void setUsername(String username){
		this.username = username;
	}
	
	/**
	 * Getter f�r "username".
	 * @return Der username der Person.
	 */
	public String getUsername(){
		return this.username;
	}
	
	////////// passwort //////////
	
	/**
	 * Setter f�r "passwort".
	 * @param passwort Das Passwort der Person.
	 */
	public void setPasswort(String passwort){
		this.passwort = passwort;
	}
	
	/**
	 * Getter f�r "passwort".
	 * @return Das Passwort der Person.
	 */
	public String getPasswort(){
		return this.passwort;
	}
	
	////////// name //////////
	
	/**
	 * Setter f�r "Name".
	 * @param name Den Namen der Person.
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * Getter f�r "name".
	 * @return Den Namen der Person.
	 */
	public String getName(){
		return this.name;
	}
	
	////////// PersonTyp //////////
	
	/**
	 * Setter fuer den "typ".
	 * @param typ Der Typ der Person.
	 */
	public void setPersonTyp(PersonTyp typ){
		this.typ = typ;
	}
	
	/**
	 * Getter fuer "typ".
	 * @param typ
	 */
	public PersonTyp getPersonTyp(){
		return this.typ;
	}
	
	//////////PersonTyp //////////

	/**
	 * Setter fuer den "blockiert".
	 * @param true wenn die Person blockiert werden soll, false wenn nicht.
	 */
	public void setBlockiert(boolean blockiert) {
		this.blockiert = blockiert;
	}
	
	/**
	 * Getter fuer "blockiert".
	 * @param true wenn die Person blockiert ist, false wenn nicht
	 */
	public boolean getBlockiert() {
		return blockiert;
	}
	
}
