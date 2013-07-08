package shop.common.interfaces;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import shop.common.exceptions.ArtikelBestandIstKeineVielfacheDerPackungsgroesseException;
import shop.common.exceptions.ArtikelBestandIstZuKleinException;
import shop.common.exceptions.ArtikelExistiertBereitsException;
import shop.common.exceptions.ArtikelExistiertNichtException;
import shop.common.exceptions.KundeExistiertBereitsException;
import shop.common.exceptions.KundeExistiertNichtException;
import shop.common.exceptions.MitarbeiterExistiertBereitsException;
import shop.common.exceptions.MitarbeiterExistiertNichtException;
import shop.common.exceptions.UsernameExistiertBereitsException;
import shop.common.exceptions.WarenkorbIstLeerException;
import shop.common.valueobjects.Artikel;
import shop.common.valueobjects.Kunde;
import shop.common.valueobjects.Mitarbeiter;
import shop.common.valueobjects.MitarbeiterFunktion;
import shop.common.valueobjects.Person;
import shop.common.valueobjects.Rechnung;
import shop.common.valueobjects.WarenkorbArtikel;

public interface ShopInterface {

	// Artikel-Methoden
	
	/**
	 * Methode zum Einfügen eines neuen Artikels in den Bestand. 
	 * Wenn der Artikel bereits im Bestand ist, wird der Bestand nicht geändert.
	 * 
	 * @param mitarbeiter Mitarbeiter der den Artikel in den Bestand einfügen will
	 * @param artikelnummer Artikelnummer des neuen Artikels
	 * @param bezeichnung Bezeichnung des neuen Artikels
	 * @param preis Preis des neuen Artikels
	 * @param bestand Bestand des neuen Artikels
	 * @throws ArtikelExistiertBereitsException
	 */
	public abstract void fuegeArtikelEin(Mitarbeiter mitarbeiter, int artikelnummer, String bezeichnung, double preis, int bestand) throws ArtikelExistiertBereitsException;
	
	/**
	 * Methode zum Einfügen eines neuen Massengutartikels in den Bestand. 
	 * Wenn der Massengutartikel bereits im Bestand ist, wird der Bestand nicht geändert.
	 * 
	 * @param mitarbeiter Mitarbeiter der den Massengutartikel in den Bestand einfügen will
	 * @param artikelnummer Artikelnummer des neuen Massengutartikels
	 * @param bezeichnung Bezeichnung des neuen Massengutartikels
	 * @param preis Preis des neuen Massengutartikels
	 * @param packungsgroesse Packungsgröße des neuen Massengutartikels
	 * @param bestand Bestand des neuen Massengutartikels
	 * @throws ArtikelExistiertBereitsException
	 * @throws ArtikelBestandIstKeineVielfacheDerPackungsgroesseException
	 */
	public abstract void fuegeMassengutartikelEin(Mitarbeiter mitarbeiter, int artikelnummer, String bezeichnung, double preis, int packungsgroesse, int bestand) throws ArtikelExistiertBereitsException, ArtikelBestandIstKeineVielfacheDerPackungsgroesseException;
	
	/**
	 * Methode zum verändern des Bestands eines Artikels.
	 * 
	 * @param mitarbeiter Mitarbeiter der den Bestand eines Artikels verändern will
	 * @param artikelnummer Artikelnummer des zu verändernden Artikels
	 * @param anzahl Anzahl des neuen Bestands
	 * @throws ArtikelExistiertNichtException
	 * @throws ArtikelBestandIstKeineVielfacheDerPackungsgroesseException
	*/
	public abstract void artikelBestandVeraendern(Mitarbeiter mitarbeiter, int artikelnummer, int anzahl) throws ArtikelExistiertNichtException, ArtikelBestandIstKeineVielfacheDerPackungsgroesseException; 
	
	/**
	 * Methode, die eine Liste aller im Bestand befindlichen Artikel, 
	 * nach ihrer Artikelnummer sortiert, zurückgibt.
	 * 
	 * @return Liste aller Artikel sortiert nach Artikelnummer
	 */
	public abstract List<Artikel> gibAlleArtikelSortiertNachArtikelnummer();
	
