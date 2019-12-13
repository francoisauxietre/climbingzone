/* Commande concrète pour allumer la lumière */
public class TurnOnCommand implements Command
{
  private Light theLight;

  public TurnOnCommand(Light light)
  {
    this.theLight=light;
  }

  public void execute()
  {
    theLight.turnOn();
  }
}
