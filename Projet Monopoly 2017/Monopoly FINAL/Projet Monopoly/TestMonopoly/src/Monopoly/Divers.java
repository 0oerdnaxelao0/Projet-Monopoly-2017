package Monopoly;

/**
 * Abstraction concernant les cases qui ne rentrent pas dans les cat�gories g�n�riques (Taxes, D�part, Parc gratuit)
 * 
 * @author Alexandre Ludwig et Arnaud Couderc
 */
public interface Divers {
	/**
	 * Abstraction de l'effet de la case
	 * @param j : Joueur �tant aff�ct� par l'effet
	 */
	void activerEffet(JoueurMonopoly j);
}
