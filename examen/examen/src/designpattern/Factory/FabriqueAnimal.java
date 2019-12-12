public class FabriqueAnimal
{
  private static FabriqueAnimal instance = new FabriqueAnimal();

  private FabriqueAnimal() {}

  public static FabriqueAnimal getFabriqueAnimalInstance() {
    return instance;
  }

  public Animal getAnimal(String typeAnimal) throws ExceptionCreation
  {
    if (typeAnimal.equals("chat"))
      return new Chat();
    else if (typeAnimal.equals("chien"))
      return new Chien();
    else
      throw new ExceptionCreation("Impossible de créer un " + typeAnimal);
  }
}
