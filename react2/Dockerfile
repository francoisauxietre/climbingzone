FROM alpine
EXPOSE 3000

COPY . /usr/share/nginx/html
# copy le fichier et ecrase le default de nginx
COPY nginx.conf /etc/nginx/conf.d/default.conf
RUN apk add nginx
RUN mkdir /run/nginx
RUN apk add nodejs
RUN apk add npm
RUN ls -a
RUN cd /usr/share/nginx/html
RUN ls -a
RUN npm install
RUN npm run build
RUN apk del nodejs
RUN apk del npm

CMD ["/bin/sh", "-c", "exec nginx -g 'daemon off;';"]
WORKDIR /usr/share/nginx/html

#FROM node:latest
#WORKDIR /usr/src/app
#COPY package.json ./
#RUN npm install
#ADD src /usr/app/src
#ADD public /usr/src/app/public
#RUN npm build
#
#CMD ["npm", "start"]

#FROM alpine
#EXPOSE 3000
#COPY . /var/www/localhost/htdocs
## copy le fichier et ecrase le default de nginx
#COPY nginx.conf /etc/nginx/conf.d/default.conf
#RUN apk add nginx && \
#    mkdir /run/nginx && \
#    apk add nodejs && \
#    apk add npm && \
#    cd /var/www/localhost/htdocs && \
#    npm install && \
#    npm run build && \
#    apk del nodejs && \
#
#    apk del npm && \
#    mv /var/www/localhost/htdocs/build /var/www/localhost && \
#    cd /var/www/localhost/htdocs && \
#    rm -rf * && \
#    mv /var/www/localhost/build /var/www/localhost/htdocs;
#
#CMD ["/bin/sh", "-c", "exec nginx -g 'daemon off;';"]
#WORKDIR /var/www/localhost/htdocs