# 12. Mensajería
## Kafka

Nombre proyecto Maven: block12-kafka  
Usando Kafka, montar dos aplicaciones: una que envíe mensajes y la segunda le responda con otros mensajes.  

#### Personal

Voy a tener 2 aplicaciones.  
La aplicación 1 tiene las dependencias tanto spring Web como de Kafka, puesto que voy a utilizar un controlador para iniciar las llamas.  
La aplicación 2 solo contiene la dependencia a kafka puesto que no vamos a acceder directamente a ella, solo va a responder a los mensajes de la primera.

Para esto voy a crear dos topicos, 1 y 2, la aplicacion 1 escribe en el 1 y lee en el 2 y viceversa.

### Comandos Kafka
Los comandos utilizados para lanzar el servidor de kafka y crear los tópicos:
- bin\windows\zookeeper-server-start.bat config\zookeeper.properties
- bin\windows\kafka-server-start.bat config\server.properties
- bin\windows\kafka-topics.bat --create --topic uno --bootstrap-server localhost:9092
- bin\windows\kafka-topics.bat --create --topic dos --bootstrap-server localhost:9092

### Enlaces útiles
[Página profesor-p](http://www.profesor-p.com/2019/01/24/mensajeria-con-kafka-y-spring-boot/)  
[Página baeldung](https://www.baeldung.com/spring-kafka)