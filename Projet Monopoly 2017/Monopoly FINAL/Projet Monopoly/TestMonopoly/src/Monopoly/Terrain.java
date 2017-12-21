package Monopoly;

import java.util.Scanner;
import Exceptions.*;

import Jeu.Case;
/**
 * @author Alexandre Ludwig et Arnaud Couderc
 *
 */
public class Terrain extends Case implements Propriete{
	
	/**
	 * Couleur du terrain
	 */
	private String couleur;
	/**
	 * prix du terrain
	 */
	private int prix;
	/**
	 * loyer courant
	 */
	private int loyer;
	/**
	 * nombre de maisons sur le terrain
	 */
	private int nbMaisons;
	/**
	 * loyer terrain vide
	 */
	private int loyerTerrainNu;
	/**
	 * loyer avec une maison
	 */
	private int loyerUn;
	/**
	 * loyer avec 2 maisons
	 */
	private int loyerDeux;
	/**
	 * loyer avec 3 maisons
	 */
	private int loyerTrois;
	/**
	 * loyer avec 4 maisons
	 */
	private int loyerQuatre;
	/**
	 * loyer avec 5 maisons (un hotêl quoi)
	 */
	private int loyerHotel;
	
	/**
	 * prix d'une maison
	 */
	private int prixMaison;
	/**
	 * propriétaire du terrain
	 */
	private JoueurMonopoly proprietaire;
	
	public Terrain(String nom, int x, int y, int position, int loyerTerrainNu, int loyerUn, int loyerDeux, int loyerTrois, int loyerQuatre, int loyerHotel, int prix, String couleur, int prixMaison)
	{
		super(nom, x, y, position);
		setCouleur(couleur);
		this.prix = prix;
		this.loyer = loyerTerrainNu;
		this.loyerUn = loyerUn;
		this.loyerDeux = loyerDeux;
		this.loyerTrois = loyerTrois;
		this.loyerQuatre = loyerQuatre;
		this.loyerHotel = loyerHotel;
		this.prixMaison = prixMaison;
	}
	
	/**
	 * Getter : Renvoie la couleur du terrain
	 * @return couleur
	 */
	public String getCouleur() {
		return couleur;
	}
	/**
	 * Setter : Définit la couleur du terrain
	 * @param couleur
	 */
	private void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	/**
	 * Définit le loyer en fonction du nombre de maisons
	 */
	public int setLoyer() {
		if (nbMaisons == 0)
			return loyerTerrainNu;
		else if (nbMaisons == 1)
			return loyerUn;
		else if (nbMaisons == 2)
			return loyerDeux;
		else if (nbMaisons == 3)
			return loyerTrois;
		else if (nbMaisons == 4)
			return loyerQuatre;
		else
			return loyerHotel;
	}
	/* (non-Javadoc)
	 * @see Monopoly.Propriete#getPrix()
	 */
	public int getPrix()
	{
		return prix;
	}
	/**
	 * Getter : Renvoie le prix d'une maison sur ce terrain
	 * @return prixMaison
	 */
	
	public int getPrixMaison()
	{
		return this.prixMaison;
	}
	/* (non-Javadoc)
	 * @see Monopoly.Propriete#getLoyer()
	 */
	public int getLoyer()
	{
		return loyer;
	}
	
	/**
	 * Getter : Renvoie le nombre de maisons
	 * @return
	 */
	public int getNbMaisons() {
		return nbMaisons;
	}

	/**
	 * Ajoute une maison sur le terrain
	 * @throws NBMaisonsException
	 */
	public void ajouterMaison() throws NBMaisonsException, JoueurRuineException{
		
		if (this.nbMaisons == 5)
			throw new NBMaisonsException("Nombre de maisons trop eleve");
		this.nbMaisons++;
		getProprietaire().setArgentPossede(getProprietaire().getArgentPossede() - prixMaison);
		setLoyer();
	}

	/* (non-Javadoc)
	 * @see Jeu.Case#toString()
	 */
	public String toString()
	{
		return super.toString() + "\nCoueur : " + this.couleur + "Prix : " + this.prix + "Loyer : " + this.loyer;
	}
	
	/**
	 * @param T
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
		return this.proprietaire;
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
			System.out.println("Vous etes deja propriétaire de ce terrain.");
		}
		else if(getProprietaire() == null) 
		{
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String reponse;
			char a = 'a';
			do
			{
				System.out.println("Ce terrain est à vendre : Souhaitez-vous l'acheter ? o si Oui, n sinon");
				reponse = sc.nextLine();
				a = reponse.charAt(0);
				if (a == 'o')
				{
					setProprietaire(j);
					try { 
						j.setArgentPossede(j.getArgentPossede() - getPrix());
					}
					catch(JoueurRuineException e){e.printStackTrace();}
					System.out.println(j.getNom()+ " est désormais propriétaire du terrain " + this.getNom());
				}
				if ((a != 'o') && (a!= 'n'))
					System.out.println("Je n'ai pas compris, veillez reessayer");
			}
			while (((a != 'o') && (a != 'n')));
		}
		else {
			j.payerLoyer(this, 0);
			System.out.println("Ce terrain appartient a " + this.getProprietaire().getNom() + ".\n");
			switch (getCouleur())
			{
				case ("Rose") : {
					if (getProprietaire().aTousTerrainsCouleur(getProprietaire().getTerrainsRoses()));
						System.out.println("Il possède tous les terrains de cette couleur.\n");
				}
				case ("Cyan") : {
					if (getProprietaire().aTousTerrainsCouleur(getProprietaire().getTerrainsCyan()))
						System.out.println("Il possède tous les terrains de cette couleur.\n");
				}
				case ("Violet") : {
					if (getProprietaire().aTousTerrainsCouleur(getProprietaire().getTerrainsViolet()))
						System.out.println("Il possède tous les terrains de cette couleur.\n");
				}
				case ("Orange") : {
					if (getProprietaire().aTousTerrainsCouleur(getProprietaire().getTerrainsOranges()))
						System.out.println("Il possède tous les terrains de cette couleur.\n");
				}
				case ("Rouge") : {
					if (getProprietaire().aTousTerrainsCouleur(getProprietaire().getTerrainsRouges()))
						System.out.println("Il possède tous les terrains de cette couleur.\n");
				}
				case ("Jaune") : {
					if (getProprietaire().aTousTerrainsCouleur(getProprietaire().getTerrainsJaunes()))
						System.out.println("Il possède tous les terrains de cette couleur.\n");
				}
				case ("Vert") : {
					if (getProprietaire().aTousTerrainsCouleur(getProprietaire().getTerrainsVerts()))
						System.out.println("Il possède tous les terrains de cette couleur.\n");
				}
				case ("Bleu") : {
					if (getProprietaire().aTousTerrainsCouleur(getProprietaire().getTerrainsBleus()))
						System.out.println("Il possède tous les terrains de cette couleur.\n");
				}
				default :;	
			}
			if (nbMaisons > 0)
				System.out.println("Il possde " + nbMaisons + "sur ce terrain");
			
			System.out.println("Vous lui payez donc un loyer de " + this.getLoyer());
		}
	}
}
