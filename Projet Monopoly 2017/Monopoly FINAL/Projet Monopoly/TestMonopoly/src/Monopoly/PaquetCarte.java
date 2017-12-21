package Monopoly;

/**
 * @author Alexandre Ludwig et Arnaud Couderc
 *
 */
public class PaquetCarte {
	/**
	 * Paquet de 10 cartes (Tableau)
	 */
	private Carte [] paquet = new Carte[10];
	/**
	 * indice du paquet du paquet de carte (tableau)
	 */
	private int index = 0;
	
	/**
	 * Initialise un paquet de carte en fonction du type (Chance ou caisse de communauté)
	 * @param type
	 */
	public PaquetCarte(String type) {
		if(type.equals("Caisse de communauté"))
		{
			this.paquet[0] = new CarteGainPerte(type, "a une erreur de la banque en sa faveur", 20000);
			this.paquet[1] = new CarteLibererJail(type, "est libere de prison");
			this.paquet[2] = new CarteDeplacement(type, "avance de 3 cases", 3);
			this.paquet[3] = new CarteGainPerte(type, "recoit son héritage", 10000);
			this.paquet[4] = new CarteGainPerte(type, "paye ses frais medicaux", -5000);
			this.paquet[5] = new CarteGainPerte(type, "recoit ses interets annuels", 10000);
			this.paquet[6] = new CarteDeplacement(type, "recule de 2 cases", -2);
			this.paquet[7] = new CarteTeleportation(type, "est téeleporte Rue Lecourbe", 3);
			this.paquet[8] = new CarteTeleportation(type, "est teleporte Boulevard de Belleville", 1);
			this.paquet[9] = new CarteGoToJail(type, "va en prison");
		}
		if(type.equals("Chance"))
		{
			this.paquet[0] = new CarteGainPerte(type, "recoit ses dividendes", 5000);
			this.paquet[1] = new CarteLibererJail(type, "est libere de prison");
			this.paquet[2] = new CarteGainPerte(type, "Vos prêts immobiliers raportent", 2000);
			this.paquet[3] = new CarteDeplacement(type, "avance de 2 cases", 2); 
			this.paquet[4] = new CarteGainPerte(type, "recoit une amende pour ivresse", -2000);
			this.paquet[5] = new CarteGainPerte(type, "doir payer ses frais de scolarite", -1500);
			this.paquet[6] = new CarteDeplacement(type, "recule de 2 cases", -2);
			this.paquet[7] = new CarteTeleportation(type, "est teleporte Rue de la paix", 39);
			this.paquet[8] = new CarteTeleportation(type, "est teleporte Avenue Henri Martin", 24);
			this.paquet[9] = new CarteGoToJail(type, "va en prison.");
		}
		melangerPaquet();
	}
	
	/**
	 * Méthode qui mélange le paquet
	 */
	public void melangerPaquet() {
		int longPaquet = paquet.length;
	    for (int i = 0; i < longPaquet; i++) {
	        int r = (int) random(0, longPaquet);
	        Carte tmp = paquet[i];
	        paquet[i] = paquet[r];
	        paquet[r] = tmp;
	    }
	}
	      
	/**
	 * Méthode qui donne un nombre aléatoire entre min et max
	 * @param min
	 * @param max
	 */
	private static double random(double min, double max) {
	    return min + Math.random() * (max - min);
	}
	
	/**
	 * LE joueur j tire une carte d'un paquet p 
	 * @param j
	 * @param p
	 */
	public void tirerCarte(JoueurMonopoly j, Partie p)
	{
		paquet[index].Effet(j,p);
		if(index == 9)
		{
			melangerPaquet();
			index = 0;
		}
		else
		{
			index ++;
		}
	}
	
	

}
