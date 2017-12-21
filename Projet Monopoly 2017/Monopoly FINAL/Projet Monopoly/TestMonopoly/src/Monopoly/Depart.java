package Monopoly;
import Exceptions.JoueurRuineException;
//import Exceptions.JoueurRuineException;
import Jeu.Case;
/**
 * @author Alexandre Ludwig et Arnaud Couderc
 * @see Case
 * @see Divers
 */
public class Depart extends Case implements Divers {
	
	public Depart()
	{
		super("Depart", 0, 0, 0);
	}
	
	/* 
	 * Effet de la case d�part : Le joueur recoit 40000 � (20000 + 20000) @see Monopoly.JoueurMonopoly.Avancer
	 * @param j : Joueur affect� par l'effet de la case (ici d�part)
	 * @see Monopoly.CaseCarte#piocherCarte(Monopoly.JoueurMonopoly, Monopoly.Partie)
	 */
	public void activerEffet(JoueurMonopoly j)
	{
			System.out.println("Vous arrivez sur la case depart, vous recevez 40000 �");
			try { 
				j.setArgentPossede(j.getArgentPossede() + 20000);//20000 + 20000 du tour de terrain
			}
			catch(JoueurRuineException e){}
	}

}
