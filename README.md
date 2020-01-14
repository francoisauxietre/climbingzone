# climbingzone
Le jeu de cartes pour les grimpeurs:
But donner la possibilité aux grimpeurs d'enregistrer leurs performances
pour gagner des cartes d'un jeu.
But GLI TAA (Olivier Barais)Apprendre les technos du web, springboot, jhipster, angular et tout ce qui va avec css, docker(file et compose), mise en production
react vuejs  dockeriser le tout, tout mettre en production pour tester
car souvent en localhost c'est facile et apres...

# projet pour lancer mon projet il suffit de lancer docker-compose up
chaque Dockerfile est dans chaque répertoire
Un proxy est installé sur le Nginx du serveur sur auxietre.com 
et fait les différentes redirections.
Pour l'application android (apk) elle est disponible sous android
l'application android est developpé en partenariat avec la matière MMM de Marc christie (Technos utilisées Room Firebase Google et OpenstreetMap)

J'ai commencé des Readme dans chaque projets

react et react2 sont deux projets react 
angular est l'ancien angular7 est le nouveau avec css google maps 

Integration continue avec Travis
build tester sur Travis
![alt text](https://travis-ci.org/francoisauxietre/climbingzone.svg?branch=master)

coveralls
[![Coverage Status](https://coveralls.io/repos/github/francoisauxietre/climbingzone/badge.svg?branch=master)](https://coveralls.io/github/francoisauxietre/climbingzone?branch=master)

Ce qui n'est pas encore fait, les tests, la documentation des methodes, le css...


# Site en ligne 
http://angular.auxietre.com/
http://angular7.auxietre.com/
http://vue.auxietre.com/#/
http://react.auxietre.com/
http://spring.auxietre.com/

# site Admin en spring
http://vps541599.ovh.net:8080/
nouvelle adresse avec les redirectiosn
*site Angular
http://vps541599.ovh.net:4200/
*site Angular7
http://vps541599.ovh.net:4201/
*site react
http://vps541599.ovh.net:3000/
site vuejs
http://vps541599.ovh.net:8081/


build tester sur Travis
![alt text](https://travis-ci.org/francoisauxietre/climbingzone.svg?branch=master)

coveralls
[![Coverage Status](https://coveralls.io/repos/github/francoisauxietre/climbingzone/badge.svg?branch=master)](https://coveralls.io/github/francoisauxietre/climbingzone?branch=master)

pour entrer dans le mysql
docker exec -it bc741579c535 bash
acces dans mysql 
mysql -u root -p (mot de passe du docker-compose)
mysql> show databases;
mysql> use climbing;
mysql> select * from climber;
verfification 






installé dans des docker sur la machine 
chez ovh : 

intsallation de différents docker
le docker de mysql du fichier docker-compose ou la commande 
* docker pull mysql
le docker node : 
* docker pull node
Angular:
vue:
react:

security 
![securityJwt](https://user-images.githubusercontent.com/55358842/69007617-67aa6a80-0940-11ea-8785-6b14bf8cc13e.png)



installation de npm
* npm install -g @angular/cli@7.3.9
integration continue avec travis 
https://travis-ci.org/francoisauxietre/climbingzone/builds/610432482

installation d'un nginx a la racine du principal
/etc/nginx/sites-enabled
  //commande pour voir les ports utilisés
nslookup http://spring.auxietre.com/
systemctl status apache2
systemctl list-unit
systemctl list-units 
systemctl status
ll
grep -Ri auxietre.com *
iptables
iptables -v -L
iptables -v -L -t nat

ss -l4pn
systemctl status
cd sites-enabled/
//edition de react angular angular7 vue
systemctl status
systemctl restart nginx.service 
docker exec -it climbingzone_react2  /bin/bash
