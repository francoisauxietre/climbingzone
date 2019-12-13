class Regulateur extends DecorateurVoiture{
  public Regulateur(Voiture v) { voiture = v);
    public String getLibelle() { return voiture+getLibelle() + " Regulateur "; }
    public int getPrix() {return voiture.getPrix() + 200;}
    public int getPoids() {return voiture.getPoids() + 1;}
  }
