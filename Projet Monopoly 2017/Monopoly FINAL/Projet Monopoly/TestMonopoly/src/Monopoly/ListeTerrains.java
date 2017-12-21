package Monopoly;

import java.util.ArrayList;

/**
 * @author Alexandre Ludwig et Arnaud Couderc
 *
 */
public class ListeTerrains {
	/**
	 * Liste de terrains
	 */
	private ArrayList<Terrain> ListeTerrains;
	/**
	 * Couleur de la liste de terrains
	 */
	private String couleur;
	/**
	 * Taille de la liste de terrains (< 3)
	 */
	private int taille;
	
	public ListeTerrains(ArrayList<Terrain> listeTerrains, String couleur, int taille) {
		ListeTerrains = listeTerrains;
		this.couleur = couleur;
		this.taille = taille;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ListeTerrains [ListeTerrains=" + ListeTerrains + ", couleur=" + couleur + "]";
	}

	/**
	 * Getter : Renvoie la liste de terrains
	 * @return listeTerrains
	 */
	public ArrayList<Terrain> getListeTerrains() {
		return ListeTerrains;
	}

	/**
	 * Getter : Renvoie la couleur de la liste de terrains
	 * @return couleur
	 */
	public String getCouleur() {
		return couleur;
	}

	/**
	 * Getter : Renvoie la taille maximale
	 * @return taille
	 */
	public int getTaille() {
		return taille;
	}

	public void add(Terrain t)
	{
		ListeTerrains.add(t);
	}

	public Terrain get(int i)
	{
		return this.ListeTerrains.get(i);
	}

	public int size()
	{
		return this.ListeTerrains.size();
	}
}
