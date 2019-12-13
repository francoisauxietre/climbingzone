/* Client 1 uses one algorithm (Brake) in the constructor */
public class Volvo extends Car {
  public Volvo() {
    super(new Brake());
  }
}
