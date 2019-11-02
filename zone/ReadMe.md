![hello_Min](https://user-images.githubusercontent.com/55358842/68070716-06946b80-fd72-11e9-94bb-4e06b9f30141.jpg)

##Base de donnée 

lancement: dans le repertoire zone (le docker-compose gere la base de donnee en msql sur le  port 3009 grace au docker compose 
<pre><code>docker-compose up</code></pre>
**Lombok** 
*pourrais simplifier beaucoup de code sur getter et setters pour voir les classes generee des intelij onglet structure a gauche et sinon quand on build javap nomdufichierclass pour voir ce qui est reelment generer.*

-----------------
### MOTS CLES
####A:
* ANGULAR 2 framework basé sur de Javascript
* ANGULAR JS autre 
####B:
* BACK-END programme traitant les données (ex avec spring boot java)
####C:
* CLASS comment seront fait les objets que l'on créera (MOULE) un cllass est une table en database
* CRUD create Read Update Delete
####D:
* DOM Document Object Model interface normalise qui permet de modifier le navigateur web avec des script
* DOM virtuel dans vuejs et react on a un dom virtuel qui est une copie virtuel du dom actuel
* DAO Data Acces Object  object qui peuvent dialoguer en java avec une base de donnée directement
* DTO Data Transfer acces  pour les transfer des données par exemple entre angular et react
####E:
* ENTITY en jpa @ENTITY permet a jpa de creer nos tables et colonnes (une colonne par propertie)
####F:
* FRAMEWORK infrastructure logicielle, socle d'applications, infrastructure de développement
* FRONT-END la partie qu code qui sera generé dans le Browser pour les vues..
####G:
####H:
* Http HyperText Transfer Protocol  protocol de transfert de données en texte
####I:
* ID index pour etre une clé primaire dans la table poue savoir comment indexer et trouver les donnes (rangements)
* ID @id clé primaire
* INSTANCE une representation d'un object un instance
####J:
* JAVA  language de prog (Objet)
* JPA java persistance Acces  (couche relation mapping entre un objet java et une base de donnee)
* JDBC

####L:
LOMBOX surcouhe avec annotation wui permet de reduire énormement les getters et setters et Hashcode et toString
####M:
* MAP mapper les donner les mettre en relation
* mapping entre les objets Dto et les Dao avec MAPSTRUCT https://mapstruct.org/
* MYSQL Style de base de donnee comme mongoDB, PostGrel
####O:
* OBJECT objet cree grace à une classe 
* ORM object relation mapping object pour lier 
* OBSERVABLE un objet que l'on peut ecouter  PATTERN OBSERVER
* OBSERVER celui qui suit l'état d'un objet
####P:
* POSTMAN client pour faire des requetes et aussi des rendu d'API bien belle (script curl pour tester les requetes)
* POSGREL Postgrel base donnée
* PROMISE promesse de retour lors d'une demande
* PROVIDER
* PROPERTY ex String name  proprieté des classe
####Q
* QUERY requete pour acceder a des données
####R:
* REPOSITORY classe avec methodes standards requise CRUD create Read Update Delete
* REACT un autre framework front end
* REDUX un store permettant de sauvegarder l'ensemble des STATES des objets
* REL DB relation avec une database (keys, tables, relations entre les données)
####S:
* SERVICE rend un service
* SWAGGER UI interaction avec API
* SQL language pour acceder a des tables, dans les bases de données
* SPRING sur couche de java utilisant
####T:
* TOPIC sujet
* TABLE une table correspond a un objet (un ligne coorspodant à une instance)
####U:
* URL:uniform ressource locator, localisateur des données (souvent dit adresse du web) Ou sont les données à acceder
####V:
* VUEjs framework en javascript pour le FRONT END

##API avec swagger 
*    GET-- Add Climber : ajoute un grimpeur
*    POST-- FindAll Climber : donne la liste des grimpeurs
*    DELETE -- delete Climber : Pour un Admin suprime un grimpeur
###API avec postman
* https://web.postman.co/collections/9338241-d44a4c2b-1a12-4b3c-a967-38ba42cd7817?version=latest&workspace=36a1d81a-7dc9-45d1-819b-d3fb0855969b   
* The documentation is private, so only people you share the collection with can view it.
-----------------
exemple utilisateur avec postman
{"firstName": "toto","lastName": "toto","day": 1,"month": 1,"year": 1,"info": "test"}
-----------------
// getAll<t>()
// get<T>ById(Long id)
// update<T>(<t> t)
// delete<T>()

## liste de plugIn installés pour ce projet en Intelij
    lombox

###@ANNOTATION UTILES 
en faisant juste @Entity et @Id on peut avoir nos objet en base

* @RestController
* @CrossOrigin(origins = "http://localhost:4200")
* @ID
* @ENTITY
* @LOB   pour els champs depassant 255 caractere 
---------------------
![realiteDonnees](https://user-images.githubusercontent.com/55358842/68078285-46d80600-fdd3-11e9-886d-483cebd003ee.png)

![hello](https://user-images.githubusercontent.com/55358842/68070665-66d6dd80-fd71-11e9-92b9-22d91cd29f4b.jpg)


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
