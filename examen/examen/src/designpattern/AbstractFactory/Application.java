public class Application
{
  public static void main(String[] args)
  {
    GUIFactory guiFactory = GUIFactory.getFactory();
    Button aButton = guiFactory.createButton();
    aButton.setCaption("Play");
    aButton.paint();
  }
  // affiche :
  //   I'm a WinButton: Play
  // ou :
  //   I'm a OSXButton: Play
}
