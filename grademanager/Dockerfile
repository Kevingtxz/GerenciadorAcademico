FROM openjdk

WORKDIR /app

COPY target/grademanager.jar /app/grademanager.jar

ENTRYPOINT [“java”,”-Dspring.data.mongodb.uri=mongodb://mongo:27017/db”, “-Djava.security.egd=file:/dev/./urandom”,”-jar”,”/<grademanager>.jar”]
