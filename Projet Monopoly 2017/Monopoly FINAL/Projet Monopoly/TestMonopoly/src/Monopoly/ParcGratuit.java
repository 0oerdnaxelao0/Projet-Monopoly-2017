package Monopoly;
import Exceptions.*;
import Jeu.Case;
//import Exceptions.*;
/**
 * @author Alexandre Ludwig et Arnaud Couderc
 */
public class ParcGratuit extends Case implements Divers{
	/**
	 * Montant de la cagnotte
	 */
	private int cagnotte;

	public ParcGratuit()
	{
		super("Parc gratuit",10, 10, 20);
		this.cagnotte = 0;
	}
	/**
	 * Getter : Renvoie le montant de la cagnotte
	 * @return cagnotte
	 */
	public int getCagnotte() {
		return cagnotte;
	}
	/**
	 * Setter : Définit le montant de la cagnotte
	 * @param cagnotte : nouveau montant
	 */
	public void setCagnotte(int cagnotte) {
		this.cagnotte += cagnotte;
	}
	/*
	 * Effet que le joueur subit lorsqu'il arrive sur la case parc gratuit
	 * @see Monopoly.Divers#activerEffet(Monopoly.JoueurMonopoly)
	 */
	public void activerEffet(JoueurMonopoly j)
	{
		try { 
			j.setArgentPossede(j.getArgentPossede() + getCagnotte()); //Il obtient la cagnotte
		}
		catch(JoueurRuineException e) {e.printStackTrace();}
		setCagnotte(0); //Et la cagnotte est réinitialisée à 0
		System.out.println("Vous recoltez la cagnotte, " + getCagnotte() + " €.");
	}
}
