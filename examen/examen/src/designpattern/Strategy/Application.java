/* Using the Car example */
public class Application {
  public static void main(final String[] arguments) {
    Car volvo = new Volvo();
    volvo.applyBrake();  // This will invoke class "Brake"

    Car renault = new Renault();
    renault.applyBrake();    // This will invoke class "BrakeWithABS"

    // set brake behavior dynamically
    renault.setBrakeBehavior( new Brake() );
    renault.applyBrake();    // This will invoke class "Brake"
  }
}
