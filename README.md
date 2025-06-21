![Programação-Java_ Persistencia de datos y consultas con Spring Data JPA](https://github.com/genesysR-dev/2066-java-persitencia-de-datos-y-consultas-con-Spring-JPA/assets/91544872/e0e3a9f8-afc7-4e7b-be83-469351ef2d70)

# Challenge LiterAlura by Rene Avila Alonso

Proyecto desarrollado durante el curso de la formación Avanzando con Java de Alura
para BackEnd

<h2>**22-java-literalura-g8-challenge**</h2>
<h3>Inicio</h3>
<em> MENU DE OPCIONES </em> <br/>
- - - - - - - - - - - - - - - - - - - - - - <br/>
1. Buscar libro por título y grabar en BD. </br>
2. Listar libros registrados BD. </br>
3. Listar autores registrados BD. </br>
4. Listar autores vivos en un determinado año BD. </br>
5. Listar autores fallecidos BD. </br>
6. Listar libros por idioma BD. </br>
7. Libros mas populares en la API GUTENDEX. </br>
8. Buscar autor por nombre BD. </br>
0. Salir.</br> 

NOTAS ANTES DE UTILIZAR EL PROYECTO </br>
* Utilizar una variable de entorno DB_NAME_4, con db_libros </br>
* o Colocar DB_NAME = db_libros, y en properties dejar DB_NAME </br>
* Se esta utilizando JDK 17, e Intellij IDEA </br>
* Las opciones 1) esta capturando los libros y se sale del programa </br>
* y la opcion 6) busqueda x idioma, no me ha funcionado, en desarrollo. </br>
* Las demas opciones estan FUNCIONANDO. </br>

<h2>Descripción proyecto</h2>
Construir tu propio de consulta de libros a la API GUTENDEX <br/>
Aprenderás a realizar solicitudes a una API, manipular datos JSON y,
finalmente, grabar informacion en la base de datos y hacer las consultas
respectivas a estas tablas de la base de datos con Postgresql, 
con sentencias en el repositorio con JPA, JPQL y sql nativo<br/>

Los pasos para completar este desafío se detallo: <br/>
A) Configuración del Ambiente Java; <br/>
B) Creación del Proyecto; <br/>
C) Consumo de la API; <br/>
D) Análisis de la Respuesta JSON; <br/>
E) Filtros o busquedas de libros o autores; <br/>
F) y exibición de resultados a los usuarios <br/>
Por medio del siguiente MENU DE OPCIONES: <br/>

