FROM openjdk:8
EXPOSE 8080
ADD ./target/employee-service-1.0.jar ./employee-service-1.0.jar
ENTRYPOINT ["java","-jar","-Duser.timezone=GMT+0530","spring-proxy-1.0.jar"]	