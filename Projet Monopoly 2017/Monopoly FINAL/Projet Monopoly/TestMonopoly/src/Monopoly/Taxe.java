package Monopoly;
import Exceptions.JoueurRuineException;
import Jeu.*;
/**
 * @author Alexandre Ludwig et Arnaud Couderc
 *
 */
public class Taxe extends Case implements Divers{
	/**
	 * Montant de la taxe
	 */
	private int montant;

	public Taxe(String nom, int x, int y, int position, int montant) {
		super(nom, x, y, position);
		this.montant = montant;
	}
	/**
	 * Getter : Renvoie le montant de la taxe
	 * @return montant
	 */
	public int getMontant() {
		return this.montant;
	}
	/**
	 * Définit le montant de la taxe
	 * @param montant
	 */
	public void setMontant(int montant) {
		this.montant = montant;
	}
	
	/* (non-Javadoc)
	 * @see Jeu.Case#toString()
	 */
	public String toString()
	{
		return super.toString() + "\nMontant :" + this.montant;
	}
	
	/**
	 * @param TA
	 * @return
	 */
	public boolean equals(Object o)
	{
		return super.equals(o);
	}
	
	/* (non-Javadoc)
	 * @see Monopoly.Divers#activerEffet(Monopoly.JoueurMonopoly)
	 */
	public void activerEffet(JoueurMonopoly j) {
		try { 
			j.setArgentPossede(j.getArgentPossede() - getMontant());
		}
		catch(JoueurRuineException e){e.printStackTrace();}
		System.out.println("Vous arrivez sur la case " + getNom() + ". Vous payer donc " + getMontant() + " €.");
	}
}