	/**
	 * Methode, die eine Liste aller im Bestand befindlichen Artikel, 
	 * nach ihrer Bezeichnung sortiert, zurückgibt.
	 * 
	 * @return Liste aller Artikel sortiert nach Bezeichnung
	 */
	public abstract List<Artikel> gibAlleArtikelSortiertNachBezeichnung();
	
	/**
	 * Methode zum Suchen von Artikeln anhand der Artikelnummer. Es wird eine Liste von Artikeln
	 * zurückgegeben, die alle Artikel die Artikelnummer enthalten.
	 * 
	 * @param artikelnummer Artikelnummer des gesuchten Artikels
	 * @return Liste der gefundenen Artikel (evtl. leer)
	 */
	public abstract List<Artikel> sucheArtikel(int artikelnummer);
	
	/**
	 * Methode zum Suchen von Artikeln anhand der Bezeichnung. Es wird eine Liste von Artikeln
	 * zurückgegeben, die alle Artikel die Bezeichnung enthalten.
	 * 
	 * @param bezeichnung Bezeichnung des gesuchten Artikels
	 * @return Liste der gefundenen Artikel (evtl. leer)
	 */
	public abstract List<Artikel> sucheArtikel(String bezeichnung);
	
	/**
	 * Methode zum bearbeiten eines Artikels.
	 * 
	 * @param artikelnumme Artikelnummer des Artikels
	 * @param preis Preis des Artikels
	 * @param bezeichnung Bezeichnung des Artikels
	 * @throws ArtikelExistiertNichtException
	*/
	public abstract void artikelBearbeiten(int artikelnummer, double preis, String bezeichnung) throws ArtikelExistiertNichtException;
	
	/**
 	 * Methode zum Entfernen eines Artikels aus dem Bestand.
	 * 
	 * @param mitarbeiter Mitarbeiter der den Artikel aus dem Bestand entfernen will
	 * @param artikelnummer Artikelnummer des zu entfernenden Artikels
	 * @throws ArtikelExistiertNichtException
	 * @throws IOException
 	 */
	public abstract void entferneArtikel(Mitarbeiter mitarbeiter, int artikelnummer) throws ArtikelExistiertNichtException, IOException;

	/**
	 * Methode zum Speichern des Artikelbestands in einer Datei.
	 * 
	 * @throws IOException
	 */
	public abstract void schreibeArtikel() throws IOException;
	
	// Mitarbeiter-Methoden
	
	/**
	 * Diese Methode ermöglicht es einen Mitarbeiter nach seiner ID
	 * zu suchen.
	 * @param id ID der Mitarbeiter Instanz, die man suchen möchte
	 * @return Die Mitarbeiter Instanz mit der gegebenen ID.
	 */
	public abstract Mitarbeiter sucheMitarbeiter(int id) throws MitarbeiterExistiertNichtException;

	/**
	 * Diese Methode ermöglicht es um die Mitarbeiterliste einzusehen.
	 * @return Vector mit allen aktuellen Mitarbeiter Instanzen.
	 */
	public abstract Vector<Mitarbeiter> gibAlleMitarbeiter();

	/**
	 * Diese Methode ermöglicht es eine Mitarbeiter Instanz zu löschen.
	 * @param m Mitarbeiter Instanz zum löschen.
	 */
	public abstract void mitarbeiterLoeschen(Mitarbeiter m);

	/**
	 * Diese Methode bildet eine neue Mitarbeiter Instanz und fügt sie
	 * zur Mitarbeiterverwaltung hinzu.
	 * @param name Name des neuen Mitarbeiters
	 * @throws MitarbeiterExistiertBereitsException
	 * @throws UsernameExistiertBereitsException 
	 */
	public abstract void fuegeMitarbeiterHinzu(String username, String passwort, String name, MitarbeiterFunktion funktion, double gehalt) throws MitarbeiterExistiertBereitsException, UsernameExistiertBereitsException;

