package Monopoly;

/**
 * Abstraction concernant les cases qui ne rentrent pas dans les catégories génériques (Taxes, Départ, Parc gratuit)
 * 
 * @author Alexandre Ludwig et Arnaud Couderc
 */
public interface Divers {
	/**
	 * Abstraction de l'effet de la case
	 * @param j : Joueur étant affécté par l'effet
	 */
	void activerEffet(JoueurMonopoly j);
}
