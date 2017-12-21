package Jeu;

/**
 * Abstraction d'un plateau de jeu
 * 
 * @author Alexandre Ludwig et Arnaud Couderc
 *
 */
public abstract class Plateau {
	/**
	 * Les cases d'un plateau
	 */
	private Case[] position;
	
	public Plateau(int nbCases)
	{
		position = new Case[nbCases];	
	}
	/**
	 * Getter : Renvoie la case numero numero
	 * @param numero : numéro de la case choisie
	 * @return
	 */
	public Case getPosition(int numero) {
		return position[numero];
	}
	/**
	 * Setter : Définit la position d'une case
	 * @param numero : numéro de la case désirée
	 * @param pos : case à fixer
	 */
	public void setPosition(int numero, Case pos) {
		this.position[numero] = pos;
	}
}
