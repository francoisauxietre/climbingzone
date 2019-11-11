![hello_Min](https://user-images.githubusercontent.com/55358842/68070716-06946b80-fd72-11e9-94bb-4e06b9f30141.jpg)

## Base de donnée 

lancement: dans le repertoire zone (le docker-compose gere la base de donnee en msql sur le  port 3009 grace au docker compose 
<pre><code>docker-compose up</code></pre>
**Lombok** 
tres utile pour alléger les classes sans devoir réecrire sans cesse tous les getters and setters.

Différents ReadMe: https://github.com/francoisauxietre/climbingzone/tree/master/zone


-----------------
###  MOTS CLES
###  A:
* ANGULAR 2 framework basé sur de Javascript 
* ANGULAR JS autre 
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
* @CrossOrigin(origins = "http://localhost:4200") 
* @ID : index souvent autogenere pour etre unique
* @Override : pour redefinir une methode d'une classe parente 

* @LOB   pour les champs depassant 255 caractere 
---------------------
![realiteDonnees](https://user-images.githubusercontent.com/55358842/68078285-46d80600-fdd3-11e9-886d-483cebd003ee.png)
![download](https://user-images.githubusercontent.com/55358842/68078376-50fb0400-fdd5-11e9-81bc-95ca159e0f8a.png)
![angular](https://user-images.githubusercontent.com/55358842/68078507-2f9b1780-fdd7-11e9-8b0a-341e52c95e64.png)
![react](https://user-images.githubusercontent.com/55358842/68078508-388be900-fdd7-11e9-80f1-ab8880882357.png)
![vue](https://user-images.githubusercontent.com/55358842/68078516-417cba80-fdd7-11e9-95e3-b0fcbf2aeed6.png)



* <span style=“color:green”>example de model de climbingroute</span>
* <span style="color:red">red</span>
* <span style="color:blue">blue</span>

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
        logger.info("creation d'une voie en cours " + this.name);
    }

    @PostPersist
    public void logFin() {
        logger.info("creation faite de " + this.name);
    }

    //en cas de destruction
    @PreDestroy
    public void destroy() {
        logger.info("destruction de " + this.info);
    }
