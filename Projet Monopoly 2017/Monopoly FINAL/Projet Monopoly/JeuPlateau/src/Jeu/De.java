package Jeu;

public class De
{
  private int valeurDe;
  
  public De() {}
  
  public int getValeurDe()
  {
    return valeurDe;
  }
  
  public void lancer() throws InterruptedException {
    valeurDe = ((int)(1.0D + 6.0D * Math.random()));
  }
  
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    De other = (De)obj;
    if (valeurDe != valeurDe)
      return false;
    return true;
  }
  
  public String toString() {
    return "Valeur du dé = " + valeurDe;
  }
}