	/**
	 * Diese Methode schreibt alle Mitarbeiterdaten in die Datenquelle.
	 * @throws IOException
	 */
	public abstract void schreibeMitarbeiter() throws IOException;
	
	/**
	 * Diese Methode ist zum bearbeiten von Mitarbeitern.
	 * @param id
	 * @param passwort
	 * @param name
	 * @param funktion
	 * @param gehalt
	 * @param blockiert
	 * @throws MitarbeiterExistiertNichtException
	 */
	public abstract void mitarbeiterBearbeiten(int id, String passwort, String name, MitarbeiterFunktion funktion, double gehalt, boolean blockiert) throws MitarbeiterExistiertNichtException;
	
	// Kunden-Methoden

	/**
	* Diese Methode ermoeglicht es einen Kunden nach seiner ID
	* zu suchen.
	* @param id der Kunden Instanz, die man suchen moechte
	* @return Die Kunden Instanz mit der gegebenen ID.
	*/
	public abstract Kunde sucheKunde(int id) throws KundeExistiertNichtException;

	/**
	* Diese Methode ermoeglicht es um die Kundenliste einzusehen.
	* @return Vector mit alle aktuellen Kunden Instanzen.
	*/
	public abstract Vector<Kunde> gibAlleKunden();

	/**
	* Diese Methode ermˆglicht es eine Kunden Instanz zu loeschen.
	* @param k Kunde Instanz zum loeschen.
	*/
	public abstract void kundenLoeschen(Kunde k);

	/**
	 * Diese Methode ist zum bearbeiten einer Kunden Instanz zustaendig.
	 * @param id
	 * @param passwort
	 * @param name
	 * @param strasse
	 * @param plz
	 * @param wohnort
	 * @param blockiert
	 * @throws KundeExistiertNichtException
	 */
	public abstract void kundenBearbeiten(int id, String passwort, String name, String strasse, int plz, String wohnort, boolean blockiert) throws KundeExistiertNichtException;
	
	/**
	 * Diese Methode bidet eine neue Kunden Instanz und fuegt sie
	 * zur Kundenverwaltung hinzu.
	 * @param name Name des neuen Kunden
	 * @throws KundeExistiertBereitsException
	 * @throws UsernameExistiertBereitsException 
	 */
	public abstract void fuegeKundenHinzu(String username, String passwort, String name, String strasse, int plz, String wohnort) throws KundeExistiertBereitsException, UsernameExistiertBereitsException;

	/**
 	* Diese Methode ermoeglicht es den "schreibe" befehl der KundenVerwaltung zu triggern.
 	* @throws IOException
 	*/
	public abstract void schreibeKunden() throws IOException;
	
	// Warenkorb-Methoden
	
	/**
	 * Methode, die eine Liste aller im Warenkorb befindlichen Artikel zurückgibt.
	 * 
	 * @return Liste aller Warenkorb Artikel des Kunden
	 */
	public abstract List<WarenkorbArtikel> gibWarenkorb(Kunde kunde); 
	
	/**
	 * Methode zum in den Warenkorb legen eines Artikels anhand eines Kunden.
	 * 
	 * @param kunde Kunde der den Artikel in seinen Warenkorb legen will
	 * @param artikelnummer Artikelnummer des Artikels der in den Warenkorb zu legen ist
	 * @param stueckzahl Stückzahl des Artikels
	 * @throws ArtikelBestandIstZuKleinException
	 * @throws ArtikelExistiertNichtException
	 * @throws ArtikelBestandIstKeineVielfacheDerPackungsgroesseException
	 */
	public abstract void inDenWarenkorbLegen(Kunde kunde, int artikelnummer, int stueckzahl) throws ArtikelBestandIstZuKleinException, ArtikelExistiertNichtException, ArtikelBestandIstKeineVielfacheDerPackungsgroesseException;
	
