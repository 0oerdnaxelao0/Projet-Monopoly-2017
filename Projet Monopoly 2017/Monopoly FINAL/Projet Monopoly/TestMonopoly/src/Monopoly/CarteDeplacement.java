package Monopoly;
/**
 * Classe pour carte chance ou caisse de communauté qui deplace un joueur
 * 
 * @author Alexandre Ludwig et Arnaud Couderc
 *
 */
public class CarteDeplacement extends Carte
{
	/**
	 * Distance de déplacement
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
	 * Méthode : Déplacement du joueur j de nbDeplacement cases
	 * j : Joueur subissant le déplacement
	 * p : partie initialisée
	 */
	public void Effet(JoueurMonopoly j,Partie p)
	{
		System.out.println(j.getNom() + ' ' + getTexte());
		j.Avancer(nbDeplacement);
	}

}