1. [Buscar libro por titulo](#buscar-libro-por-titulo)
2. [Listar libros registrados BD](#Listar-libros-registrados-bd)
3. [Listar autores registrados BD](#Listar-autores-registrados-bd)
4. [Listar autores vivos en un determinado año BD](#listar-autores-vivos-en-un-determinado-año-bd)
5. [Listar autores fallecidos BD](#listar-autores-fallecidos-bd)
6. [Listar libros por idioma BD](#listar-libros-por-idioma-bd)
7. [Libros mas populares en la API GUTENDEX](#Libros-mas-populares-en-la-api-gutendex)
8. [Buscar autor por nombre BD](#buscar-autor-por-nombre-db)
0. [Salir](#salir)

[Descripción proyecto](#descripción-proyecto) <br/>
[Como usar el programa](#como-usar-el-programa) <br/> 
[Tecnologías utilizadas](#Tecnologías-utilizadas) <br/>
[Personas o entidades contribuyentes en el Proyecto](#Personas-o-entidades-contribuyentes-en-el-Proyecto) <br/> 
[Desarrolladores del Proyecto](#Desarrolladores-del-Proyecto) <br/>

<h2>Como usar el programa</h2> <br/> 
**Literalura**   <br/>
1. Buscar libro por título y grabar en BD. <br/>
2. Listar libros registrados BD. <br/>
3. Listar autores registrados BD. <br/>
4. Listar autores vivos en un determinado año BD. <br/>
5. Listar autores fallecidos BD. <br/>
6. Listar libros por idioma BD. <br/>
7. Libros mas populares en la API gutendex. <br/>
8. Buscar autor por nombre BD. <br/>
0. Salir. <br/>

Digite opción [1..8] o [0.Salir] 1 <br/>
<h4>Explicación.</h4> <br/>
Aqui puede digitar la opcion, dentro del rango permitido, si hay error </br>
de digitación se devuelve a leer opción. </br>

<h2>Buscar libro por titulo</h2>
Digite opcion [1..8] 0=Salir--->1 </br>
Ingresar titulo del libro a buscar: 
Little Women </br>
Hibernate: select l1_0.id,l1_0.autor_id,l1_0.idioma,l1_0.titulo from libros l1_0 where upper(l1_0.titulo) like upper(?) escape '\' </br>
Hibernate: select a1_0.id,a1_0.nombre,a1_0.year_born,a1_0.year_dead from autores a1_0 where upper(a1_0.nombre) like upper(?) escape '\' </br>
Hibernate: insert into autores (nombre,year_born,year_dead) values (?,?,?) </br>
Hibernate: insert into libros (autor_id,idioma,titulo) values (?,?,?) </br>
2025-06-20T17:24:20.170-05:00  INFO 13816 --- [           main] .s.b.a.l.ConditionEvaluationReportLogger : </br>
</br>

[Inicio](#Inicio)

<h2>Listar libros registrados BD</h2> 
Digite opcion [1..8] 0=Salir--->2 </br>
```
Hibernate: SELECT l.titulo AS titulo, a.nombre AS nombreAutor </br>
FROM libros l </br>
INNER JOIN autores a ON l.autor_id = a.id </br>
```
LibroAutor{Titulo='Cervantes Saavedra, Miguel de'Autor='Don Quijote'} </br> 
LibroAutor{Titulo='Melville, Herman'Autor='Moby Dick; Or, The Whale'} </br> 
LibroAutor{Titulo='Hugo, Victor'Autor='Los miserables - Tomo 1 (de 2)'}   </br>
LibroAutor{Titulo='Shelley, Mary Wollstonecraft'Autor='Frankenstein; Or, The Modern Prometheus'} </br>
LibroAutor{Titulo='Austen, Jane'Autor='Pride and Prejudice'} </br>
LibroAutor{Titulo='Shakespeare, William'Autor='The Complete Works of William Shakespeare'} </br>
LibroAutor{Titulo='Eliot, George'Autor='Middlemarch'} </br>
LibroAutor{Titulo='Alcott, Louisa May'Autor='Little Women; Or, Meg, Jo, Beth, and Amy'} </br>
Cantidad de libros 8 </br>

[Inicio](#Inicio)
<h2>Listar autores registrados BD</h2> 
Digite opcion [1..8] 0=Salir--->3</br>
```
Hibernate: SELECT nombre, year_born, year_dead FROM autores </br>
```
Autor{nombre='Cervantes Saavedra, Miguel de', year_born=1547, year_dead=1616} </br>
Autor{nombre='Melville, Herman', year_born=1819, year_dead=1891} </br>
Autor{nombre='Hugo, Victor', year_born=1802, year_dead=1885} </br>
Autor{nombre='Shelley, Mary Wollstonecraft', year_born=1797, year_dead=1851} </br>
Autor{nombre='Austen, Jane', year_born=1775, year_dead=1817} </br>
Autor{nombre='Shakespeare, William', year_born=1564, year_dead=1616} </br>
Autor{nombre='Eliot, George', year_born=1819, year_dead=1880} </br>
Autor{nombre='Alcott, Louisa May', year_born=1832, year_dead=1888} </br>
Cantidad de autores grabados 8 </br>

[Inicio](#Inicio)

<h2>Listar autores vivos en un determinado año BD</h2> 
Digite opcion [1..8] 0=Salir--->4 </br>
Ingresa el año para consultar los autores que vivieron alredor de ese año :
1950 </br>
```
Hibernate: select a1_0.id,a1_0.nombre,a1_0.year_born,a1_0.year_dead from autores a1_0 where a1_0.year_born<=? and a1_0.year_dead is null <br/>
```
No hay autores vivos </br>

[Inicio](#Inicio)

<h2>Listar autores fallecidos BD</h2>
Digite opcion [1..8] 0=Salir---> <br/>
```
Hibernate: SELECT nombre, year_born, year_dead FROM autores WHERE year_dead IS NOT NULL <br/>
```
Autor{nombre='Cervantes Saavedra, Miguel de', year_born=1547, year_dead=1616} </br>
Autor{nombre='Melville, Herman', year_born=1819, year_dead=1891} </br>
Autor{nombre='Hugo, Victor', year_born=1802, year_dead=1885} </br>
Autor{nombre='Shelley, Mary Wollstonecraft', year_born=1797, year_dead=1851} </br>
Autor{nombre='Austen, Jane', year_born=1775, year_dead=1817} </br>
Autor{nombre='Shakespeare, William', year_born=1564, year_dead=1616} </br>
Autor{nombre='Eliot, George', year_born=1819, year_dead=1880} </br>
Autor{nombre='Alcott, Louisa May', year_born=1832, year_dead=1888} </br>
Cantidad de autores grabados 8 </br>

[Inicio](#Inicio)

<h2>Listar libros por idioma BD</h2>
<h3>*** EN CONSTRUCCION, me esta saliendo un error **** </h3>

Digite opcion [1..8] 0=Salir--->6  </br>
[es] - Español       [en] - Inglés </br>
[it] - Italiano      [fr] - Francés </br>
[pt] - Portugués     [fi] - Filandés </br>

Ingrese codigo del idioma a buscar: ej: es=español en=english---> en </br>
```
Hibernate: SELECT * FROM libros l WHERE LOWER(l.idioma) LIKE LOWER(CONCAT('%',?,'%') </br>
```
2025-06-20T18:37:57.851-05:00  WARN 12696 --- [           main] o.h.engine.jdbc.spi.SqlExceptionHelper   : SQL Error: 0, SQLState: 42601 </br>
2025-06-20T18:37:57.860-05:00 ERROR 12696 --- [           main] o.h.engine.jdbc.spi.SqlExceptionHelper   : ERROR: error de sintaxis al final de la entrada </br>
Position: 76 </br>
2025-06-20T18:37:57.931-05:00  INFO 12696 --- [           main] .s.b.a.l.ConditionEvaluationReportLogger : </br>
</br>
[Inicio](#Inicio)

<h2>Libros mas populares en la API GUTENDEX</h2>

Digite opcion [1..8] 0=Salir--->7 </br> 
Libros mas populares </br>
DLibro{autores=[DatosAutor[nombre=Shelley, Mary Wollstonecraft, yearBorn=1797, yearDead=1851]], titulo='Frankenstein; Or, The Modern Prometheus', idiomas=[en]} </br>
DLibro{autores=[DatosAutor[nombre=Melville, Herman, yearBorn=1819, yearDead=1891]], titulo='Moby Dick; Or, The Whale', idiomas=[en]} </br>
DLibro{autores=[DatosAutor[nombre=Shakespeare, William, yearBorn=1564, yearDead=1616]], titulo='Romeo and Juliet', idiomas=[en]} </br>
DLibro{autores=[DatosAutor[nombre=Austen, Jane, yearBorn=1775, yearDead=1817]], titulo='Pride and Prejudice', idiomas=[en]} </br>
DLibro{autores=[DatosAutor[nombre=Carroll, Lewis, yearBorn=1832, yearDead=1898]], titulo='Alice's Adventures in Wonderland', idiomas=[en]} </br>
DLibro{autores=[DatosAutor[nombre=Shakespeare, William, yearBorn=1564, yearDead=1616]], titulo='The Complete Works of William Shakespeare', idiomas=[en]} </br>
DLibro{autores=[DatosAutor[nombre=Alcott, Louisa May, yearBorn=1832, yearDead=1888]], titulo='Little Women; Or, Meg, Jo, Beth, and Amy', idiomas=[en]} </br>
DLibro{autores=[DatosAutor[nombre=Eliot, George, yearBorn=1819, yearDead=1880]], titulo='Middlemarch', idiomas=[en]} </br>
DLibro{autores=[DatosAutor[nombre=Forster, E. M. (Edward Morgan), yearBorn=1879, yearDead=1970]], titulo='A Room with a View', idiomas=[en]} </br>
DLibro{autores=[DatosAutor[nombre=Fitzgerald, F. Scott (Francis Scott), yearBorn=1896, yearDead=1940]], titulo='The Great Gatsby', idiomas=[en]} </br>
</br>
Explicación : generalmente son los libros que presentan mas descargas. (este campo no lo utilice) </br>
Utilice un endpoint de Gutendex </br>

[Inicio](#Inicio)

<h2>Buscar autor por nombre BD</h2>
Digite opcion [1..8] 0=Salir--->8 </br>
Digite nombre autor a buscar en BD : cervantes </br>
```
Hibernate: SELECT nombre, year_born, year_dead FROM autores WHERE LOWER(nombre) LIKE LOWER(CONCAT('%',?,'%')) </br>
```
Autor{nombre='Cervantes Saavedra, Miguel de', year_born=1547, year_dead=1616} </br>
- - - - - - - - - - - - - - - - - - - - - - </br>

[Inicio](#Inicio)
<h2>Salir</h2>
Digite opcion [1..8] 0=Salir--->0 </br>
Cerrando la menuPrincipal... </br>
2025-06-20T19:03:29.365-05:00  INFO 264 --- [ionShutdownHook] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default' </br>
2025-06-20T19:03:29.375-05:00  INFO 264 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated... </br>
2025-06-20T19:03:29.437-05:00  INFO 264 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed. </br>

[Inicio](#Inicio)

<h2>Tecnologías utilizadas</h2>
- Java <br/>
- Manejo de API GUTENDEX <br/>
- Postman  (para hacer las pruebas de la API) <br/>
- Editor IDE, Intellij IDEA <br/>
- git, github y terminal. <br/>
- LURI, IA de ALURA-ONE, Sao Pablo, Brazil. <br/>
- API, Exchangerate API. <br/>
- Gson, Api de Java, desarrollada por Google. <br/>
- plugins de Intellij IDEA, para mostrar README.md <br/>
- Trello (planeador de actividades a seguir de un proyecto) <br/>

[Inicio](#Inicio)

<h2>Personas o entidades contribuyentes en el Proyecto</h2>
- Alura LATAM, ONE(Oracle Next Education) <br/>
- Profesora. Genesys Rondón </br>
- Profesor. Bruno Dario Fernández Ellerbach <br/>
- Profesor. Eric Monné Fraga de Oliveira. <br/>

<h2>Desarrolladores del Proyecto</h2>
- René Avila Alonso. <br/>
- Desarrollador BackEnd <br/>
- June, 2025. </br>

[Inicio](#Inicio)