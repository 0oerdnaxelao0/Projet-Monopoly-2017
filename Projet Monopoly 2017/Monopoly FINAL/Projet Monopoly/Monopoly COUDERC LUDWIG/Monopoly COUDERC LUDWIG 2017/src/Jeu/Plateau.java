package Jeu;

public class Plateau {
	private int nbLignes;
	private int nbColonnes;
	private char[][] grille;
	
	public Plateau()
	{
		nbLignes = 11;
		nbColonnes = 11;
		grille = new char [nbLignes][nbColonnes];
		for(int i= 0; i<11;i++)
		{
			grille[0][i] = 'x';
			grille[10][i]='x';
		}
		for(int i= 1; i<10;i++)
		{
			grille[i][0] = 'x';
			grille[i][10]='x';
		}
		for(int i = 1; i<10; i++)
		{
			for(int j = 1; j<10; j++)
			{
				grille[i][j]='o';
			}
		}
	}
	public void Afficher()
	{
		System.out.println();
		for (int i = 0; i<nbLignes; i++)
		{
			for(int j =0; j<nbColonnes; j++)
			{
				System.out.print(" | "+grille[i][j]);
			}
			System.out.println(" | ");
		}
		System.out.println();
	}
}
