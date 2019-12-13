class CompositeGraphic implements Graphic
{
  //Collection de graphiques enfants.
  private ArrayList<Graphic> listGraphics = new ArrayList<Graphic>();

  //Imprime le graphique.
  public void print()
  {
    for (Graphic graphic : listGraphics)
    {
      listGraphics
      graphic.print();
    }
  }

  //Ajoute le graphique à la composition.
  public void add(Graphic graphic)
  {
    listGraphics.add(graphic);
  }

  //Retire le graphique de la composition.
  public void remove(Graphic graphic)
  {
    listGraphics.remove(graphic);
  }

}
