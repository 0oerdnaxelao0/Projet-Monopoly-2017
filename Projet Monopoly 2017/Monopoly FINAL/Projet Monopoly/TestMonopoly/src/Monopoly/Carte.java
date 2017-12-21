package Monopoly;
/**
 * Classe abstraite carte pour tout type de propriété
 * 
 * @author @author Alexandre Ludwig et Arnaud Couderc
 *
 */
public abstract class Carte {
	/**
	 * Type de la carte (Chance ou caisse de communauté)
	 */
	private String type;
	/**
	 * Texte de la carte (Déplacement, Téléportation, Gain, Perte)
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
	 * Méthode : Abstraction de l'effet d'une carte
	 * @param j : Joueur affecté par la carte
	 * @param p : Partie initialisée
	 */
	public abstract void Effet(JoueurMonopoly j, Partie p);
}
