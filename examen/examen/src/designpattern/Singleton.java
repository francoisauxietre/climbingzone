public class Singleton {
  private static Singleton INSTANCE = null;

  /*
   * La présence d'un constructeur privé supprime
   * le constructeur public par défaut.
   */
  private Singleton() {}

  /*
   * Le mot-clé synchronized sur la méthode de création
   * empêche toute instanciation multiple même par
   * différents threads.
   * Retourne l'instance du singleton.
   */
  public synchronized static Singleton getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new Singleton();
    }
    return INSTANCE;
  }
}
//Le singleton est un patron de conception dont l'objet est de restreindre l'instanciation d'une classe à un seul objet
// (ou bien à quelques objets seulement). Il est utilisé lorsque l'on a besoin d'exactement un objet pour coordonner des
// opérations dans un système. Le modèle est parfois utilisé pour son efficacité, lorsque le système est plus rapide ou
// occupe moins de mémoire avec peu d'objets qu'avec beaucoup d'objets similaires.
//
//  On implémente le singleton en écrivant une classe contenant une méthode qui crée une instance uniquement s'il n'en
//  existe pas encore. Sinon elle renvoie une référence vers l'objet qui existe déjà. Dans beaucoup de langages de type
//  objet, il faudra veiller à ce que le constructeur de la classe soit privé ou bien protégé, afin de s'assurer que la
//  classe ne puisse être instanciée autrement que par la méthode de création contrôlée.
//
//  Le singleton doit être implémenté avec précaution dans les applications multi-thread. Si deux processus légers
//  exécutent en même temps la méthode de création alors que l'objet unique n'existe pas encore, il faut absolument
//  s'assurer qu'un seul créera l'objet, et que l'autre obtiendra une référence vers ce nouvel objet.
//
//  La solution classique à ce problème consiste à utiliser l'exclusion mutuelle pour indiquer que l'objet est en cours
//  d'instanciation.
//
//  Dans un langage à base de prototypes, où sont utilisés des objets mais pas des classes, un singleton désigne
//  seulement un objet qui n'a pas de copies, et qui n'est pas utilisé comme prototype pour d'autres objets.
