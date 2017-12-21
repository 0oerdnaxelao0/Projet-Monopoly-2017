package Monopoly;

/**
 * @author Alexandre Ludwig et Arnaud Couderc
 *
 */
public class CarteLibererJail extends Carte{
	
	/**
	 * @param type
	 * @param texte
	 */
	public CarteLibererJail(String type, String texte)
	{
		super(type, texte);
		
	}
	/* Effet subit par le joueur (ici liberé de prison)
	 * @see Monopoly.Carte#Effet(Monopoly.JoueurMonopoly, Monopoly.Partie)
	 */
	public void Effet(JoueurMonopoly j,Partie p)
	{
		System.out.println(j.getNom() + ' ' + getTexte());
		j.setCarteLibererPrison(true);
	}
}
