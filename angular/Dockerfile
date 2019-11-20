## base image
FROM node:latest as node
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build --prod

# stage 2
FROM nginx:alpine
COPY --from=node /app/dist/angular /usr/share/nginx/html

#
#
#
#FROM node:alpine AS builder
#
#WORKDIR /app
#
#COPY . .
#
#RUN npm install && \
#    npm run build
#
#FROM nginx:alpine
#
#COPY --from=builder /app/dist/* /usr/share/nginx/html/



#
#
#
#
#
#FROM node:12.2.0-alpine
##
### set working directory
#WORKDIR /app
##
### add `/app/node_modules/.bin` to $PATH
#ENV PATH /app/node_modules/.bin:$PATH
##
### install and cache app dependencies
#COPY package.json /app/package.json
#RUN npm update
#RUN npm install
#RUN npm install --save core-js@^3
#RUN ng update @angular/cli
#RUN npm install @vue/cli@3.7.0 -g
##
### start app
#CMD ng serve --port 8081 --host 0.0.0.0 --disableHostCheck true

# exemple de docker file complet pour un jhipster a tester
#
#FROM ubuntu:bionic
#
#RUN \
#  # configure the "jhipster" user
#  groupadd jhipster && \
#  useradd jhipster -s /bin/bash -m -g jhipster -G sudo && \
#  echo 'jhipster:jhipster' |chpasswd && \
#  mkdir /home/jhipster/app && \
#  apt-get update && \
#  # install utilities
#  apt-get install -y \
#    wget \
#    curl \
#    vim \
#    git \
#    zip \
#    bzip2 \
#    fontconfig \
#    python \
#    g++ \
#    libpng-dev \
#    build-essential \
#    software-properties-common \
#    sudo && \
#  # install OpenJDK 11
#  add-apt-repository ppa:openjdk-r/ppa && \
#  apt-get update && \
#  apt-get install -y openjdk-11-jdk && \
#  update-java-alternatives -s java-1.11.0-openjdk-amd64 && \
#  # install node.js
#  wget https://nodejs.org/dist/v10.16.3/node-v10.16.3-linux-x64.tar.gz -O /tmp/node.tar.gz && \
#  tar -C /usr/local --strip-components 1 -xzf /tmp/node.tar.gz && \
#  # upgrade npm
#  npm install -g npm && \
#  # install yarn
#  npm install -g yarn && \
#  su -c "yarn config set prefix /home/jhipster/.yarn-global" jhipster && \
#  # install yeoman
#  npm install -g yo && \
#  # cleanup
#  apt-get clean && \
#  rm -rf \
#    /home/jhipster/.cache/ \
#    /var/lib/apt/lists/* \
#    /tmp/* \
#    /var/tmp/*
#
## copy sources
#COPY . /home/jhipster/generator-jhipster
#
#RUN \
#  # clean jhipster folder
#  rm -Rf /home/jhipster/generator-jhipster/node_modules \
#    /home/jhipster/generator-jhipster/yarn.lock \
#    /home/jhipster/generator-jhipster/yarn-error.log && \
#  # install jhipster
#  npm install -g /home/jhipster/generator-jhipster && \
#  # fix jhipster user permissions
#  chown -R jhipster:jhipster \
#    /home/jhipster \
#    /usr/local/lib/node_modules && \
#  # cleanup
#  rm -rf \
#    /home/jhipster/.cache/ \
#    /var/lib/apt/lists/* \
#    /tmp/* \
#    /var/tmp/*
#
## expose the working directory, the Tomcat port, the BrowserSync ports
#USER jhipster
#ENV PATH $PATH:/usr/bin:/home/jhipster/.yarn-global/bin:/home/jhipster/.yarn/bin:/home/jhipster/.config/yarn/global/node_modules/.bin
#WORKDIR "/home/jhipster/app"
#VOLUME ["/home/jhipster/app"]
#EXPOSE 8080 9000 3001
#CMD ["tail", "-f", "/home/jhipster/generator-jhipster/generators/server/templates/src/main/resources/banner-no-color.txt"]
