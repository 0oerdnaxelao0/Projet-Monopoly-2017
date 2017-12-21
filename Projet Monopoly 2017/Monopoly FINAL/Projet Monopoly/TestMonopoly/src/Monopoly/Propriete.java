package Monopoly;

/**
 * Abstraction concernant les propriétés
 * 
 * @author Alexandre Ludwig et Arnaud Couderc
 *
 */
public interface Propriete {
	/**
	 * Getter : retourne le prix de la propriété
	 * @return prix
	 */
	int getPrix();
	/**
	 * Getter : retourne le loyer de la propriété
	 * @return loyer
	 */
	int getLoyer();
	/**
	 * Getter : retourne le nom de la propriété
	 * @return nom
	 */
	String getNom();
	/**
	 * Getter : retourne le propriétaire
	 * @return proprietaire
	 */
	JoueurMonopoly getProprietaire();
	/**
	 * Getter : définit le propriétaire
	 * @param j : futur propriétaire
	 */
	void setProprietaire(JoueurMonopoly j);
	/**
	 * Menu affiché quant le joueur arrive sur la propriété
	 * @param j : joueur arrivant sur la propriété
	 */
	void Menu(JoueurMonopoly j);
}
