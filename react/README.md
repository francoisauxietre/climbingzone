Projet avec modele metier en springBoot et le Dom en React, Vue, Angular
Arborescence de notre projet
demoSpring
    |- demospring (partie Back-end)
    |- react-escalade (partie Front-end)
    |- angular-escalade (partie Front-end)
    |- vue-escalade(partie Front-end)
    
L'idee de ce projet est d'utiliser toutes ces nouvelles technos et d'essayé au maximum de les combiner
entre elles. L'utilisation et la finalisation se fera avec dockers et si nous avons le temps 
un essai sur un site déporté sera fait.

Pour apprendre et comprendre toutes ces nouvelles technos nous avons choisi un modèle métier assez simple.

Une api avec Swagger est developpé dans la partie demospring
l'utilisation de github pour les push commit et autre
(Le code sera en Anglais mais les commentaires seront souvent en français)

Le but de notre projet était de faire un jeu en escalade:
    En effet dans la communanuté de grimpeur, peu voir pas de projet ,permettent au grimpeurs de sauvegarder
    l'ensemble de leurs réalisations sous forme de Carte jouables.
    L'idée est de faire un site web attrayant et facile d'utilisation leur permettant de voir leur
    progression (Editer imprimer des cartes)
    Une carte comprendra plusieurs éléments :Une photographie, des éléments sur le grimpeur, la voie(niveau, lieu, difficulté)
    Chaque nouvel utilisateur non logger : pourra voir la liste des réalisations des meilleurs grimpeurs (All of Fame)
    chaque utilisateur enregistrer pourra acceder à notre API:
        Utilisateur:
            Ajouter ou suprimer un Ami
            Voir les réalisations de ceux-ci
            Voir sa collection de carte et les imprimer
            Inviter un ami à un évenement
        Voie
            Ajouter modifier
        
    Un administrateur pourra s'occuper des utilisateurs (ajout modification supression etc)
    Créer un évenement (un évenement correspond à une voie disponible pendant un laps de temps déterminé)
    
  Dockers créer pour ce projet :
  ## react-docker-escalade
  pour le construire
  docker build -t react-docker-escalade .
  pour le lancer
  docker run -it -p 9001:3000 react-docker-escalade
  ##

    

Installation faite pour ce projet:

npm install @material-ui/core
npm install @material-ui/icons --save
npm install @material-ui/system --save

http request
npm install superagent --save

ajout de Lodash pour charger des tableaux string etc
npm install --save lodash

a ajouter pour les graphiques
// npm i @bit/primefaces.primereact.chart -- save 
police coorespondant au bouton
npm install typeface-roboto --save


