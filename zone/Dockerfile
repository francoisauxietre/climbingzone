# on prend le ervnier jdk (voir pour prendre une version precise
#creation du docker file
#docker image build -t climbingzone:latest .

#FROM openjdk:8-jdk-alpine
## copy jar file into container image under app directory
##COPY target/climbingzone.jar app/climbing.jar
#COPY target/climbingzone.jar app/climbingzone.jar
#
## port de connection pour le serveur
#EXPOSE 8080
#ARG jar  # arg qui prend par default cette valeur ou une nouvelle
#ADD # permet de rajouter un autre jar
## demarrage de l application
#CMD ["java", "-jar", "app/ZoneApplication.jar"]
## entry point c'est au demarrage
## mvn spring-boot:

# version gratuite et legere du jdk
FROM openjdk:8-jdk-alpine

RUN apk add maven

# creation d'un volume temporaire
VOLUME /tmp

# port de connection au serveur (le conteneur ouvre ce port chez lui)
EXPOSE 8080
ADD src src
ADD pom.xml pom.xml

# c'est au demarrage du conteneur
ENTRYPOINT ["mvn", "spring-boot:run"]
# ENTRYPOINT ["mvn", "-Drun.arguments=--spring.main.banner-mode=off,--customArgument=custom:run"]
# si on veut changer ou passer un autre jar qui sera renomer en climbingzone.jar
#ARG JAR_FILE=target/climbingzone.jar
#ADD ${JAR_FILE} climbingzone.jar
# ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/climbingzone.jar"]

# lancement de l'appli depuis une commande mvn
# docker run -p 3306:3306 --name fafa1DB -e MYSQL_ROOT_PASSWORD=fafa1 -e MYSQL_DATABASE=climbing -d mysql:5.7 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci

