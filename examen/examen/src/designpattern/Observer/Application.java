public class Application {

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    Cabine instanceCabine = new Cabine();
    Moteur instanceMoteur = new Moteur();

    CapteurLaser capteurEtage = new CapteurLaser();;

    capteurEtage.ajouterObservateur(instanceCabine);
    capteurEtage.ajouterObservateur(instanceMoteur);

    // On simule manuellement une variation (normalement c'est le thread qui s'en charge)
    capteurEtage.notifierObservateurs();

    // La cabine et le moteur ont reçu une notification sur leur méthode notifier()

    capteurEtage.supprimerObservateur(instanceMoteur);
    System.out.println("Suppression du moteur dans les abonnes");

    capteurEtage.notifierObservateurs();
  }
}
