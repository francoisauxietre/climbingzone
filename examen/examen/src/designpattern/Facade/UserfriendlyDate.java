/* Façade */
class UserfriendlyDate
{
  GregorianCalendar gcal;

  public UserfriendlyDate(String isodate_ymd)
  {
    String[] a = isodate_ymd.split("-");
    gcal = new GregorianCalendar(
      Integer.parseInt(a[0]),    // année
      Integer.parseInt(a[1])-1,  // mois (0 = Janvier)
      Integer.parseInt(a[2]) );  // jour
  }

  public void addDays(int days)
  {
    gcal.add(Calendar.DAY_OF_MONTH, days);
  }

  public String toString()
  {
    return String.format("%1$tY-%1$tm-%1$td", gcal);
  }
}
