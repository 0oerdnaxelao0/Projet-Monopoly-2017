package Monopoly;
/**
 * Classe abstraite carte pour tout type de propri�t�
 * 
 * @author @author Alexandre Ludwig et Arnaud Couderc
 *
 */
public abstract class Carte {
	/**
	 * Type de la carte (Chance ou caisse de communaut�)
	 */
	private String type;
	/**
	 * Texte de la carte (D�placement, T�l�portation, Gain, Perte)
	 */
	private String texte;
	/**
	 * @param type
	 * @param texte
	 */
	public Carte(String type, String texte)
	{
		this.type = type;
		this.texte = texte;
	}

	/**
	 * @return Texte de la carte
	 */
	public String getTexte() {
		return texte;
	}
	/**
	 * @return Type de la carte
	 */

	public String getType() {
		return type;
	}
	/**
	 * M�thode : Abstraction de l'effet d'une carte
	 * @param j : Joueur affect� par la carte
	 * @param p : Partie initialis�e
	 */
	public abstract void Effet(JoueurMonopoly j, Partie p);
}
