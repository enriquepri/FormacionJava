# Ejercicio sobre JPA.

## Requisitos
Usar buenas prácticas. Recordar que los controladores (controllers) NO deben tener ninguna referencia a la base de datos.

Tiempo máximo para hacerlo: El doble del que le haya llevado al primer estudiante (aprox: 6-8 horas)

## Descripción del ejercicio

1. Crear estas tablas en JPA con una base de datos h2, dejando el fichero en disco duro.

- CabeceraFra // Guardara las cabeceras de las facturas.
  - Id int autoincremental, -- ID
  - cli_codi int - Codigo de cliente. - ManyToOne. Un cliente puede tener muchas facturas.
  - ImporteFra Double – Importe total de la fra.
- LineasFra // Las líneas de la fra. -- ONETOMANY – una cabecera de fra. puede tener n lineas
  - Id int autoincremental, -- ID
  - IdFra int -- // Id de la fra.
  - ProNomb String not null , -- Nombre de producto.
  - Cantidad double,
  - precio double,

- Cliente

  - Id int autoincremental, -- ID

  - nombre varchar(100) not null -- // Nombre de cliente

2. En cada ejecución:

- Regenerar la base de datos (drop tables y create tables)

- Insertar un nuevo cliente.

- Insertar una factura de prueba asignada al cliente anteriormente creado con dos líneas. IMPORTANTE: Solo se debe realizar un save para insertar las 2 líneas y la cabecera de fra. Es decir, tiene que haber solo 2 sentencias save.

### Endpoints

3. GET /factura. Buscar todas las facturas. Devolverá una List de FacturaOutputDto que debe contener estos campos. Siempre devolverá un 200.
![](/.images/imagen1.png)
![](/.images/imagen2.png)
![](/.images/imagen3.png)

4. DELETE factura /{idFra}. Borrar toda la fra. Deberá borrar con una sola instrucción tanto la cabecera como las lineas. Devolverá un 404 si no encuentra la fra. Un 200 en caso contrario.


5. POST factura/linea/{idFra}. Añadir una línea a una fra. ya existente. En el body recibirá un objeto LineaInputDto   
![](/.images/imagen4.png)
Devolverá el objeto FacturaOutputDto con la nueva línea añadida.  
Si no existe la fra (id no existente) devolver un 404.

## Enlaces Útiles
[Baeldung - Cascade Types](https://www.baeldung.com/jpa-cascade-types)