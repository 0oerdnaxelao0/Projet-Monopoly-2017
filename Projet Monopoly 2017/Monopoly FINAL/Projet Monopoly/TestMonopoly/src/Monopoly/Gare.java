package Monopoly;
import java.util.Scanner;
import Exceptions.JoueurRuineException;
import Jeu.*;

/**
 * Classe des gares
 * 
 * @author Alexandre Ludwig et Arnaud Couderc
 *
 */
public class Gare extends Case implements Propriete{
	/**
	 * Prix de la gare
	 */
	private int prix;
	/**
	 * Loyer de la gare
	 */
	private int loyer;
	/**
	 * Propriétaire de la gare
	 */
	private JoueurMonopoly proprietaire;
	
	/**
	 * @param nom : nom de la gare
	 * @param x : position horizontale
	 * @param y : position verticale
	 * @param position : position dans le plateau
	 * @param loyer : loyer de la gare
	 * @param prix : prix de la gare
	 */
	public Gare(String nom, int x, int y, int position, int loyer, int prix)
	{
		super("Gare "+ nom, x, y, position);
		this.prix = prix;
		setLoyer(loyer);
	}

	/* 
	 * @see Monopoly.Propriete#getPrix()
	 */
	public int getPrix() {
		return prix;
	}

	/*
	 * @see Monopoly.Propriete#getLoyer()
	 */
	public int getLoyer() {
		return loyer;
	}

	/**
	 * Setter : définit le loyer
	 * @param loyer
	 */
	public void setLoyer(int loyer) {
		this.loyer = loyer;
	}
	
	/*
	 * @see Jeu.Case#toString()
	 */
	@Override
	public String toString()
	{
		return super.toString() + "\nPrix :" + this.prix + "Loyer : " + this.loyer;
	}
	
	/**
	 * @param G
	 * @return
	 */
	public boolean equals(Object o)
	{
		return super.equals(o);
	}

	/*
	 * @see Monopoly.Propriete#getProprietaire()
	 */
	@Override
	public JoueurMonopoly getProprietaire() {
		return proprietaire;
	}

	/*
	 * @see Monopoly.Propriete#setProprietaire(Monopoly.JoueurMonopoly)
	 */
	@Override
	public void setProprietaire(JoueurMonopoly j) {
		this.proprietaire = j;
	}

	/*
	 * Menu activé lors de l'arrivée d'un joueur sur une gare
	 * @see Monopoly.Propriete#Menu(Monopoly.JoueurMonopoly)
	 */
	@Override
	public void Menu(JoueurMonopoly j) {
		if(j.equals(getProprietaire()))
		{
			System.out.println("Joueur propriétaire");
		}
		else if(getProprietaire() == null) 
		{
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String reponse;
			char a = 'a';
			do
			{
				System.out.println("Cette gare est à vendre : Souhaitez-vous l'acheter ? o si Oui, n sinon");
				reponse = sc.nextLine();
				a = reponse.charAt(0);
				if (a == 'o')
				{
					setProprietaire(j);
					try { 
						j.setArgentPossede(j.getArgentPossede() - getPrix());
					}
					catch(JoueurRuineException e)
					{
						e.printStackTrace();
					}
					System.out.println(j.getNom()+ " est désormais propriétaire de la " + this.getNom());
				}
				if ((a != 'o') && (a!= 'n'))
					System.out.println("Je n'ai pas compris, veillez reessayer");
			}
			while (((a != 'o') && (a != 'n')));
		}
		else {
			j.payerLoyer(this, 0);
			System.out.println("Cette gare appartient a " + this.getProprietaire().getNom() + ".\nIl possede " + this.getProprietaire().getGarePossedees().size() + " gares."
					+ "\nVous lui payer donc un loyer de " + this.getLoyer());
		}
		}
	}
