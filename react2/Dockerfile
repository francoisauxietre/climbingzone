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

FROM node:7.10 as build-deps
WORKDIR /usr/src/app
COPY package.json yarn.lock ./
RUN npm install
COPY . ./
RUN npm build

# Stage 2 - the production environment
FROM nginx:1.12-alpine
COPY --from=build-deps /usr/src/app/build /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]