package Monopoly;

/**
 * @author Alexandre Ludwig et Arnaud Couderc
 *
 */
public interface CaseCarte {
	/**
	 * Abstraction concernant la pioche de carte
	 * @param j : Joueur qui pioche la carte
	 * @param p : partie initialis�e
	 */
	void piocherCarte(JoueurMonopoly j, Partie p);
}
