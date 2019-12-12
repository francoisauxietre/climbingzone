public class FabriqueExemple{
  public static void main(String [] args){
    FabriqueAnimal fabrique =  FabriqueAnimal.getFabriqueAnimalInstance();
    try {
      Animal animal = fabrique.getAnimal("chien");
      animal.myName();
    } catch(ExceptionCreation e) {
      e.printStackTrace();
    }
  }
}
