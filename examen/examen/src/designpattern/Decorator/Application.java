public class Application
{
  // Méthode principale.
  public static void main(String[] args)
  {
    Voiture v1 = new Corsa();
    System.out.println(v1);

    Voiture v2 = new C2();
    v2 = new Regulateur(v2);
    System.out.println(v2);

    Voiture v3 = new Corsa();
    v3 = new ToitOuvrant(v3);
    v3 = new GPS(v3);
    System.out.println(v3);
  }
}
