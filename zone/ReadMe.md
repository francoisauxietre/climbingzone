##Base de donnée 
lancée en independant en port 3009 grace au docker compose
lancement: dans le repertoire zone
docker-compose up (le docker-compose gere la base de donnee en msql)

### MOTS CLES
A:
ANGULAR 2 framework basé sur de Javascript
ANGULAR JS autre 
B:
BACK-END programme traitant les données (ex avec spring boot java)
C:
CLASS comment seront fait les objets que l'on créera (MOULE)
D:
DOM Document Object Model interface normalise qui permet de modifier le navigateur web avec des script
DOM virtuel dans vuejs et react on a un dom virtuel qui est une copie virtuel du dom actuel
DAO Data Acces Object  object qui peuvent dialoguer en java avec une base de donnée directement
DTO Data Transfer acces  pour les transfer des données par exemple entre angular et react 
F:
FRAMEWORK infrastructure logicielle, socle d'applications, infrastructure de développement
FRONT-END la partie qu code qui sera generé dans le Browser pour les vues..
G:
H:
Http HyperText Transfer Protocol  protocol de transfert de données en texte
I:
INSTANCE une representation d'un object un instance
J:
JAVA  language de prog (Objet)
JPA java persistance Acces  (couche relation mapping entre un objet java et une base de donnee)
JDBC
M:
MYSQL Style de base de donnee comme mongoDB, PostGrel
O:
OBJECT objet cree grace à une classe 
ORM object relation mapping object pour lier 
OBSERVABLE un objet que l'on peut ecouter  PATTERN OBSERVER
OBSERVER celui qui suit l'état d'un objet
P:
POSTMAN client pour faire des requetes et aussi des rendu d'API bien belle (script curl pour tester les requetes)
POSGREL Postgrel base donnée
PROMISE promesse de retour lors d'une demande
PROVIDER
Q
QUERY requete pour acceder a des données
R:
REACT un autre framework front end
REDUX un store permettant de sauvegarder l'ensemble des STATES des objets
REL DB relation avec une database (keys, tables, relations entre les données)
S:
SWAGGER UI interaction avec API
SQL language pour acceder a des tables, dans les bases de données
SPRING sur couche de java utilisant
T:
TABLE une table correspond a un objet (un ligne coorspodant à une instance)
U:
URL:uniform ressource locator, localisateur des données (souvent dit adresse du web) Ou sont les données à acceder
V:
VUEjs framework en javascript pour le FRONT END



 


##API avec swagger 
   GET-- Add Climber : ajoute un grimpeur
   POST-- FindAll Climber : donne la liste des grimpeurs
   DELETE -- delete Climber : Pour un Admin suprime un grimpeur
###API avec postman
https://web.postman.co/collections/9338241-d44a4c2b-1a12-4b3c-a967-38ba42cd7817?version=latest&workspace=36a1d81a-7dc9-45d1-819b-d3fb0855969b   
The documentation is private, so only people you share the collection with can view it.

exemple utilisateur
{"firstName": "toto","lastName": "toto","day": 1,"month": 1,"year": 1,"info": "test"}

1	Vitesse	Auxietre	Francois	0	0	trop belle	2019-11-01		voie magnifique dans le cadre de buis les barronies France	8	2		photo1.png	3	buis	qr1	4	1	3
2	Resistance	Auxietre	Francois	0	0	voie du sud	2019-11-01		voie magnifique dans le cadre de buis les barronies France	7	1		photo2.png	2	buis	qr2	2	0	2
