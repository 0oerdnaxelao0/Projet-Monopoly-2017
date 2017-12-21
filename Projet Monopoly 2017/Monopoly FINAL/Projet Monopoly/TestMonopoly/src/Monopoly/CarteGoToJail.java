package Monopoly;

/**
 * @author Alexandre Ludwig et Arnaud Couderc
 *
 */
public class CarteGoToJail extends Carte{
	/**
	 * Carte Va en prison
	 */
	public CarteGoToJail(String type, String texte)
	{
		super(type, texte);	
	}
	/**
	* Effet subit par le joueur (ici va en prison)
	* @see Monopoly.Carte#Effet(Monopoly.JoueurMonopoly, Monopoly.Partie)
	*/
	@Override
	public void Effet(JoueurMonopoly j, Partie p) {
		System.out.println(j.getNom() + "a pioché une carte prison, donc va en prison, sale criminel d'ordure");
		j.setNumPosition(10);
		j.setEnPrison(true);	
	}
}
