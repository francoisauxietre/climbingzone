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