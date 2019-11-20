#FROM alpine
#EXPOSE 3000
#COPY . /var/www/localhost/htdocs
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

FROM node:latest
WORKDIR /usr/src/app
COPY package.json ./
RUN npm install
ADD src /usr/app/src
ADD public /usr/src/app/public
RUN npm build

CMD ["npm", "start"]