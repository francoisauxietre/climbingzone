##Base de donnée 
lancée en independant en port 3009 grace au docker compose
lancement: dans le repertoire zone
docker-compose up (le docker-compose gere la base de donnee en msql)


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
