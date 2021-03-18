FROM openjdk:8
ADD target/serve.war serve.war
EXPOSE 9090
ENTRYPOINT ["java","-jar","serve.war"]

#FROM openjdk:8
#ADD target/serve.jar serve.jar
#EXPOSE 9090
#ENTRYPOINT ["java","-jar","serve.jar"]