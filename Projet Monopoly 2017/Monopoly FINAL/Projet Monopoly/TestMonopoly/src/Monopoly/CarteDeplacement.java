package Monopoly;
/**
 * Classe pour carte chance ou caisse de communaut� qui deplace un joueur
 * 
 * @author Alexandre Ludwig et Arnaud Couderc
 *
 */
public class CarteDeplacement extends Carte
{
	/**
	 * Distance de d�placement
	 */
	private int nbDeplacement;
	
	/**
	 * @param type
	 * @param texte
	 * @param nbDeplacement
	 */
	public CarteDeplacement(String type, String texte, int nbDeplacement) {
		super(type, texte);
		this.nbDeplacement = nbDeplacement;
	}
	
	/** 
	 * M�thode : D�placement du joueur j de nbDeplacement cases
	 * j : Joueur subissant le d�placement
	 * p : partie initialis�e
	 */
	public void Effet(JoueurMonopoly j,Partie p)
	{
		System.out.println(j.getNom() + ' ' + getTexte());
		j.Avancer(nbDeplacement);
	}

}
