package Monopoly;
import Exceptions.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Alexandre Ludwig et Arnaud Couderc
 *
 */
public class Partie 
{
	/**
	 * Liste des joueurs dans la partie
	 */
	private ArrayList<JoueurMonopoly> listeJoueurs = new ArrayList<JoueurMonopoly>();
	/**
	 * Le plateau du monopoly
	 */
	private PlateauMonopoly p = new PlateauMonopoly();
	/**
	 * Les 2 paquets Chance et caisse de communauté
	 */
	private PaquetCarte paquetChance = new PaquetCarte("Caisse de communauté");
	private PaquetCarte paquetCaisse= new PaquetCarte("Chance");
	
	/**
	 * Lance une partie en fonction du choix de l'utilisateur (pour la soutenance)
	 * @param choix
	 * @throws JoueurRuineException
	 */
	public Partie(int choix) throws JoueurRuineException
	{
		//listeJoueurs.add(new JoueurMonopoly("Alex", 150000, "chapeau", p));
		//listeJoueurs.add(new JoueurMonopoly("Arnaud", 150000, "chien", p));
		listeJoueurs.add(new JoueurMonopoly("Alex", 1500000, "Roue"));
		listeJoueurs.add(new JoueurMonopoly("Arnaud", 1500000, "Chien"));
		
		switch (choix)
		{
		case 1 : //le joueur 1 va en prison à cause de la case "aller en prison"
			{
				((Divers)p.getPosition(30)).activerEffet(listeJoueurs.get(0));
				break;
			}
		case 2 : //le joueur 1 va en prison à cause de la case "aller en prison", mais possède la carte pour s'en libérer
			{
				((Divers)p.getPosition(30)).activerEffet(listeJoueurs.get(0));
				listeJoueurs.get(0).setCarteLibererPrison(true);
				break;
			}
		case 3 : //Le joueur 1 possède les terrains bleus, et peut donc construire des maisons sur ce monopole
			{
				listeJoueurs.get(0).getTerrainsBleus().add((Terrain) p.getPosition(37));
				listeJoueurs.get(0).getTerrainsBleus().add((Terrain) p.getPosition(39));
				((Terrain) p.getPosition(37)).setProprietaire(listeJoueurs.get(0));
				((Terrain) p.getPosition(39)).setProprietaire(listeJoueurs.get(0));
				listeJoueurs.get(0).MenuConstructionMaison(listeJoueurs.get(0).getTerrainsBleus());
				break;
			}
		case 4: //Le joueur 1 possède un terrain, et il ne se passe rien quand il est dessus
			{
				listeJoueurs.get(0).getTerrainsBleus().add((Terrain) p.getPosition(37));
				((Terrain) p.getPosition(37)).setProprietaire(listeJoueurs.get(0));
				((Propriete) p.getPosition(37)).Menu(listeJoueurs.get(0));
				break;
			}
		case 5: //le joueur 1 possède un terrain, et le joueur 2 est dessus, du coup il doit payer le loyer
			{
				listeJoueurs.get(0).getTerrainsBleus().add((Terrain) p.getPosition(37));
				((Terrain) p.getPosition(37)).setProprietaire(listeJoueurs.get(0));
				((Propriete) p.getPosition(37)).Menu(listeJoueurs.get(1));
				break;
			}
		case 6: //le joueur 1 ne possède aucun terrain, il est téléporté sur un terrain et peut donc l'acheter
			{
				((Propriete) p.getPosition(37)).Menu(listeJoueurs.get(0));
				break;
			}
		case 7: //le montant du parc gratuit est de 1€, le joueur 1 est posé sur la case de celui ci et reçoit du coup l'euro
			{
				((ParcGratuit)p.getPosition(20)).setCagnotte(1);
				((Divers) p.getPosition(20)).activerEffet(listeJoueurs.get(0));
				break;	
			}
		case 8: //le joueur 1 pioche une carte chance en début de partie
			{
				((CaseCarte) p.getPosition(7)).piocherCarte(listeJoueurs.get(0), this);
				break;
			}
		case 9: //le joueur 1 pioche une carte caisse de communauté en début de partie
			{
				((CaseCarte) p.getPosition(17)).piocherCarte(listeJoueurs.get(0), this);
				break;
			}	
		case 10: //le joueur 1 paye la taxe de luxe
			{
				((Divers) p.getPosition(38)).activerEffet(listeJoueurs.get(0));
				break;
			}
		case 11: //le joueur 1 paye les impôts sur le revenu
			{
				((Divers) p.getPosition(4)).activerEffet(listeJoueurs.get(0));
				break;				
			}
		case 12: //le joueur 1 se trouve sur la dernière case du plateau, 
				 //il lance le dé et reçoit donc le montant de la case départ
			{
				listeJoueurs.get(0).setNumPosition(39);
				break;
			}
		case 13: 
		{
			listeJoueurs.get(0).setNumPosition(39);
			listeJoueurs.get(0).Avancer(1);
			((Divers) p.getPosition(listeJoueurs.get(0).getNumPosition())).activerEffet(listeJoueurs.get(0));
			break;
		}
		default : //Partie normale
			{
				listeJoueurs.remove(1);
				listeJoueurs.remove(0);
				choixNbJoueurs();
				break;
			}
		}
		while (listeJoueurs.size()>1)
		{
			for (JoueurMonopoly j: listeJoueurs) 
			{
				Tour(j);
			}
			
		}
		System.out.println(listeJoueurs.get(0) + " a gagné la partie !");
	}
	
