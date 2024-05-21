FROM openjdk:17
LABEL author = "manh19924"
WORKDIR /opt
ENV PORT/ 9192
EXPOSE 9192
COPY target/*.jar /opt/app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar
