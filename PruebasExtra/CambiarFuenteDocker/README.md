# CAMBIAR FUENTE BASE DE DATOS EN TIEMPO DE EJECUCION

Prueba para comprobar como cambiar la fuente de la base de datos en tiempo de ejecucion con la ayuda de docker 
En este caso voy a utilizar H2 y POSTGRESQL como distintas fuentes.

## COMANDOS DOCKER

Para iniciar la network: docker network create mynetwork  
Para crear el contenedor de postgre: docker run --network mynetwork --name postgres_test -ePOSTGRES_USER=postgres -e POSTGRES_PASSWORD=contrasena -e POSTGRES_DB=test postgres  
Para crear la imagen de nuestra app: docker build -t pruebapp:latest .  
Para inicializar el contenedor de la app:
- Si queremos usar H2: docker run -e CONEXION=H2 [-e USER=UsuarioDB] [-e CONTRA=PasswordDB] [-e URL=UrlDB] --network mynetwork --name prueba -p 8080:8080 pruebapp
- Si queremos usar POSTGRE (conectándonos a nuestro contenedor): docker run -e CONEXION=POSTGRE -e CONTRA=contrasena -e USER=postgres -e URL=jdbc:postgresql://postgres_test:5432/test --network mynetwork --name prueba -p 8080:8080 pruebapp

Si no especificamos ningún perfil utilizará H2, pues es el valor predeterminado establecido en el dockerfile  
En los comandos especificados anteriormente se ha dejado la configuración usada en las pruebas, pero por supuesto puede adaptarse para utilizar nombres/url/contraseñas etc de cada usuario