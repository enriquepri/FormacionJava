# Subir y bajar ficheros
Nombre proyecto Maven: block11-upload-download-files
1. Permitir subir un fichero incluyendo como metadato la categoría. Guardar el fichero y en una tabla el metadato, nombre de fichero, fecha de subida, etc. Devolver Entidad ‘Fichero’ con los datos, incluyendo un ID único.  

   Descargar fichero, buscándolo por diferentes métodos (id y nombre de fichero).  

2. Crear programa con estos endpoints.  
   Petición POST. /upload/{tipo} (@RequestParam("file") MultipartFile file,
   RedirectAttributes redirectAttributes).  

   Solo aceptara ficheros con la extensión indicada en la URL  
   Petición GET /setpath?path={directorio_a_guardar}    

   El programa al arrancar permite mandar un parámetro que es el directorio donde debe guardar los ficheros. Ejemplo: java –jar MIPROGRAMA.jar “/DIRECTORIO_A_GUARDAR”. Si no se especifica esta variable ponerlo en el directorio donde se lanza java.  


### Aclaraciones
El archivo de prueba.txt es el archivo que he probado a bajar y subir
Al final no añadi la parte de poder pasar la ruta donde guardar/leer por argumentos por brevedad, siempre se usa en la carpeta ficheros

(Para ver una forma de como podríamos usar los argumentos de la línea de comandos ver carpeta [block5-command-line-runner](../block5-command-line-runner/))

### Algunos enlaces útiles
https://spring.io/guides/gs/uploading-files/  
https://www.baeldung.com/sprint-boot-multipart-requests