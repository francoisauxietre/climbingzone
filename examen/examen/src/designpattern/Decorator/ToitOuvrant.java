class ToitOuvrant extends DecorateurVoiture{
  public ToitOuvrant(Voiture v) { voiture = v;}
  public String getLibelle() { return voiture.getLibelle() + " Toit Ouvrant "; }
  public int getPrix() {return voiture.getPrix() + 2000;}
  public int getPoids() {return voiture.getPoids() + 15;}
}
