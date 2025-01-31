package Jeu;

import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public abstract class Piece extends JButton implements MouseListener
{
  private String couleur;
  private int x;
  private int y;
  private ImageIcon cliquable;
  private ImageIcon nonCliquable;
  
  public Piece()
  {
    setIcon(nonCliquable);
  }
  
  public ImageIcon getCliquable() {
    return cliquable;
  }
  
  public void setCliquable(String img) {
    cliquable = new ImageIcon(img);
  }
  
  public ImageIcon getNonCliquable() {
    return nonCliquable;
  }
  
  public void setNonCliquable(String img) {
    nonCliquable = new ImageIcon(img);
  }
  
  public Piece(String c) {
    couleur = c;
  }
  
  public String getCouleur() {
    return couleur;
  }
  
  public void setCouleur(String couleur) {
    this.couleur = couleur;
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
  
  public void setY(int y) { this.y = y; }
  
  public abstract void deplacer(int paramInt);
  
  public String toString()
  {
    return "Piece [couleur=" + couleur + ", x: " + x + ", y: " + y + "]";
  }
  
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof Piece))
      return false;
    Piece other = (Piece)obj;
    if (couleur == null) {
      if (couleur != null)
        return false;
    } else if (!couleur.equals(couleur))
      return false;
    if (x != x)
      return false;
    if (y != y)
      return false;
    return true;
  }
}