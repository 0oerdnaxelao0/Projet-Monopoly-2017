package Monopoly;
import java.util.Scanner;

import Exceptions.JoueurRuineException;
import Jeu.*;

/**
 * @author Alexandre Ludwig et Arnaud Couderc
 *
 */
public class ServicePublic extends Case implements Propriete{
	/**
	 * prix du service public
	 */
	private int prix;
	/**
	 * Loyer du service public
	 */
	private int loyer;
	/**
	 * Propriétaire du service public
	 */
	private JoueurMonopoly proprietaire;

	public ServicePublic(String nom, int x, int y, int position, int loyer, int prix)
	{
		super(nom, x, y, position);
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
	 * Setter : Définit le loyer du service public
	 * @param loyer
	 */
	public void setLoyer(int loyer) {
		this.loyer = loyer;
	}
	
	 /*
	 * @see Jeu.Case#toString()
	 */
	public String toString()
	{
		return super.toString() + "\nPrix :" + this.prix + "Loyer : " + this.loyer;
	}
	
	/**
	 * @param SP
	 * @return
	 */
	public boolean equals(Object o)
	{
		return super.equals(o);
	}
	/* (non-Javadoc)
	 * @see Monopoly.Propriete#getProprietaire()
	 */
	public JoueurMonopoly getProprietaire() {
		return proprietaire;
	}

	/* (non-Javadoc)
	 * @see Monopoly.Propriete#setProprietaire(Monopoly.JoueurMonopoly)
	 */
	public void setProprietaire(JoueurMonopoly j) {
		this.proprietaire = j;
	}

	/* (non-Javadoc)
	 * @see Monopoly.Propriete#Menu(Monopoly.JoueurMonopoly)
	 */
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
				System.out.println("Ce service public est à vendre : Souhaitez-vous l'acheter ? o si Oui, n sinon");
				reponse = sc.nextLine();
				a = reponse.charAt(0);
				if (a == 'o')
				{
					setProprietaire(j);
					try { 
						j.setArgentPossede(j.getArgentPossede() - getPrix());
					}
					catch(JoueurRuineException e){e.printStackTrace();}
					System.out.println(j.getNom()+ " est désormais propriétaire du service public " + this.getNom());
				}
				if ((a != 'o') && (a!= 'n'))
					System.out.println("Je n'ai pas compris, veillez reessayer");
			}
			while (((a != 'o') && (a != 'n')));
		}
		else {
			j.payerLoyer(this, 0);
			System.out.println("Ce service public appartient a" + this.getProprietaire().getNom() + ". Vous lui payer donc un loyer de " + this.getLoyer());
			}
		}
	}

