package Monopoly;
import java.util.ArrayList;
import java.util.Scanner;

import Exceptions.JoueurRuineException;
import Exceptions.NBMaisonsException;
import Jeu.*;

/**
 * @author Alexandre Ludwig et Arnaud Couderc
 *
 */
public class JoueurMonopoly extends Joueur{
	
	/**
	 * Liste de terrains possédés par le joueur
	 */
	private ListeTerrains terrainsRoses = new ListeTerrains(new ArrayList<Terrain>(), "Rose", 2);
	private ListeTerrains terrainsCyan = new ListeTerrains(new ArrayList<Terrain>(), "Cyan", 3);
	private ListeTerrains terrainsViolet = new ListeTerrains(new ArrayList<Terrain>(), "Violet", 3);
	private ListeTerrains terrainsOranges = new ListeTerrains(new ArrayList<Terrain>(), "Orange", 3);
	private ListeTerrains terrainsRouges = new ListeTerrains(new ArrayList<Terrain>(), "Rouge", 3);
	private ListeTerrains terrainsJaunes = new ListeTerrains(new ArrayList<Terrain>(), "Jaune", 3);
	private ListeTerrains terrainsVerts = new ListeTerrains(new ArrayList<Terrain>(), "Vert", 3);
	private ListeTerrains terrainsBleus = new ListeTerrains(new ArrayList<Terrain>(), "Bleu", 2);
	
	/**
	 * Liste des gares possédés par le joueur
	 */
	private ArrayList<Gare> garePossedees = new ArrayList<Gare>();
	/**
	 * Liste des services publics possédés par le joueur
	 */
	private ArrayList<ServicePublic> servicesPossedes = new ArrayList<ServicePublic>();
	/**
	 * Le joueur possède une carte libéré de prison ou non
	 */
	private boolean carteLibererPrison = false;
	/**
	 * Le joueur est en prison ou non
	 */
	private boolean enPrison;
	/**
	 * Position du joueur dans le plateau
	 */
	private int numPosition = 0;
	/**
	 * Nombre de tours du joueur en prison (max. 3)
	 */
	private int numTourPrison = 0;
	
	public JoueurMonopoly(String nom, int argentPossede, String pion) {
		super(nom,argentPossede, pion);
		enPrison = false;
	}

	/**
	 * Le joueur est-il en prison ?
	 * @return enPrison
	 */
	public boolean isEnPrison() {
		return enPrison;
	}
	/**
	 * Le joueur possède t'il une carte libéré de prison ?
	 * @returncarteLiberePrison
	 */
	public boolean aCarteLibererPrison() {
		return carteLibererPrison;
	}

	/**
	 * On donne ou on retire une carte libéré de prison au joueur
	 * @param carteLibererPrison
	 */
	public void setCarteLibererPrison(boolean carteLibererPrison) {
		this.carteLibererPrison = carteLibererPrison;
	}
	
	/**
	 * Renvoie la position du joueur dans le plateau
	 * @return numPosition;
	 */
	public int getNumPosition() {
		return numPosition;
	}

	/**
	 * On envoie on on libère le joueur de prison
	 * @param enPrison
	 */
	public void setEnPrison(boolean enPrison) {
		this.enPrison = enPrison;
	}
	
	/**
	 * Définit la position du joueur sur le plateau
	 * @param numPosition
	 */
	public void setNumPosition(int numPosition) {
		this.numPosition = numPosition;
	}

