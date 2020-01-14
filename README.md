# climbingzone
card games for climbers
*site Admin en spring
http://vps541599.ovh.net:8080/
nouvelle adresse avec les redirectiosn
*site Angular
http://vps541599.ovh.net:4200/
*site react
http://vps541599.ovh.net:3000/
site vuejs
http://vps541599.ovh.net:8081/

*site Angular7
http://vps541599.ovh.net:4201/


installation d'un nginx a la racine du principal
/etc/nginx/sites-enabled

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



* some readme one in each project


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
