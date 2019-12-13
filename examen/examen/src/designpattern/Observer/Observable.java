class Observable
{

  public Observable()
  {
    m_observateurs = new LinkedList<IObservateur>();
  }

  public void notifierObservateurs()
  {
    Iterator<IObservateur> it = m_observateurs.iterator();
    // Notifier tous les observers
    while(it.hasNext()){
      IObservateur obs = it.next();
      obs.notifier();
    }
  }

  void ajouterObservateur(IObservateur observateur)
  {
    // On ajoute un abonné à la liste en le plaçant en premier (implémenté en pull).
    // On pourrait placer cet observateur en dernier (implémenté en push, plus commun).
    m_observateurs.add(observateur);
  }

  void supprimerObservateur(IObservateur observateur)
  {
    // Enlever un abonné a la liste
    m_observateurs.remove(observateur);
  }

  private List<IObservateur> m_observateurs;
}
