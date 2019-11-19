Qaund on se fait jete par un CORS sa peut juste etre aussi l url demande qui n'ets pas la bonne$

pour cree un nouveau composant 
ng g c nomDuComposant
 ng g c pageError -it -is // pas de creation de css ni de html

(angular generate component)

exemple de methode sur les string   {{"toto".length}}  {{"toto".toUppercase}}   etc
appel de methode {{coucou()}}
binding [nom] ou bind-nom
lancer sudo npm start pour que le refresh se fasse tout le temps dans le browser
BIEN METTRE LE PORT DANS PROXY.CONF.JSON EN FONCTION DU SITE QUE LON VEUT ACCEDER

pour passer des elements de parent a  enfant 
parent vers enfants @input
enfant vers parents @output

{{message | lowercase}}  differentes options 
uppercase titlecase slice: 3 json

permier chiffre min digit, min decimal digit, et max decimal
  <h2>{{16.356 | number:"1.2-3"}}</h2>
  
pour les dates {{date | date:'short'}} shortDate shortTime...

un injecteur est en gros un container contenant toutes nos dependences que 
l'on voudrait envoyer comme parametres à une methode

un observable = une response de hhtp
suite a un get sur une http on ecoit un objet response mais non exploitable 
RxjS pour utiliser les observables

acces a la base de donnee climbing par mysql dans le docker
docker exec -it 628c0dae82d2 bash
 mysql -u root -p    (avec root comme mot de passe)
 show databases; (pour afficher les bases en cours)
 use climbing; pour se mettre dedans
 show tables;
 ex de requette  SELECT t.* FROM climbing.climber t where first_name like '%aux%';

![1](https://user-images.githubusercontent.com/55358842/67728832-018c9080-f9ef-11e9-9283-9760f317c58b.png)

# AngularEscalade

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 8.3.4.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).

docker compose sur le server 
version: '3.3'

services:
   db:
     image: mysql:5.7
     restart: always
     networks:
      - api
     environment:
       MYSQL_ROOT_PASSWORD: "fafa1"
       MYSQL_DATABASE: "climbing"

   spring:
     depends_on:
       - db
     build: zone/
     networks:
      - api
     ports:
      - "8080:8080"
      - "8081:8081"
     expose:
      - "8080"
      - "8081"
     restart: always
     environment:
      DB_NAME: "climbing"
      DB_USER: "root"
      DB_PASSWORD: "fafa1"
      DB_URL: db
networks:
    api:
      
      

