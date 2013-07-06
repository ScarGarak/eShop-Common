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
	
	public abstract void fuegeArtikelEin(Mitarbeiter mitarbeiter, int artikelnummer, String bezeichnung, double preis, int bestand) throws ArtikelExistiertBereitsException;
	
	public abstract void fuegeMassengutartikelEin(Mitarbeiter mitarbeiter, int artikelnummer, String bezeichnung, double preis, int packungsgroesse, int bestand) throws ArtikelExistiertBereitsException, ArtikelBestandIstKeineVielfacheDerPackungsgroesseException;
	
	public abstract void artikelBestandVeraendern(Mitarbeiter mitarbeiter, int artikelnummer, int anzahl) throws ArtikelExistiertNichtException, ArtikelBestandIstKeineVielfacheDerPackungsgroesseException; 
	
	public abstract List<Artikel> gibAlleArtikelSortiertNachArtikelnummer();
	
	public abstract List<Artikel> gibAlleArtikelSortiertNachBezeichnung();
	
	public abstract List<Artikel> sucheArtikel(int artikelnummer);
	
	public abstract List<Artikel> sucheArtikel(String bezeichnung);
	
	public abstract void artikelBearbeiten(int artikelnummer, double preis, String bezeichnung) throws ArtikelExistiertNichtException;
	
	public abstract void entferneArtikel(Mitarbeiter mitarbeiter, int artikelnummer) throws ArtikelExistiertNichtException, IOException;

	/**
	 * Methode zum Speichern des Artikelbestands in einer Datei.
	 * 
	 * @throws IOException
	 */
	public abstract void schreibeArtikel() throws IOException;
	
	// Mitarbeiter-Methoden
	
	/**
	 * Diese Methode ermšglicht es einen Mitarbeiter nach seiner ID
	 * zu suchen.
	 * @param id ID der Mitarbeiter Instanz, die man suchen mšchte
	 * @return Die Mitarbeiter Instanz mit der gegebenen ID.
	 */
	public abstract Mitarbeiter sucheMitarbeiter(int id) throws MitarbeiterExistiertNichtException;

	/**
	 * Diese Methode ermšglicht es um die Mitarbeiterliste einzusehen.
	 * @return Vector mit allen aktuellen Mitarbeiter Instanzen.
	 */
	public abstract Vector<Mitarbeiter> gibAlleMitarbeiter();

	/**
	 * Diese Methode ermšglicht es eine Mitarbeiter Instanz zu lšschen.
	 * @param m Mitarbeiter Instanz zum lšschen.
	 */
	public abstract void mitarbeiterLoeschen(Mitarbeiter m);

	/**
	 * Diese Methode bildet eine neue Mitarbeiter Instanz und fŸgt sie
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
	
	/**
	 * Diese Methode iteriert zuerst durch die Mitarbeiterliste und dann durch die Kundenliste und 
	 * vergleicht die Usernamen.
	 * Beim ersten Treffer wird eine UsernameExistiertBereitsException geworfen.
	 * @param username Username fŸr die neue Person.
	 * @param zusatzMsg ZusŠtliche Informationen.
	 * @throws UsernameExistiertBereitsException
	 */
	public abstract void existiertUsernameSchon(String username, String zusatzMsg) throws UsernameExistiertBereitsException;
	
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
	* Diese Methode ermöglicht es eine Kunden Instanz zu loeschen.
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
	
	public abstract List<WarenkorbArtikel> gibWarenkorb(Kunde kunde); 
	
	public abstract void inDenWarenkorbLegen(Kunde kunde, int artikelnummer, int stueckzahl) throws ArtikelBestandIstZuKleinException, ArtikelExistiertNichtException, ArtikelBestandIstKeineVielfacheDerPackungsgroesseException;
	
	public abstract void ausDemWarenkorbHerausnehmen(Kunde kunde, int artikelnummer) throws ArtikelExistiertNichtException, ArtikelBestandIstKeineVielfacheDerPackungsgroesseException;
	
	public abstract void stueckzahlAendern(Kunde kunde, int warenkorbArtikelnummer, int neueStueckzahl) throws ArtikelBestandIstZuKleinException, ArtikelExistiertNichtException, ArtikelBestandIstKeineVielfacheDerPackungsgroesseException;
	
	public abstract Rechnung kaufen(Kunde kunde) throws IOException, WarenkorbIstLeerException;
	
	public abstract void leeren(Kunde kunde) throws ArtikelBestandIstKeineVielfacheDerPackungsgroesseException;
	
	// Login-Methoden
	
	public abstract Kunde loginVergessen(String name, String strasse, int plz, String wohnort);
	
	/**
	 * Methode zur überprüfung des Logins auf basis des Usernamens und des Passwortes
	 * @param username
	 * @param password
	 * @return Person p
	 */
	public abstract Person pruefeLogin(String username, String password);
	
	// Ereignis Methoden
	
	public abstract void schreibeEreignisse() throws IOException;
	
	public abstract String gibBestandsHistorie(Artikel artikel) throws IOException;
	
	public abstract int[] gibBestandsHistorieDaten(Artikel artikel) throws IOException;
	
	public abstract String gibLogDatei() throws IOException;
	
	/**
	 * Methode zum Beenden einer Verbindung zum Server.
	 * 
	 * @throws IOException
	 */
	public abstract void disconnect() throws IOException;
	
}