package Jeu;

import java.awt.Panel;

public class Case extends Panel
{
  private int x;
  private int y;
  private boolean estVide = true;
  

  public Case() {}
  

  public Case(int x, int y)
  {
    setX(x);
    setY(y);
  }
  
  public int getX() {
    return x;
  }
  
  public void setX(int x) {
    this.x = x;
  }
  
  public int getY() {
    return y;
  }
  
  public void setY(int y) {
    this.y = y;
  }
  
  public boolean isEstVide() {
    return estVide;
  }
  
  public void setEstvide(boolean estVide) {
    this.estVide = estVide;
  }
  
  public String toString()
  {
    if (estVide) {
      return "Coordonnees [ x: " + x + ", y: " + y + " ] la case est vide";
    }
    return "Coordonnees [ x: " + x + ", y: " + y + " ] la case est occupée";
  }
  
  public boolean equals(Case c) {
    if(this.x == c.getX())
    	return (this.y == c.getY());
    else
    	return false;
  }
}
