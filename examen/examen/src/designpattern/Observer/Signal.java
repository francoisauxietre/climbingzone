// Exemple tiré de wikipédia
class Signal extends Observable {

  void setData(byte[] lbData){
    setChanged(); // Positionne son indicateur de changement
    notifyObservers(); // (1) notification
  }
}
/*
    On crée le panneau d'affichage qui implémente l'interface java.util.Observer.
    Avec une méthode d'initialisation (2), on lui transmet le signal à observer (2).
    Lorsque le signal notifie une mise à jour, le panneau est redessiné (3).*/

class JPanelSignal extends JPanel implements Observer {

  void init(Signal lSigAObserver) {
    lSigAObserver.addObserver(this); // (2) ajout d'observateur
  }

  void update(Observable observable, Object objectConcerne) {
    repaint();  // (3) traitement de l'observation
  }
}
