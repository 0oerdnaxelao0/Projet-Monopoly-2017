package Monopoly;
import Jeu.Case;
/**
 * Classe pour les cases Caisse de communaut�
 * 
 * @author Alexandre Ludwig et Arnaud Couderc
 * @see CaseCarte
 */
public class Chance extends Case implements CaseCarte{
	/**
	 * @param x
	 * @param y
	 * @param position
	 */
	public Chance(int x, int y, int position)
	{
		super("Chance", x, y, position);
	}

	/*
	 * Pioche une carte d'un paquet de carte m�lang� construit dans partie
	 * @param j : Joueur affect� par l'effet de la carte
	 * @param p : partie initialis�e
	 * @see Monopoly.CaseCarte#piocherCarte(Monopoly.JoueurMonopoly, Monopoly.Partie)
	 */
	@Override
	public void piocherCarte(JoueurMonopoly j, Partie p) {
		p.getPaquetChance().tirerCarte(j, p);
	}
}
