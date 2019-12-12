/* Un client commandant une pizza. */
class Application
{
  public static void main(String[] args)
  {
    Serveur serveur = new Serveur();
    MonteurPizza monteurPizzaHawaii  = new MonteurPizzaHawaii();
    MonteurPizza monteurPizzaPiquante = new MonteurPizzaPiquante();

    serveur.setMonteurPizza(monteurPizzaHawaii);
    serveur.construirePizza();

    Pizza pizza = serveur.getPizza();
  }
}