	/**
	 * Renvoie la liste de terrain possédée par le joueur de la couleur désignée
	 * @returnlisteTerrains"couleur"
	 */
	public ListeTerrains getTerrainsRouges() {
		return terrainsRouges;
	}
	public ListeTerrains getTerrainsRoses() {
		return terrainsRoses;
	}
	public ListeTerrains getTerrainsCyan() {
		return terrainsCyan;
	}
	public ListeTerrains getTerrainsViolet() {
		return terrainsViolet;
	}
	public ListeTerrains getTerrainsOranges() {
		return terrainsOranges;
	}
	public ListeTerrains getTerrainsJaunes() {
		return terrainsJaunes;
	}
	public ListeTerrains getTerrainsVerts() {
		return terrainsVerts;
	}
	public ListeTerrains getTerrainsBleus() {
		return terrainsBleus;
	}
	/**
	 * Revoie la liste des gares possédées par le joueur
	 * @return garesPossedees
	 */
	public ArrayList<Gare> getGarePossedees() {
		return garePossedees;
	}
	/**
	 * Renvoie la liste des services publics possédés par le joueur
	 * @return
	 */
	public ArrayList<ServicePublic> getServicesPossedes() {
		return servicesPossedes;
	}
	/**
	 * Le joueur achète la propriété p
	 * @param p : propriété achetée
	 */
	public void acheterPropriete(Propriete p)
	{
		try { 
			setArgentPossede(getArgentPossede() - p.getPrix());
			if(p instanceof Terrain)
			{
				switch(((Terrain) p).getCouleur()) //On ajoute le terrain dans la liste des terrains possédés concernée
				{
					case ("rose") : terrainsRoses.add((Terrain) p);
					case ("cyan") : terrainsCyan.add((Terrain) p);
					case ("violet") : terrainsViolet.add((Terrain) p);
					case ("orange") : terrainsOranges.add((Terrain) p);
					case ("jaune") : terrainsJaunes.add((Terrain) p);
					case ("rouge") : terrainsRouges.add((Terrain) p);
					case ("vert") : terrainsVerts.add((Terrain) p);
					case ("bleu") : terrainsBleus.add((Terrain)p);
					default:;
				}
			}
			else if(p instanceof Gare) garePossedees.add((Gare) p); //On ajoute la gare dans la liste concernée
			else if(p instanceof ServicePublic)servicesPossedes.add((ServicePublic)p); //On ajoute le service public dans la lite concernée
			p.setProprietaire(this); //On assigne le propriétaire
		}
		catch(JoueurRuineException e) {e.printStackTrace();}
	}
	
	/**
	 * Méthode qui gère le loyer en fonction du monopole du joueur et du nombre de maisons
	 * @param GroupeTerrains : Groupe de terrains de la même couleur
	 * @param t : Terrain dont on gère le loyer
	 */
	public void gestionLoyerTerrain(ListeTerrains GroupeTerrains, Terrain t)
	{
		if ((aTousTerrainsCouleur(GroupeTerrains)) && (t.getNbMaisons() == 0)) //Si le joueur a tous les terrains d'une même couleur
		{
			try { 
				setArgentPossede(getArgentPossede()- (t.getLoyer() * 2)); //Le loyer est multiplié par 2
				//Le loyer en fonction du nombre de maisons est géré dans la classe Terrain
				t.getProprietaire().setArgentPossede(t.getProprietaire().getArgentPossede()+t.getLoyer());
			}
			catch(JoueurRuineException e) {e.printStackTrace();}
			return;
		}
		try { 
			setArgentPossede(getArgentPossede()- (t.getLoyer()));
			t.getProprietaire().setArgentPossede(t.getProprietaire().getArgentPossede()+t.getLoyer());
		}
		catch(JoueurRuineException e) {e.printStackTrace();}
	}
	
