FROM java:8
#VOLUME /data/logs
ADD eureka-server-single-0.0.1-SNAPSHOT.jar /data/app.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","/data/app.jar"]
