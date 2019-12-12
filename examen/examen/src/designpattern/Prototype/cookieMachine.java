/* Classe utilisatrice */
public class CookieMachine
{
  private Cookie cookie; // peut aussi être déclaré comme : private Cloneable cookie;

  public CookieMachine(Cookie cookie)
  {
    this.cookie = cookie;
  }

  public Cookie makeCookie()
  {
    return cookie.clone();
  }

  public static void main(String args[])
  {
    Cookie           tempCookie =  null;
    Cookie        coconutCookie = new CoconutCookie();
    CookieMachine cookieMachine = new CookieMachine(prot);

    for (int i=0; i<100; i++)
      tempCookie = cookieMachine.makeCookie();
  }
}