	/**
	 * Lancer de dé
	 * @return nbDe
	 */
	public int LancerDe()
	{
		int valeurDe = ((int)(2.0D + 12.0D * Math.random()));
		return valeurDe;
	}
	/**
	 * Tour d'un joueur j
	 * @param j
	 * @throws JoueurRuineException : si le joueur n'a plus de thunes
	 */
	public void Tour(JoueurMonopoly j) throws JoueurRuineException
	{
		
			if(j.isEnPrison()) 
				{
					j.menuPrisonnier();
				}
			if (!(j.isEnPrison())) //le joueur a s'est libéré de prison si il était emprisonné
			{
				System.out.println("\nC'est le tour de " + j.getNom());
				int valeurDe = LancerDe();
				System.out.println(j.getNom() + " lance son dé et obtient " + valeurDe);
				j.Avancer(valeurDe);
				System.out.println(j.getNom()+" possede actuellement " + j.getArgentPossede() + " €.");
				
				
				/* Gestion de l'interaction avec la case d'arrivee */
				if(p.getPosition(j.getNumPosition()) instanceof Divers) 
				{
					System.out.println(j.getNom() + " est arrivé sur la case " + p.getPosition(j.getNumPosition()).getNom());
					((Divers) p.getPosition(j.getNumPosition())).activerEffet(j);
				}
				else if (p.getPosition(j.getNumPosition()) instanceof Propriete)
				{
					System.out.println(j.getNom() + " est arrivé sur la case " + p.getPosition(j.getNumPosition()).getNom());
					((Propriete) p.getPosition(j.getNumPosition())).Menu(j);
				}
				else if (p.getPosition(j.getNumPosition()) instanceof CaseCarte) 
				{
					System.out.println(j.getNom() + " est arrivé sur la case " + p.getPosition(j.getNumPosition()).getNom());
					((CaseCarte) p.getPosition(j.getNumPosition())).piocherCarte(j, this);
				}
				
				/*Gestion de l'achat de maisons */
				j.MenuProprietaire();
				System.out.println("C'est la fin du tour de "+ j.getNom()+" qui possede maintenant " + j.getArgentPossede() + " €.");
			}
	}
	
	/**
	 * Méthode qui ajoute un joueur à la liste de joueur
	 * @param listeJoueurs
	 * @param joueur
	 * @throws PionException : si un joueur a le même pion
	 */
	public void addJoueur(ArrayList<JoueurMonopoly> listeJoueurs, JoueurMonopoly joueur) throws PionException
	{
		if (listeJoueurs.size() != 0)
		{
			for (JoueurMonopoly j : listeJoueurs)
			{
				if (j.getPion().equals(joueur.getPion()))
					throw new PionException("Meme pion qu'un autre joueur");
			}
			listeJoueurs.add(joueur);
		}
		else
			listeJoueurs.add(joueur);
	}
	
	/**
	 * Menu qui permet de choisir le nombre de joueurs ainsi que leurs noms et leurs pions
	 */
	private void choixNbJoueurs()
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String reponse, nomJoueur;
		int nbJoueurs, i = 0;
		char a;
		do
		{
			System.out.println("Combien de joueurs ? (entre 2 et 8)");
			reponse = sc.nextLine();
			a = reponse.charAt(0);
			if ((a < '1') || (a > '9'))
				System.out.println("Je n'ai pas compris, veillez reessayer");
		} while ((a < '0') || (a > '9'));
		nbJoueurs = a - '0';
		System.out.println("Il y a donc " + nbJoueurs + " Joueurs");
		
