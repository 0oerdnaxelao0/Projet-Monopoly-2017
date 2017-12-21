package Monopoly;

import Jeu.Case;
/**
 * @author Alexandre Ludwig et Arnaud Couderc
 *
 */
public class Jail extends Case implements Divers{
	public Jail()
	{
		super("Prison", 0, 10, 10);
	}
	/*
	 * @see Monopoly.Divers#activerEffet(Monopoly.JoueurMonopoly)
	 */
	public void activerEffet(JoueurMonopoly j)
	{
		if(j.isEnPrison()) j.menuPrisonnier();
	}
	
}
