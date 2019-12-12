public class Cookie implements Cloneable
{
  public Cookie clone()
  {
    try {
      Cookie copy = (Cookie)super.clone();
      // Dans une implémentation réelle de ce patron de conception, il faudrait
      // créer la copie en dupliquant les objets contenus et en attribuants des
      // valeurs valides (exemple : un nouvel identificateur unique pour la copie).
      return copy;
    } catch (CloneNotSupportedException e) {
      return null;
    }
  }
}
