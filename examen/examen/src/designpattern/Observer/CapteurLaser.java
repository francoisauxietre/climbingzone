class CapteurLaser extends Observable
{
  private boolean m_detecteVariation;
  // Le code de la boucle while en environnement Threadé
  public void run()
  {
    while(true)
    {
      if(m_detecteVariation)
        notifierObservateurs();
    }
  }


}
