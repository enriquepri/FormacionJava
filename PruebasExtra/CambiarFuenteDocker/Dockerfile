FROM openjdk:17
EXPOSE 8080
ENV CONEXION "H2"
ENV USER "sa"
ENV CONTRA ""
ENV URL "jdbc:h2:file:./springdatademo"
COPY /target/*.jar /usr/local/lib/spring.jar
ENTRYPOINT ["java", "-jar", "/usr/local/lib/spring.jar"]