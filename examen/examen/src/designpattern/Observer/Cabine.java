class Cabine implements IObservateur
{
  public void notifier()
  {
    System.out.println("Cabine a recu la notif");
    // Changement d'étage selon son sens et sa position précédente.
  }
}
