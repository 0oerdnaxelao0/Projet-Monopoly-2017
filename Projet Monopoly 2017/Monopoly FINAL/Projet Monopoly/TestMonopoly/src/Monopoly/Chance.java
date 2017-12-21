package Monopoly;
import Jeu.Case;
/**
 * Classe pour les cases Caisse de communauté
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
	 * Pioche une carte d'un paquet de carte mélangé construit dans partie
	 * @param j : Joueur affecté par l'effet de la carte
	 * @param p : partie initialisée
	 * @see Monopoly.CaseCarte#piocherCarte(Monopoly.JoueurMonopoly, Monopoly.Partie)
	 */
	@Override
	public void piocherCarte(JoueurMonopoly j, Partie p) {
		p.getPaquetChance().tirerCarte(j, p);
	}
}
