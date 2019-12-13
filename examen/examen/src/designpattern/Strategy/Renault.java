/* Client 2 uses another algorithm (BrakeWithABS) in the constructor */
public class Renault extends Car {
  public Renault() {
    super(new BrakeWithABS());
  }
}
