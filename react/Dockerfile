FROM node:9-slim
WORKDIR /usr/
COPY package.json /app
RUN npm install
COPY . ./
CMD ["npm", "start"]

# docker build -t react-docker-escalade .
# attention au espace point
#pour acceder a cette image docker faire
# accede par:
#docker run -it -p 9001:3000 react-docker-escalade
# en mode detache en arrière plan
#docker run -d -p 9001:3000 react-docker-escalade

# port deja utiliser netstat -ntlp
