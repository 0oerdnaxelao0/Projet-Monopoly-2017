package Monopoly;

import Exceptions.JoueurRuineException;

/**
 * @author Alexandre Ludwig et Arnaud Couderc
 */
public class CarteGainPerte extends Carte{

	/**
	 * Montant du gain ou de la perte (négatif si perte)
		*/
	private int montant;
	/**
	 * @param type
	 * @param texte
	 * @param montant
	 */
	public CarteGainPerte(String type, String texte, int montant) {
		super(type, texte);
		this.montant = montant;
	}
	/**
	 * @return Montant du gain ou de la perte
	 */
	public int getMontant() {
		return montant;
	}
	/**
	 * @param montant
	 */
	public void setMontant(int montant) {
		this.montant = montant;
	}
	/* Effet subit par le joueur (ici gain ou perte d'argent)
	 * @see Monopoly.Carte#Effet(Monopoly.JoueurMonopoly, Monopoly.Partie)
	 */
	@Override
	public void Effet(JoueurMonopoly j, Partie p) {
		if (montant < 0)
		{
		System.out.println(j.getNom() + ' ' + getTexte() + ' ' + j.getNom() + ' ' + "a perdu"+ ' ' + (-montant) + "€");
		((ParcGratuit)p.getPlateau().getPosition(20)).setCagnotte((-montant) + ((ParcGratuit)p.getPlateau().getPosition(20)).getCagnotte());
		System.out.println("Il y a maintenant " + ((ParcGratuit)p.getPlateau().getPosition(20)).getCagnotte() + " € au parc Gratuit.");
		}
		else 
			System.out.println(j.getNom() + ' ' + getTexte() + ' ' +j.getNom() + ' ' + "a gagne"+ ' ' + montant + "€");
		try {
			j.setArgentPossede(j.getArgentPossede() + montant);
		} catch (JoueurRuineException e) {
			e.printStackTrace();
		}
		
	}

	
}
