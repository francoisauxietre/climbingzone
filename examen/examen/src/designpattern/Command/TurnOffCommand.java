/* Commande concrète pour éteindre la lumière */
public class TurnOffCommand implements Command
{
  private Light theLight;

  public TurnOffCommand(Light light)
  {
    this.theLight=light;
  }

  public void execute()
  {
    theLight.turnOff();
  }
}
