package shop.common.valueobjects;

import java.util.Date;

/**
 * Diese Klasse enthaelt alle Attribute und deren Set- und Get-Methoden die fuer
 * ein Ereignis benoetigt werden.
 * @author Migliosi Angelo
 *
 */
public class Ereignis {
	
	private Date datum;
	
	private Artikel artikel;
	private int anzahl;
	
	private Person p;
	
	/**
	 * Konstruktor von Ereignis
	 * @param datum Das Datum an dem das Ereignis stattgefunden hat
	 * @param artikel Das Artikel auf das sich das Ereignis bezieht
	 * @param anzahl Die Bestandsveraenderung
	 * @param p Die Person, die das Ereignis gebildet hat
	 */
	public Ereignis (Date datum, Artikel artikel, int anzahl, Person p){
		this.datum = datum;
		this.artikel = artikel;
		this.anzahl = anzahl;
		this.p = p;
	}
	
	/**
	 * Set Funktion fuer das Datum
	 * @param datum
	 */
	public void setDatum(Date datum){
		this.datum = datum;
	}
	
	/**
	 * Get Funktion fuer das Datum
	 * @return
	 */
	public Date getDatum(){
		return datum;
	}
	
	/**
	 * Set Funktion fuer das Artikel
	 * @param artikel
	 */
	public void setArtikel(Artikel artikel){
		this.artikel = artikel;
	}
	
	/**
	 * Get Funktion fuer das Artikel
	 * @return
	 */
	public Artikel getArtikel(){
		return artikel;
	}
	
	/**
	 * Set Funktion fuer die Bestandsveraenderung/ Zahl
	 * @param anzahl
	 */
	public void setAnzahl(int anzahl){
		this.anzahl = anzahl;
	}
	
	/**
	 * Get Funktion fuer die Bestandsveraenderung/ Zahl
	 * @return
	 */
	public int getAnzahl(){
		return anzahl;
	}
	
	/**
	 * Set Funktion fuer die Person
	 * @param p
	 */
	public void setPerson(Person p){
		this.p = p;
	}
	
	/**
	 * Get Funktion fuer die Person
	 * @return
	 */
	public Person getPerson(){
		return p;
	}

}
