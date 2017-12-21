package Jeu;

/**
 * Abstraction d'une case d'un plateau de jeu
 * 
 * @author Alexandre Ludwig et Arnaud Couderc
 *
 */
public abstract class Case 
{
	 /**
	 * Nom de la case
	 */
	private String nom;
	 /**
	 * Position horizontale
	 */
	private int x;
	  /**
	 * Position verticale
	 */
	private int y;
	  /**
	 * Numéro de position dans le pateau
	 */
	private int numPosition;
	
	public Case(String nom, int x, int y, int position){
	    setX(x);
	    setY(y);
	    setNom(nom);
	    setNumPosition(position);
	}
	 /**
	 * Getter : Renvoie le nom de la case
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Setter : Définit le nom de la case
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Revoie x la position horizontale de la case
	 * @return x
	 */
	public int getX() {
	    return x;
	  }
	  
	 /**
	  * Setter : Définit x la position horizontale de la case
	 * @param x
	 */
	public void setX(int x) {
	    this.x = x;
	  }
	  
	/**
	 * Revoie y la position verticale de la case
	 * @return y
	 */
	public int getY() {
	    return y;
	  }
	  
	/**
	  * Setter : Définit y la position verticale de la case
	 * @param y
	 */
	public void setY(int y) {
	    this.y = y;
	  }
	
	 /**
	 * Getter : Revoie la position dans le plateau
	 * @return
	 */
	public int getNumPosition() {
		    return numPosition;
		  }
	 /**
	 * Setter : Définit la position dans le plateau
	 * @param position
	 */
	public void setNumPosition(int position) {
		    this.numPosition = position;
	}
	 /* 
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	  {
		  return this.nom + " : Coordonnees [ x: " + this.x + ", y: " + this.y + " ] la case est occupee";
	  }
	  
	 /**
	 * @param o : objet comparé
	 */
	public boolean equals(Object o)
	{
		if (o == this)
			return true;
		if(o == null) 
			return false;
		if (getClass() == o.getClass())
		{
			Case c = (Case) o;
			if (this.nom.equals(c.nom))
			{
				if(this.x == c.x)
				{
					if (this.y == c.y)
					{
						return this.numPosition == c.numPosition;
					}
				}
						
				return false;
			}
			return false;
		}
		return false;
	}
}