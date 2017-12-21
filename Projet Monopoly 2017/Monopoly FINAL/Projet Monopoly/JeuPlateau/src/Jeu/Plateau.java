package Jeu;

import java.util.Arrays;


public class Plateau
{
  public static final int LARGEUR = 15;
  public static final int HAUTEUR = 15;
  public Case[][] damier;
  
  public Plateau() {
    initPlateau();
  }
  
  private void initPlateau() {
    for (int y = 0; y < 15; y++)
      for (int x = 0; x < 15; x++)
        damier[x][y] = new Case(x, y);
  }
  
  public String toString() {
    return "Plateau [damier=" + Arrays.toString(damier) + "]";
  }
  
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Plateau other = (Plateau)obj;
    if (!Arrays.deepEquals(damier, damier))
      return false;
    return true;
  }
}