	/**
	 * Méthode qui gère le paiment du loyer quand le joueur 
	 * arrive sur une propriété possédée par un autre joueur
	 * @param p : Propriété concernée
	 * @param nbDe : le nombre obtenu lorsque le joueur a lancé ses dés (pour les services publics
	 */
	public void payerLoyer(Propriete p, int nbDe)
	{
		if(p instanceof Terrain)
		{
			switch(((Terrain) p).getCouleur())
			{
				case ("rose") : gestionLoyerTerrain(terrainsRoses, (Terrain) p);
				case ("cyan") : gestionLoyerTerrain(terrainsCyan, (Terrain) p);
				case ("violet") : gestionLoyerTerrain(terrainsViolet, (Terrain) p);
				case ("orange") : gestionLoyerTerrain(terrainsOranges, (Terrain) p);
				case ("rouge") : gestionLoyerTerrain(terrainsRouges, (Terrain) p);
				case ("Jaune") : gestionLoyerTerrain(terrainsJaunes, (Terrain) p);
				case ("Vert") : gestionLoyerTerrain(terrainsVerts, (Terrain) p);
				case ("Bleu") : gestionLoyerTerrain(terrainsBleus, (Terrain) p);
			}
		}
		else if(p instanceof Gare)
		{
			int aPayer = (int) (p.getLoyer() * Math.pow(2, p.getProprietaire().garePossedees.size()));
			try { 
				setArgentPossede(getArgentPossede()-aPayer);
				p.getProprietaire().setArgentPossede(p.getProprietaire().getArgentPossede()+aPayer);
			}
			catch(JoueurRuineException e) {e.printStackTrace();}
		}
		else
		{
			if (p.getProprietaire().servicesPossedes.size() == 2) //Si un joueur possède les 2 services publics, loyer = 1000*nbDe
			{
				try { 
					setArgentPossede(getArgentPossede()-nbDe * 1000);
				}
				catch(JoueurRuineException e) {e.printStackTrace();}
			}
			else
			{
				try { 
					setArgentPossede(getArgentPossede()-nbDe * 400); //Sinon, loyer = 400*nbDe
				}
				catch(JoueurRuineException e) {e.printStackTrace();}
			}
		}
		
	}
	
	/**
	 * Méthode qui vérifie si le joueur a au moins un monopole (possède un groupe entier de terrains de la même couleur)
	 * @param GroupeTerrains : Liste de terrains que l'on veut vérifier
	 */
	public boolean aTousTerrainsCouleur(ListeTerrains GroupeTerrains)
	{
			if ((GroupeTerrains.getCouleur().equals("Rose")) || (GroupeTerrains.getCouleur().equals("Bleu")))
				return (GroupeTerrains.getListeTerrains().size() == 2);
			else
				return (GroupeTerrains.getListeTerrains().size() == 3);
	}
	
	/**
	 * Méthode qui vérifie si le joueur possède un monopole et peut construire une maison
	 */
	public boolean peutConstruire()
	{
		return (aTousTerrainsCouleur(terrainsRoses) || aTousTerrainsCouleur(terrainsCyan)  || aTousTerrainsCouleur(terrainsViolet)  || aTousTerrainsCouleur(terrainsOranges)  || aTousTerrainsCouleur(terrainsRouges)
				 || aTousTerrainsCouleur(terrainsJaunes) || aTousTerrainsCouleur(terrainsVerts) || aTousTerrainsCouleur(terrainsBleus));		
	}

	/**
	 * Le joueur avance de nbDe cases
	 * @param valeurDe
	 */
	public void Avancer(int valeurDe)
	{
		this.numPosition += valeurDe;
		if(this.numPosition >= 40) //Le joueur a fait un tour de terrain
		{
			this.numPosition -= 40;
			try {
				this.setArgentPossede(getArgentPossede() + 20000); //Il passe par la case départ et reçoit 20000
				if (numPosition != 0)
					System.out.println("Vous passez par la case depart, vous recevez 20000 €");
			}
			catch(JoueurRuineException e){
				e.printStackTrace();
			}
		}
		else if(this.numPosition < 0) //Le joueur recule et dépasse la case départ
			this.numPosition += 40;
		
	}
	
