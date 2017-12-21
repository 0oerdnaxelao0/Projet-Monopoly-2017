package Monopoly;
import Jeu.Case;
/**
 * @author Alexandre Ludwig et Arnaud Couderc
 *
 */
public class GoToJail extends Case implements Divers{
	public GoToJail(){
		super("Aller en prison", 10, 0, 30);
	}
	/*
	 * @see Monopoly.Divers#activerEffet(Monopoly.JoueurMonopoly)
	 */
	public void activerEffet(JoueurMonopoly j)
	{
		System.out.println(j.getNom() + " arrive sur la case -Aller en prison-, vous y allez donc avec le sourire");
		j.setNumPosition(10);
		j.setEnPrison(true);
	}
}
