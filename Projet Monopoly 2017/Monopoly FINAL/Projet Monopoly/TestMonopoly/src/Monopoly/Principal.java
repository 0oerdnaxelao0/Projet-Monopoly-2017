package Monopoly;

import java.util.Scanner;

import Exceptions.JoueurRuineException;

/**
 * @author Alexandre Ludwig et Arnaud Couderc
 *
 */
public class Principal {
	
	public static void AfficherMenu()
	{
		System.out.println("MENU\n");
		System.out.println("1 : Partie dans laquelle le joueur 1 va en prison\n");
		System.out.println("2 : Partie dans laquelle le joueur 1 va en prison mais poss�de la carte de lib�ration\n");
		System.out.println("3 : Partie dans laquelle le joueur 1 poss�de un monopole, et peut donc construire des maisons dans ce groupe de terrain\n");
		System.out.println("4 : Partie dans laquelle le joueur 1 poss�de un terrain, et il ne se passe rien quand il est dessus\n");
		System.out.println("5 : Partie dans laquelle le joueur 1 poss�de un terrain, et le joueur 2 est dessus, du coup il doit payer le loyer\n");
		System.out.println("6 : Partie dans laquelle le joueur 1 ne poss�de aucun terrain, il est t�l�port� sur un terrain et peut donc l'acheter\n");
		System.out.println("7 : Partie dans laquelle le montant du parc gratuit est de 1�, le joueur 1 est pos� sur la case de celui ci et re�oit du coup l'euro\n");
		System.out.println("8 : Partie dans laquelle le joueur 1 pioche une carte chance en d�but de partie\n");
		System.out.println("9 : Partie dans laquelle le joueur 1 pioche une carte caisse de communaut� en d�but de partie\n");
		System.out.println("10 : Partie dans laquelle le joueur 1 paye la taxe de luxe\n");
		System.out.println("11 : Partie dans laquelle le joueur 1 paye les imp�ts sur le revenu\n");
		System.out.println("12 : Partie dans laquelle le joueur 1 se trouve sur la derni�re case du plateau, il lance le d� et re�oit donc le montant de la case d�part\n");
		System.out.println("13 : Partie dans laquelle le joueur 1 se trouve sur la derni�re case du plateau, il lance le d�, fais un 1 et avance pour recevoir le double du montant de la case d�part\n");
		System.out.println("Autre : Partie classique\n");
		System.out.println("Votre choix :");
	}

	public static void main(String[] args) {
		int nb = 0;
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String reponse;
			AfficherMenu();
			reponse = sc.nextLine();
			if(reponse.length()==2)
			{
				char a = reponse.charAt(1);
				char b = reponse.charAt(0);
				
				nb = 10*(b -'0') + (a - '0');
			}
			else if (reponse.length() == 1)
			{
				char a = reponse.charAt(0);
				nb = a - '0';
			}
			else System.out.println("Num�ro incorrect !");
			try{
				new Partie(nb);
			}
			catch(JoueurRuineException e)
			{
				e.printStackTrace();
			}
			

	}

}