		do
		{
			System.out.println("Entrez le nom du joueur n° " + (i + 1));
			nomJoueur = sc.nextLine();
			System.out.println("Vous etes donc " + nomJoueur);
			do
			{
				System.out.println(nomJoueur + ", Choisissez un pion");
				System.out.println("1 pour la roue\n2 pour le de a coudre\n3 pour le chien\n4 pour le fer a repasser\n"
						+ "5 pour le bateau\n6 pour le chapeau\n7 pour la chaussure\n8 pour la voiture\n9 pour le cheval");
				reponse = sc.nextLine();
				a = reponse.charAt(0);
			
			switch (a)
			{
			case '1':
				{
					System.out.println("Vous avez choisi la Roue");
					try {
						JoueurMonopoly j = new JoueurMonopoly(nomJoueur, 150000, "Roue");
						addJoueur(listeJoueurs, j);
						System.out.println(listeJoueurs.get(i).toString());
						i++;
					}
					catch(PionException e)
					{
						e.printStackTrace();
					}
					break;
					
					
				}
			case '2':
				{
					System.out.println("Vous avez choisi le De a Coudre");
					try {
						JoueurMonopoly j = new JoueurMonopoly(nomJoueur, 150000, "de a coudre");
						addJoueur(listeJoueurs, j);
						System.out.println(listeJoueurs.get(i).toString());
						i++;
					}
					catch(PionException e)
					{
						e.printStackTrace();
					}
					break;
				}
			case '3':
				{
					System.out.println("Vous avez choisi le Chien");
					try {
						JoueurMonopoly j = new JoueurMonopoly(nomJoueur, 150000, "Chien");
						addJoueur(listeJoueurs, j);
						System.out.println(listeJoueurs.get(i).toString());
						i++;
					}
					catch(PionException e)
					{
						e.printStackTrace();
					}
					break;
				}
			case '4':
				{
					System.out.println("Vous avez choisi le Fer a Repasser");
					try {
						JoueurMonopoly j = new JoueurMonopoly(nomJoueur, 150000, "Fer a Repasser");
						addJoueur(listeJoueurs, j);
						System.out.println(listeJoueurs.get(i).toString());
						i++;
					}
					catch(PionException e)
					{
						e.printStackTrace();
					}
					break;
				}
			case '5':
				{
					System.out.println("Vous avez choisi le Bateau");
					try {
						JoueurMonopoly j = new JoueurMonopoly(nomJoueur, 150000, "Bateau");
						addJoueur(listeJoueurs, j);
						System.out.println(listeJoueurs.get(i).toString());
						i++;
					}
					catch(PionException e)
					{
						e.printStackTrace();
					}
					break;
				}
			case '6':
				{
					System.out.println("Vous avez choisi le Chapeau");
					try {
						JoueurMonopoly j = new JoueurMonopoly(nomJoueur, 150000, "Chapeau");
						addJoueur(listeJoueurs, j);
						System.out.println(listeJoueurs.get(i).toString());
						i++;
					}
					catch(PionException e)
					{
						e.printStackTrace();
					}
					break;
				}
			case '7':
				{
					System.out.println("Vous avez choisi la Voiture");
					try {
						JoueurMonopoly j = new JoueurMonopoly(nomJoueur, 150000, "Voiture");
						addJoueur(listeJoueurs, j);
						System.out.println(listeJoueurs.get(i).toString());
						i++;
					}
					catch(PionException e)
					{
						e.printStackTrace();
					}
					break;
				}
			case '8':
				{
					System.out.println("Vous avez choisi la Chaussure");
					try {
						JoueurMonopoly j = new JoueurMonopoly(nomJoueur, 150000, "Chaussure");
						addJoueur(listeJoueurs, j);
						System.out.println(listeJoueurs.get(i).toString());
						i++;
					}
					catch(PionException e)
					{
						e.printStackTrace();
					}
					break;
				}
			case '9':
				{
					System.out.println("Vous avez choisi le Cheval");
					try {
						JoueurMonopoly j = new JoueurMonopoly(nomJoueur, 150000, "Cheval");
						addJoueur(listeJoueurs, j);
						System.out.println(listeJoueurs.get(i).toString());
						i++;
					}
					catch(PionException e)
					{
						e.printStackTrace();
					}
					break;
				}
			default: System.out.println("Je n'ai pas compris, veuillez réessayer"); break;
		}
		} while((a < '1') || (a > ('9' + 1)));
	}while(listeJoueurs.size() < nbJoueurs);
	}
	
	/**
	 * Getter : Renvoie le plateau de la partie
	 * @return p
	 */
	public PlateauMonopoly getPlateau() {
		return this.p;
	}
	/**
	 * Setter : Définit le plateau de la partie
	 * @param p
	 */
	public void setPlateau(PlateauMonopoly p) {
		this.p = p;
	}
	/**
	 * Getter : Renvoie le paquet de carte chance
	 * @return paquetChance
	 */
	public PaquetCarte getPaquetChance() {
		return paquetChance;
	}
	/**
	 * Setter : Définit le paquet de carte chance
	 * @param paquetChance
	 */
	public void setPaquetChance(PaquetCarte paquetChance) {
		this.paquetChance = paquetChance;
	}
	/**
	 * Getter : Renvoie le paquet de carte caisse de communauté
	 * @return paquetCaisse
	 */
	public PaquetCarte getPaquetCaisse() {
		return paquetCaisse;
	}
	/**
	 * Setter : Définit le paquet de carte caisse de communauté
	 * @param paquetCaisse
	 */
	public void setPaquetCaisse(PaquetCarte paquetCaisse) {
		this.paquetCaisse = paquetCaisse;
	}
}
