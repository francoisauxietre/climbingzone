![hello_Min](https://user-images.githubusercontent.com/55358842/68070716-06946b80-fd72-11e9-94bb-4e06b9f30141.jpg)

## Base de donnée 

lancement: dans le repertoire zone (le docker-compose gere la base de donnee en msql sur le  port 3009 grace au docker compose 
<pre><code>docker-compose up</code></pre>
**Lombok** 
tres utile pour alléger les classes sans devoir réecrire sans cesse tous les getters and setters.

Différents ReadMe: https://github.com/francoisauxietre/climbingzone/tree/master/zone


-----------------
###  MOTS CLES APPRIS PENDANT LES ANNEES A L'ISTIC
###  A:
* ANGULAR 2 framework basé sur de Javascript 
* ANGULAR JS autre
* ARCHITECTURE LOGICIELLE  desciption schematique ou symbolique des elements d'un ou plusieurs systeme informatique
leurs interralations et leurs interactions. une analyse fonctionelle decrit quoi faire 
une architecture decrit comment le faire
###  B:
* BACK-END programme traitant les données et par exemple accès à une base de donnee(ex avec spring boot java)
###  C:
* CLASS comment seront fait les objets que l'on créera (MOULE) un cllass est une table en database
* CRUD create Read Update Delete
###  D:
* DOM Document Object Model interface normalise qui permet de modifier le navigateur web avec des script
* DOM virtuel dans vuejs et react on a un dom virtuel qui est une copie virtuel du dom actuel
* DAO Data Acces Object  object qui peuvent dialoguer en java avec une base de donnée directement
* DTO Data Transfer acces  pour les transfer des données par exemple entre angular et react
### E:
* ENTITY en jpa @ENTITY permet a jpa de creer nos tables et colonnes (une colonne par propertie)
### F:
* FRAMEWORK infrastructure logicielle, socle d'applications, infrastructure de développement
* FRONT-END la partie qu code qui sera generé dans le Browser pour les vues..
### G:
### H:
* Http HyperText Transfer Protocol  protocol de transfert de données en texte
### I:
* ID index pour etre une clé primaire dans la table poue savoir comment indexer et trouver les donnes (rangements)
* ID @id clé primaire
* INSTANCE une representation d'un object un instance
### J:
* JEE : serveur jEE permettent de mettre en place une application en la divisant en trois niveau
***niveau présentation() interface graphique pour l'utilisateur
***miveau metier logique metier ou logique aplicative (les classes representant les données)
    faite ici en spring
***niveau données (les données de l'application) (serveur bdd, documents xml...)
* JAVA  language de prog (Objet)
* JPA java persistance Acces  (couche relation mapping entre un objet java et une base de donnee)
* JDBC
* JWT jason web token  (le token utile pour l'authentification d'un utilisateur)(header, payload, signature)

### L:
LOMBOX surcouhe avec annotation wui permet de reduire énormement les getters et setters et Hashcode et toString
### M:
* MAP mapper les donner les mettre en relation
* mapping entre les objets Dto et les Dao avec MAPSTRUCT https://mapstruct.org/ 
* MYSQL Style de base de donnee comme mongoDB, PostGrel
### O:
* OBJECT objet cree grace à une classe 
* ORM object relation mapping object pour lier 
* OBSERVABLE un objet que l'on peut ecouter  PATTERN OBSERVER
* OBSERVER celui qui suit l'état d'un objet
### P:
* PATRON DE CONCEPTION ensemble de point de vue, arrangement de module reconnu comme bonne pratique
    = une solution standard répodant a des problèmes récurents. (le nom du patron sert de vocabulaire entre les programmeurs)
* P.ADAPTATEUR (adapter)convertir un interface d'une classe dans une autre intreface exploitee par une application
* P.FARIQUE (factory)fournit un interface pour créer des familles d'objets, une fabrique retourne une instance d'une classe parmi plusieurs possiles.
* P.FRABRIQUE ABSTRAITE (abstract factory)est utilisee pour obtenir un jeu d'objets connexes( ex chartre graphique  pour indows mac...)
* P.PONT (bridge) divise une implementation en deux parties, une classe qui defini le problème à resoudre, une classe
    qui fournit une implementation
* P.MONTEUR (builder) separation du processus de construction d'un objet du resultat obtenu. 
    très utile quand les objets on beaucoup de parametres plus ou moins optionnels
* P.CHAINE DE RESPONSABILITE (chain of responsability) decoupler l'emmission d'un requete de la reception 
    et le traitement de cette methode en permettant à plusieurs objets de la traiter susccessivement
* P.COMMANDE (command) ce patron emboite une demande dans un objet, permettant de parametrer, mettre en file d'attente
    journlaiser et annuler des demandes. une commande est une operation a effecter, l'interface de cet objet a une 
    une methode execute
* P.COMPOSITE permet de composer une hierachie d'objet et de manipuler de la meme manière une element, ue branche, tout un arbre.
    (ex traitement de texte mot  paragraphe page..)
* P.DECORATEUR (decorator) permet d'attacher dynamiquement des responsabilités à un objet.
    (ex poupées russes un objet est caché dans un autre...) cette techno implique qu'un objet décoré es ses décorateur implement le meme interface (souvent une classe abstraite)
* P.FACADE fournit une interface unifiée sur un exnsemble d'interfaces du systeme (permet de cacher des details techniques)
* P.POIDSMOUCHE (flyweight) un type dobjet pour representer une gamme de petits objets (ex un jeu de caracteres) 
* P.INTERPRETEUR (interpreter) comporte deux composants: contexte et expresssion: transforme une expression
    ecrite dans un language en quelque chose de manipulable par programmation. Lobjet interpreteur est responsable
    de transformer dun texte en objet.
* P.ITERATEUR (iterator) ce patron permeet d'acceder aux elements d'un ensemble sans connaitre les details de fonctionnements
    (next current, hasmoreelement..)
* P.MEDIATEUR(mediator) ici il y a un objet qui defini comment plusieurs objets comuniquenet entre eux.
* P.MEMENTO vise a externaliser l'état interne d'un objet sans perdre l'encapsulation.3 classes : Origine memento et gardien
* P.OBSERVER etablit une relation entre un et plusieurs objets ; quand un change les autres sont avisés. quand un changement a lieu dans l'observateurs 
       sont avertis du changement. methode notify
* P.PROTOTYPE permet de definir un type d'objet  créer en dupliquant une instance qui sert d'exemple methode clone
* P.PROXY nom du patron de conception: c'est un substitut d'un objet, qui permet de le controler
    le proxy est créer pour proteger l'objet
* P.SINGLETON assure qu'il n'y a qu'une seule instance d'une classe en fournissant un interface pour le manipuler
* P.SATE permet a un objet de modifier son comportement lorsque son etat change. souvent utiliser pour implementer des machines à états.
    il existe une classe par etats de la machine.
* P.STRATEGIE dans ce pattern une famille d'algorythme est encapsulee de manière qu'ils soient interchangeables.
    les algos peuvent changer independamment de l'appication.
* P.TEMPLATE il definit la structure generale d'un algo en deleguant certains passages. permet a des sous classes de modifier tout en gardant la meme structure generale
    il est utiliser quand on a par exemple plusieurs implementation d'un calcul
   certaines methodes peuvent etre vide et les classe enfants les remplissants.
* P.VISITOR il represente uen operation a effectuer sur un ensemble d'objets. on modifie l'operation sans modifier l'objet.
    on passe les obets en parametre à un classe tierce qui effectue les actiosn sur celui-ci.


* POSTMAN client pour faire des requetes et aussi des rendu d'API bien belle (script curl pour tester les requetes)
* POSGREL Postgrel base donnée
* PROMISE promesse de retour lors d'une demande

* PROVIDER
* PROPERTY ex String name  proprieté des classe
### Q
* QUERY requete pour acceder a des données
### R:
* REPOSITORY classe avec methodes standards requise CRUD create Read Update Delete
* REACT un autre framework front end 
* REDUX un store permettant de sauvegarder l'ensemble des STATES des objets
* REL DB relation avec une database (keys, tables, relations entre les données)
### S:
* SERVICE rend un service
* SWAGGER UI interaction avec API
* SQL language pour acceder a des tables, dans les bases de données
* SPRING sur couche de java utilisant
### T:
* TOPIC sujet
* TABLE une table correspond a un objet (un ligne coorspodant à une instance)
### U:
* URL:uniform ressource locator, localisateur des données (souvent dit adresse du web) Ou sont les données à acceder
### V:
* VUEjs framework en javascript pour le FRONT END 


##API avec swagger 
*    GET-- Add Climber : ajoute un grimpeur
*    POST-- FindAll Climber : donne la liste des grimpeurs
*    DELETE -- delete Climber : Pour un Admin suprime un grimpeur
### API avec postman
* https://web.postman.co/collections/9338241-d44a4c2b-1a12-4b3c-a967-38ba42cd7817?version=latest&workspace=36a1d81a-7dc9-45d1-819b-d3fb0855969b   
* The documentation is private, so only people you share the collection with can view it.
-----------------
exemple utilisateur avec postman
-----------------
// getAll<t>()
// get<T>ById(Long id)
// update<T>(<t> t)
// delete<T>()

## liste de plugIn installés pour ce projet en Intelij
    lombox

###  @ANNOTATION UTILES 
en faisant juste @Entity et @Id on peut avoir nos objet en base
* @Entity : pour cree une entite en base
* @RestController : pour cree le controlleur avec les acces a l'Api
* @Controller   ne sont pas les meme 
* @CrossOrigin(origins = "http://localhost:4200") 
* @ID : index souvent autogenere pour etre unique
* @Override : pour redefinir une methode d'une classe parente
* @sl4j : une nouvelle version du logger qui du cout est  par exemple log.info("GET on /places"); et plus logger 

* @LOB   pour les champs depassant 255 caractere 

The job of @Controller is to create a Map of model object and find a view but @RestController simply 
return the object and object data is directly written into HTTP response as JSON or XML.

This can also be done with traditional @Controller and use @ResponseBody annotation but since this is 
the default behavior of RESTful Web services, Spring introduced @RestController which combined the behavior 
of @Controller and @ResponseBody together.
---------------------
![realiteDonnees](https://user-images.githubusercontent.com/55358842/68078285-46d80600-fdd3-11e9-886d-483cebd003ee.png)
![download](https://user-images.githubusercontent.com/55358842/68078376-50fb0400-fdd5-11e9-81bc-95ca159e0f8a.png)
![angular](https://user-images.githubusercontent.com/55358842/68078507-2f9b1780-fdd7-11e9-8b0a-341e52c95e64.png)
![react](https://user-images.githubusercontent.com/55358842/68078508-388be900-fdd7-11e9-80f1-ab8880882357.png)
![vue](https://user-images.githubusercontent.com/55358842/68078516-417cba80-fdd7-11e9-95e3-b0fcbf2aeed6.png)



* <span style=“color:green”>example de model de climbingroute</span>
* <span style="color:red">red</span>
* <span style="color:blue">blue</span>

TOUCHE UTILES
maj ctrl s pour voir les erreurs de codes
maj ctrl f pour trouver les occurences d'un mot

<pre><code>
{
  "bonus": "SLOPE",
  "climbingRouteName": "la voie du sud",
  "createdAt": "2019-11-10T18:28:15.334Z",
  "deletedAt": "2019-11-10T18:28:15.334Z",
  "difficulty": "56",
  "id": 0,
  "info": "string",
  "latitude": 2.3654,
  "longitude": 4.326565,
  "mental": 1,
  "modifiedAt": "2019-11-10T18:28:15.334Z",
  "name": "Test",
  "physical": 1,
  "routeType": "BOULDER",
  "star": 1,
  "tactical": 1,
  "technical": 1,
  "zoneType": "INTERIOR"
}
</code></pre>


    // a chaque fois qu'on mettra un persist on va faire un log
    @PrePersist
    public void logDebut() {
        log.info("creation d'une voie en cours " + this.name);
    }

    @PostPersist
    public void logFin() {
        log.info("creation faite de " + this.name);
    }

    //en cas de destruction
    @PreDestroy
    public void destroy() {
        log.info("destruction de " + this.info);
    }
 installation sur le serveur distant auxietre.com
     1  sudo apt-get update
        2  sudo apt-get dist-upgrade -y
        3  hostname -f
        4  vi sudo nano /etc/hosts
        5  cd /etc/hosts
        6  ls /etc
        7  sudo vi /etc/hosts
        8  wget https://software.virtualmin.com/gpl/scripts/install.sh
        9  sudo /bin/sh ./install.sh
       10  sudo apt-get install apt-transport-https ca-certificates curl software-properties-common
       11  sudo systemctl start docker
       12  service start docker
       13  sudo apt-get remove docker docker-engine docker.io
       14  sudo apt install docker.io
       15  sudo systemctl start docker
       16  sudo systemctl enable docker
       17  exit
       18  ls
       19  pwd
       20  cd root/
       21  ls
       22  exit
       23  docker ps
       24  cd francois/climbingzone/
       26  cd zone
       28  ./mvnw package && java -jar target/gs-spring-boot-docker-0.1.0.jar
       29  mvn clean package
       30  sudo apt-get install maven
       50  git clone https://github.com/francoisauxietre/climbingzone.git
       52  cd climbingzone/
       54  cd zone
       56  docker ps   // voir si les docker sont en route
       58  mvn clean package
       59  git pull
       60  mvn clean package
       61  docker buil -t climbingzone
       62  docker build -t climbingzone
       63  docker build -t climbingzone .
       65  docker image ls
       66  history
       
       pour les log docker logs idcontainer 


a jouter et a tester pour mapstruct 
<properties>
    <org.mapstruct.version>1.3.1.Final</org.mapstruct.version>
</properties>
...
<dependencies>
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct</artifactId>
        <version>${org.mapstruct.version}</version>
    </dependency>
</dependencies>
...
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.5.1</version> <!-- or newer version -->
            <configuration>
                <source>1.8</source> <!-- depending on your project -->
                <target>1.8</target> <!-- depending on your project -->
                <annotationProcessorPaths>
                    <path>
                        <groupId>org.mapstruct</groupId>
                        <artifactId>mapstruct-processor</artifactId>
                        <version>${org.mapstruct.version}</version>
                    </path>
                    <!-- other annotation processors -->
                </annotationProcessorPaths>
            </configuration>
        </plugin>
    </plugins>
</build>

***docker file Angular
#base image
FROM node:latest as node
WORKDIR /app
EXPOSE 4200
COPY . .
RUN npm install
RUN npm run build --prod


#stage 2
FROM nginx:alpine
COPY --from=node /app/dist/angular-escalade /usr/share/nginx/html