	/**
	 * Menu du joueur lorsqu'il est en prison
	 */
	public void menuPrisonnier()
	{
		this.numTourPrison++;
		System.out.println(getNom() + " est en prison depuis " + numTourPrison +" tour(s).");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String choix;
		if (numTourPrison == 3)
		{
			try { 
				setArgentPossede(getArgentPossede() - 5000);
			}
			catch(JoueurRuineException e) {e.printStackTrace();}
			this.setEnPrison(false);
			this.numTourPrison = 0;
			System.out.println("Vous etes en prison depuis 3 tours.\nVous payez automatiquement 5000 €. Vous sortez donc de prison et reprenez le cours de la partie normalement");
		}
		else if(this.aCarteLibererPrison())
		{	
			System.out.println("Vous possédez une carte sortie de prison : Souhaitez-vous l'utiliser ? o si oui, n sinon");
			do
			{
				choix = sc.nextLine();
				if(choix.equals("o"))
				{
					this.setCarteLibererPrison(false);
					this.setEnPrison(false);
					this.numTourPrison = 0;
					System.out.println("Vous avez utilise votre carte sortie de prison. Vous sortez donc de prison et reprenez le cours de la partie normalement.");
				}
				else if (!(choix.equals("o")) && !(choix.equals("n")))
					System.out.println("Je n'ai pas compris, veuillez reessayer");
			}while (!(choix.equals("o")) && !(choix.equals("n")));
		}
		else
		{
			System.out.println("Souhaitez-vous payer 5000 € pour sortir de prison maintenant ?\nVous le ferez automatiquement dans " + (3 - numTourPrison) + " tour(s). o si oui, n sinon");
			do
			{
				choix = sc.nextLine();
				if(choix.equals("o"))
				{
					try {
						setArgentPossede(getArgentPossede() - 5000);
					}
					catch(JoueurRuineException e) {e.printStackTrace();}
					this.setEnPrison(false);
					this.numTourPrison = 0;
					System.out.println("Vous avez paye 5000 €. Vous sortez donc de prison et reprenez le cours de la partie normalement");
				}
				else if (!(choix.equals("o")) && !(choix.equals("n")))
					System.out.println("Je n'ai pas compris, veuillez reessayer");
			}
			while(!(choix.equals("o")) && !(choix.equals("n")));
		}
	}
	
	/**
	 * Méthode qui vérifie que le joueur construit uniformément ses maisons
	 * @param L : Liste des terrains dont il a un monopole et sur laquelle il peut construire
	 * @param indice : Terrain sur lequel il veut construire une nouvelle maison
	 */
	public boolean EstAutoriseAConstruire(ListeTerrains L, int indice)
	{
		boolean ok = true;
		int nb1 = L.get(indice).getNbMaisons() + 1;
		for (int i = 0; i < L.size(); i++)
		{
			if((((nb1) - L.get(i).getNbMaisons()) > 1))
				{
					ok = false;
				}
			
		}
		return ok;
	}
	
