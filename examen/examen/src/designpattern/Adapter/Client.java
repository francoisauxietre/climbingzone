/// <summary> "Client" qui n'utilise que les objets qui respectent la signature </summary>
class Client
{
  public void Utiliser(IDeveloppeur developpeur)
  {
    System.out.println(developpeur.EcrireCode());
  }

  public static void Main()
  {
    Client client = new Client();

    IDeveloppeur developpeur1 = new DeveloppeurLambda();
    client.Utiliser(developpeur1);

    Architecte architecte = new Architecte();
    IDeveloppeur developpeur2 = new Adaptateur(architecte);
    client.Utiliser(developpeur2);
  }
}
