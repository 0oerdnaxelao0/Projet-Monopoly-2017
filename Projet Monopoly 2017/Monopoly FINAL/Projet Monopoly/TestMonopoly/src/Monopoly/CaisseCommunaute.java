package Monopoly;
import Jeu.Case;
/**
 * Classe pour les cases Caisse de communaut�
 * 
 * @author Alexandre Ludwig et Arnaud Couderc
 * @see CaseCarte
 *
 */
public class CaisseCommunaute extends Case implements CaseCarte{

	public CaisseCommunaute(int x, int y, int position)
	{
		super("Caisse de communaut�", x, y, position);
	}

	/**
	 * Pioche une carte d'un paquet de carte m�lang� construit dans partie
	 * @param j : Joueur affect� par l'effet de la carte
	 * @param p : partie initialis�e
	 * @see Monopoly.CaseCarte#piocherCarte(Monopoly.JoueurMonopoly, Monopoly.Partie)
	 */
	public void piocherCarte(JoueurMonopoly j, Partie p) {
			p.getPaquetCaisse().tirerCarte(j, p);
	}
}