	/**
	 * Menu concernant la construction de maisons
	 * @param GroupeTerrains : liste de terrains dans laquelle le joueur veut construire une maison
	 * @throws JoueurRuineException : si le joueur n'a pas de thunes
	 */
	public void MenuConstructionMaison(ListeTerrains GroupeTerrains) throws JoueurRuineException
	{
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				String reponse;
				char a = 'a';
				do {
						System.out.println("Vous possédez tous les terrains " + GroupeTerrains.get(1).getCouleur() + "s , "
								+ "souhaitez vous acheter une maison ? o si oui, n sinon\n Prix de la maison : " + GroupeTerrains.get(0).getPrixMaison() + " €.");
						reponse = sc.nextLine();
						a = reponse.charAt(0);
						if (a == 'o')
						{
								System.out.println("Ou souhaitez-vous construire votre maison ?");
								if(GroupeTerrains.getTaille() == 2)
								{
									do
									{
										for(int i = 1; i <= 2; i++)
											{
												System.out.println("Tapez " + i + " pour construire votre maison sur " + GroupeTerrains.get(i-1).getNom());
											}
										reponse = sc.nextLine();
										a = reponse.charAt(0);
										if ((a != '1') && (a != '2'))
											System.out.println("Je n'ai pas compris, veuillez reessayer");
										else
										{
											if (EstAutoriseAConstruire(GroupeTerrains, a -'1'))
											{
											try {
												 GroupeTerrains.get(a - '1').ajouterMaison();
												 if (GroupeTerrains.get(a - '1').getNbMaisons() < 5)
													System.out.println("Vous avez construit une maison sur " + GroupeTerrains.get(a - '1').getNom() + 
															"\nVous avez donc desormais " + GroupeTerrains.get(a - '1').getNbMaisons() + " maison(s) sur " + GroupeTerrains.get(a - '1').getNom());
												else
													System.out.println("Vous avez construit un hotel sur " + GroupeTerrains.get(a - '1').getNom() + 
																"\nVous avez donc desormais un hotel sur " + GroupeTerrains.get(a - '1').getNom());
												 GroupeTerrains.get(a - '1').setLoyer();
												
											}
											catch (NBMaisonsException e){
												System.out.println("Vous avez atteint le maximum sur ce terrain");
											}						
											}
											else 
												System.out.println("Vous ne pouvez pas installer de maison à cette endroit la, "
														+ "completez les autres terrains avec des maisons.");
											System.out.println("Vous possédez désormais " + getArgentPossede() + " €.");
										}
									} while ((a != '1') && (a != '2'));
								}
								else
								{
									do
									{
										for(int i = 0; i <= 3; i++)
										{
												System.out.println("Tapez " + i + " pour construire votre maison sur " + GroupeTerrains.get(i-1).getNom());
										}
										reponse = sc.nextLine();
										a = reponse.charAt(0);
										if ((a != '1') && (a != '2') && (a != '3'))
											System.out.println("Je n'ai pas compris, veillez reessayer");
										else
										{
											try {
												if (EstAutoriseAConstruire(GroupeTerrains, a -'1'))
													GroupeTerrains.get(a - '1').ajouterMaison();
												else 
													System.out.println("Vous ne pouvez pas installer de maison à cette endroit la, completez les autres terrains avec des maisons.");
												if (GroupeTerrains.get(a - '1').getNbMaisons() < 5)
													System.out.println("Vous avez construit une maison sur " + GroupeTerrains.get(a - '1').getNom() + 
														"\nVous avez donc desormais " + GroupeTerrains.get(a - '1').getNbMaisons() + " maison(s) sur " + GroupeTerrains.get(a - '1').getNom());
												else
													System.out.println("Vous avez construit un hotel sur " + GroupeTerrains.get(a - '1').getNom() + 
															"\nVous avez donc desormais un hotel sur " + GroupeTerrains.get(a - '1').getNom());
												GroupeTerrains.get(a - '0').setLoyer();
											}
											catch (NBMaisonsException e){
												System.out.println("Vous avez atteint le nombre maximum de maisons d'hotels sur ce terrain");
											}
										}
									} while ((a != '1') && (a != '2') && (a != '3'));
								}
							}
						else if ((a != 'o') && (a!= 'n'))
							System.out.println("Je n'ai pas compris, veillez reessayer");
					} while ((a != 'o') && (a != 'n'));
		}
	
	/**
	 * Menu qui s'affiche lorsque le joueur possède un monopole et peut donc construire des maisons
	 * @throws JoueurRuineException : si le joueur n'a plus de thunes
	 */
	public void MenuProprietaire() throws JoueurRuineException
	{
		if (peutConstruire())
		{
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String reponse;
			char a = 'a';
			do
			{
				if (aTousTerrainsCouleur(terrainsRoses))
					MenuConstructionMaison(terrainsRoses);
				if (aTousTerrainsCouleur(terrainsCyan))
					MenuConstructionMaison(terrainsCyan);
				if (aTousTerrainsCouleur(terrainsViolet))
					MenuConstructionMaison(terrainsViolet);
				if (aTousTerrainsCouleur(terrainsOranges))
					MenuConstructionMaison(terrainsOranges);
				if (aTousTerrainsCouleur(terrainsRouges))
					MenuConstructionMaison(terrainsRouges);
				if (aTousTerrainsCouleur(terrainsJaunes))
					MenuConstructionMaison(terrainsJaunes);
				if (aTousTerrainsCouleur(terrainsVerts))
					MenuConstructionMaison(terrainsVerts);
				if (aTousTerrainsCouleur(terrainsBleus))
					MenuConstructionMaison(terrainsBleus);
				System.out.println("Souhaitez vous acheter une autre maison ? o si oui, n sinon");
				reponse = sc.nextLine();
				a = reponse.charAt(0);
				if ((a != 'o') && (a!= 'n'))
					System.out.println("Je n'ai pas compris, veillez reessayer");
			}while ((a != 'o') && (a != 'n'));
		}
	}
}
