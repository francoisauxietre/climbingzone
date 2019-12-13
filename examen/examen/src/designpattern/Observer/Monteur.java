class Moteur implements IObservateur
{
  public void notifier()
  {
    System.out.println("Moteur a recu la notif");
    // Verification que l'étage soit dans les bornes autorisées.
  }
}
