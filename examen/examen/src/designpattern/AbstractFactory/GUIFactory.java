/*
 * GUIFactory example
 */
public abstract class GUIFactory
{
  public static GUIFactory getFactory()
  {
    //on verifie qu'on est soit un sur un systeme windows sur un un syteme mac et on retourne la bonne usine
    int sys = readFromConfigFile("OS_TYPE");
    if (sys == 0)
      return(new WinFactory());
    else
      return(new OSXFactory());
  }
  public abstract Button createButton();
}
