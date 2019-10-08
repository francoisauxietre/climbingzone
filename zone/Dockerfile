# on prend le ervnier jdk (voir pour prendre une version precise
#creation du docker file
#docker image build -t climbingzone:latest .

FROM openjdk:oracle
# copy jar file into container image under app directory
#COPY target/climbingzone.jar app/climbing.jar
COPY target/climbingzone.jar app/climbingzone.jar

# port de connection pour le serveur
EXPOSE 8080

# demarrage de l application
CMD ["java", "-jar", "app/ZoneApplication.jar"]

