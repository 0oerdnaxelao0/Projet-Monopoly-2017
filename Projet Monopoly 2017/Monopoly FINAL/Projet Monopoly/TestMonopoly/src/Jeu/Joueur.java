package Jeu;
import Exceptions.*;
/**
 * Abstraction d'un joueur
 * 
 * @author Alexandre Ludwig et Arnaud Couderc
 *
 */
public abstract class Joueur {
	/**
	 * Nom du joueur
	 */
	private String nom;
	/**
	 * Argent du joueur
	 */
	private int argentPossede;
	/**
	 * Pion du joueur
	 */
	private String pion;

	public Joueur (String nom, int argentPossede, String pion)
	{
		this.nom = nom;
		this.pion = pion;
		try { 
			setArgentPossede(argentPossede);
		}
		catch(JoueurRuineException e){}
	}

	/**
	 * Getter : Renvoie le nom du joueur
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * Setter : Définit le nom du joueur
	 * @param nom : futur nom du joueur
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * Getter : Renvoie l'argent que lejoueur possède
	 * @return argentPossede
	 */
	public int getArgentPossede() {
		return argentPossede;
	}
	/**
	 * Setter : Définit l'argent que le joueur possède
	 * @param argentPossede : l'argent que le joueur possède désormais
	 * @throws JoueurRuineException : si il a plus de thunes
	 */
	public void setArgentPossede(int argentPossede) throws JoueurRuineException{
		this.argentPossede = argentPossede;
		if (this.argentPossede <= 0)
			throw new JoueurRuineException(this.nom + " est ruine. Pour lui, la partie est terminee.");
	}
	/**
	 * Getter : Renvoie le pion du joueur
	 * @return pion
	 */
	public String getPion() {
		return pion;
	}
	/**
	 * Setter : Définit le pion du joueur
	 * @param pion : futur pion du joueur
	 */
	public void setPion(String pion) {
		this.pion = pion;
	}
	
	/* 
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return "Nom : " + this.nom + "\nArgent Possede : " + this.argentPossede + "\nPion : " + this.pion;
	}
	
	/**
	 * @param o : objet comparé
	 */
	public boolean equals(Object o)
	{
		if (o == this)
			return true;
		if(o == null) 
			return false;
		if (getClass() == o.getClass())
		{
			Joueur j = (Joueur) o;
			return this.pion.equals(j.pion);
		}
		return false;
	}
}