	/**
	 * Methode um einen Artikel aus dem Warenkorb heraus zu nehmen anhand eines Kunden.
	 * 
	 * @param kunde Kunde der den Artikel aus seinem Warenkorb herausnehmen will
	 * @param artikelnummer Artikelnummer eines Artikels der aus dem Warenkorb heraus zu nehmen ist
	 * @throws ArtikelExistiertNichtException
	 * @throws ArtikelBestandIstKeineVielfacheDerPackungsgroesseException
	 */
	public abstract void ausDemWarenkorbHerausnehmen(Kunde kunde, int artikelnummer) throws ArtikelExistiertNichtException, ArtikelBestandIstKeineVielfacheDerPackungsgroesseException;
	
	/**
	 * Methode um die Stückzahl eines Warenkorb Artikels im Warenkorb eines Kunden zu ändern.
	 * 
	 * @param kunde Kunde der die Stückzahl des Warenkorb Artikels ändern will
	 * @param warenkorbArtikelnummer Warenkorb Artikelnummer des Warenkorb Artikels dessen Stückzahl zu ändern ist
	 * @param neueStueckzahl NeueStückzahl des Warenkorb Artikels
	 * @throws ArtikelBestandIstZuKleinException
	 * @throws ArtikelExistiertNichtException
	 * @throws ArtikelBestandIstKeineVielfacheDerPackungsgroesseException
	 */
	public abstract void stueckzahlAendern(Kunde kunde, int warenkorbArtikelnummer, int neueStueckzahl) throws ArtikelBestandIstZuKleinException, ArtikelExistiertNichtException, ArtikelBestandIstKeineVielfacheDerPackungsgroesseException;
	
	/**
	 * Methode zum Kaufen von Artikeln anhand eines Kunden. Es wird eine Rechnung
	 * zurückgegeben.
	 * 
	 * @param kunde Kunde der die einzelnen Artikel, die sich in seinem Warenkorb befinden, kaufen will
	 * @return Rechnung
	 * @throws IOException
	 * @throws WarenkorbIstLeerException
	 */
	public abstract Rechnung kaufen(Kunde kunde) throws IOException, WarenkorbIstLeerException;
	
	/**
	 * Methode zum Leeren aller Artikeln aus dem Warenkorb eines Kunden. 
	 * 
	 * @param kunde Kunde der alle Artikel, die sich in seinem Warenkorb befinden, entfernen will
	 * @throws ArtikelBestandIstKeineVielfaceDerPackungsgroesseException
	 */
	public abstract void leeren(Kunde kunde) throws ArtikelBestandIstKeineVielfacheDerPackungsgroesseException;
	
	// Login-Methoden
	
	public abstract Kunde loginVergessen(String name, String strasse, int plz, String wohnort);
	
	/**
	 * Methode zur ¸berpr¸fung des Logins auf basis des Usernamens und des Passwortes
	 * @param username
	 * @param password
	 * @return Person p
	 */
	public abstract Person pruefeLogin(String username, String password);
	
	// Ereignis Methoden
	
	/**
	 * Speichert alle Ereignisse.
	 * @throws IOException
	 */
	public abstract void schreibeEreignisse() throws IOException;
	
	/**
	 * Diese Methode gibt ein Integer Array von 30 Zahlen zurueck, die die Bestaende der letzten 30 Tage
	 * des Artikels mit der angegebenen Artikelnummer repräsentieren.
	 * @param artikelnummer
	 * @return Die Bestaende der letzten 30 Tage
	 * @throws IOException
	 * @throws ArtikelExistiertNichtException
	 */
	public abstract int[] gibBestandsHistorieDaten(int artikelnummer) throws IOException, ArtikelExistiertNichtException;
	
	/**
	 * Diese Methode liest die gesamte Logdatei und gibt sie als ein String zurueck.
	 * @return
	 * @throws IOException
	 */
	public abstract String gibLogDatei() throws IOException;
	
	/**
	 * Methode zum Beenden einer Verbindung zum Server.
	 * 
	 * @throws IOException
	 */
	public abstract void disconnect() throws IOException;
	
}
