FROM openjdk:8
EXPOSE 8080
ADD ./target/spring-config-1.0.jar ./spring-config-1.0.jar
ENTRYPOINT ["java","-jar","-Duser.timezone=GMT+0530","spring-config-1.0.jar"]	