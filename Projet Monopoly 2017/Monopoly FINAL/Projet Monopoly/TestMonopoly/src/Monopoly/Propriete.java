package Monopoly;

/**
 * Abstraction concernant les propri�t�s
 * 
 * @author Alexandre Ludwig et Arnaud Couderc
 *
 */
public interface Propriete {
	/**
	 * Getter : retourne le prix de la propri�t�
	 * @return prix
	 */
	int getPrix();
	/**
	 * Getter : retourne le loyer de la propri�t�
	 * @return loyer
	 */
	int getLoyer();
	/**
	 * Getter : retourne le nom de la propri�t�
	 * @return nom
	 */
	String getNom();
	/**
	 * Getter : retourne le propri�taire
	 * @return proprietaire
	 */
	JoueurMonopoly getProprietaire();
	/**
	 * Getter : d�finit le propri�taire
	 * @param j : futur propri�taire
	 */
	void setProprietaire(JoueurMonopoly j);
	/**
	 * Menu affich� quant le joueur arrive sur la propri�t�
	 * @param j : joueur arrivant sur la propri�t�
	 */
	void Menu(JoueurMonopoly j);
}
