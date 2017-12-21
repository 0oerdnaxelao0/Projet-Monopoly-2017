package Monopoly;
import Jeu.*;
/**
 * @author Alexandre Ludwig et Arnaud Couderc
 *
 */
public class PlateauMonopoly extends Plateau{

	/**
	 * Initialisation du plateau avec les cases du monopoly
	 */
	public PlateauMonopoly()
	{		
		super(40);
		setPosition(0, new Depart());
		
		setPosition(1, new Terrain("Boulevard de belleville", 0, 1, 1, 200,1000,3000,9000,16000,25000, 5000, "rose", 5000));
		setPosition(2, new CaisseCommunaute(0, 2, 2));
		setPosition(3, new Terrain("Rue lecourbe", 0, 3, 3, 400, 2000, 6000, 18000, 32000, 45000 ,5000,"rose", 5000));
		setPosition(4, new Taxe("Impots sur le revenu", 0, 4, 4, 20000));
		setPosition(5, new Gare("Montparnasse", 0, 5, 5, 5000, 20000));
		setPosition(6, new Terrain("Rue de Vaugirard", 0, 6, 6, 600, 3000, 9000, 27000, 40000, 55000, 5000, "cyan", 5000));
		setPosition(7, new Chance(0, 7, 7));
		setPosition(8, new Terrain("Rue de courcelles", 0, 8, 8, 600, 3000, 9000, 27000, 40000, 55000, 5000, "cyan", 5000));
		setPosition(9, new Terrain("Avenue de la republique", 0, 9, 9, 800, 4000, 10000, 30000, 45000, 60000, 5000, "cyan", 5000));
		
		setPosition(10, new Jail());
		
		setPosition(11, new Terrain("Boulevard de la villette", 1, 10, 11, 1000, 5000, 15000, 45000, 62500,75000,5000, "violet", 10000));
		setPosition(12, new ServicePublic("Compagnie de distribution d'électricité", 2, 10, 12, 3750, 15000));
		setPosition(13, new Terrain("Avenue de neuilly", 3, 10, 13, 1000, 5000, 15000, 45000, 62500, 75000, 10000, "violet", 10000));
		setPosition(14, new Terrain("Rue de paradis", 4, 10, 14, 1200, 6000, 18000, 50000, 70000, 90000, 10000, "violet", 10000));
		setPosition(15, new Gare("de Lyon", 5, 10, 15, 5000, 20000));
		setPosition(16, new Terrain("Avenue Mozart", 6, 10, 16, 1400, 7000, 20000, 55000, 75000, 95000, 10000, "orange", 10000));
		setPosition(17, new CaisseCommunaute(7, 10, 17));
		setPosition(18, new Terrain("Boulevard Saint Michel", 8, 10, 18, 1400, 7000, 20000, 55000, 75000, 95000, 10000, "orange", 10000));
		setPosition(19, new Terrain("Place Pigalle", 9, 10, 19, 1600, 8000, 22000, 60000, 80000, 100000, 10000, "orange", 10000));
		
		setPosition(20, new ParcGratuit());
		
		setPosition(21, new Terrain("Avenue Matignon",10, 9, 21, 1800, 9000, 25000, 70000, 87500, 105000, 15000, "rouge", 15000));
		setPosition(22, new Chance(10, 8, 22));
		setPosition(23, new Terrain("Boulevard Malesherbes",10 , 7, 23, 1800, 9000, 25000, 70000, 87500, 105000, 15000, "rouge", 15000));
		setPosition(24, new Terrain("Avenue Henri-Martin", 10, 6, 24, 2000, 10000, 30000, 75000, 92500,110000, 15000, "rouge", 15000));
		setPosition(25, new Gare("du Nord", 10, 5, 25, 5000, 20000));
		setPosition(26, new Terrain("Faubourg Saint honoré", 10, 4, 26, 2200, 11000, 33000, 80000, 97500, 115000, 15000, "jaune", 15000));
		setPosition(27, new Terrain("Place de la bourse", 10, 3, 27, 2200, 11000, 33000, 80000, 97500, 115000, 15000, "jaune", 15000));
		setPosition(28, new ServicePublic("Compagnie de distribution des eaux", 10, 2, 28, 3750, 15000));
		setPosition(29, new Terrain("Rue la fayette", 10, 1, 29, 2400, 12000, 36000, 85000, 102500, 120000, 15000, "jaune", 15000));
		
		setPosition(30, new GoToJail());
		
		setPosition(31, new Terrain("Avenue de Berteuil", 9, 0, 31, 2600, 13000, 39000, 90000, 110000, 127500, 20000, "vert", 20000));
		setPosition(32, new Terrain("Avenue foch", 8, 0, 32, 2600, 13000, 39000, 90000, 110000, 127500, 20000, "vert", 20000));
		setPosition(33, new CaisseCommunaute(7, 0, 33));
		setPosition(34, new Terrain("Boulevard des capucins", 6, 0, 34, 2800, 15000, 45000, 100000, 120000, 140000, 20000, "vert", 20000));
		setPosition(35, new Gare("Saint-Lazaire", 5, 0, 35, 5000, 20000));
		setPosition(36, new Chance(4, 0, 36));
		setPosition(37, new Terrain("Avenue des champs-Elysees", 3, 0, 37, 3500, 17500, 50000, 110000, 130000, 150000, 20000, "bleu", 20000));
		setPosition(38, new Taxe("Taxe de Luxe", 2, 0, 38, 10000));
		setPosition(39, new Terrain("Rue de la paix", 1, 0, 39, 5000, 20000, 60000, 140000, 170000, 200000, 20000, "bleu", 20000));
		
	}
}
