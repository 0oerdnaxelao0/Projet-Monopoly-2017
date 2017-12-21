package Monopoly;
import Jeu.Case;
/**
 * Classe pour les cases Caisse de communauté
 * 
 * @author Alexandre Ludwig et Arnaud Couderc
 * @see CaseCarte
 *
 */
public class CaisseCommunaute extends Case implements CaseCarte{

	public CaisseCommunaute(int x, int y, int position)
	{
		super("Caisse de communauté", x, y, position);
	}

	/**
	 * Pioche une carte d'un paquet de carte mélangé construit dans partie
	 * @param j : Joueur affecté par l'effet de la carte
	 * @param p : partie initialisée
	 * @see Monopoly.CaseCarte#piocherCarte(Monopoly.JoueurMonopoly, Monopoly.Partie)
	 */
	public void piocherCarte(JoueurMonopoly j, Partie p) {
			p.getPaquetCaisse().tirerCarte(j, p);
	}
}
