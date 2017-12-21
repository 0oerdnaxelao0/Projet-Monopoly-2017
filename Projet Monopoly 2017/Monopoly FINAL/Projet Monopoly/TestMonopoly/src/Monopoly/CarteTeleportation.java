package Monopoly;

/**
 * @author Alexandre Ludwig et Arnaud Couderc
 *
 */
public class CarteTeleportation extends Carte{

	/**
	 * Position de la Téléportation
	 */
	private int position;
	/**
	 * @param type
	 * @param texte
	 * @param position
	 */
	public CarteTeleportation(String type, String texte, int position) {
		super(type, texte);
		this.position = position;
	}
	/* Effet subit par le joueur (ici Téléportation à position
	 * @see Monopoly.Carte#Effet(Monopoly.JoueurMonopoly, Monopoly.Partie)
	 */
	public void Effet(JoueurMonopoly j, Partie p)
	{
		System.out.println(getTexte());
		j.setNumPosition(position);
	}

}
