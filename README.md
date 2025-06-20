![Programação-Java_ Persistencia de datos y consultas con Spring Data JPA](https://github.com/genesysR-dev/2066-java-persitencia-de-datos-y-consultas-con-Spring-JPA/assets/91544872/e0e3a9f8-afc7-4e7b-be83-469351ef2d70)

# Challenge LiterAlura by Rene Avila Alonso

Proyecto desarrollado durante el curso de la formación Avanzando con Java de Alura
para BackEnd

<h2>**22-java-literalura-g8-challenge**</h2>
<h3>Inicio</h3>
<em> MENU DE OPCIONES </em>
- - - - - - - - - - - - - - - - - - - - - -
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
Por medio del siguiente MENU DE OPCIONES: 

1. [Buscar libro por titulo](#buscar-libro-por-titulo)
2. [Listar libros registrados BD](#Listar-libros-registrados-bd)
3. [Listar autores registrados BD](#Listar-autores-registrados-bd)
4. [Listar autores vivos en un determinado año BD](#listar-autores-vivos-en-un-determinado-año-bd)



[Descripción proyecto](#descripción-proyecto) \
[Como usar el programa](#como-usar-el-programa) \

[Listado paises incluidos para conversión](#listado-de-paises-incluidos-para-conversión) \
[Conversión de monedas](#Conversión-de-monedas) \
[Listar paises con nombres similares](#Listar-paises-con-nombres-similares)\
[Listar registros con marca de tiempo](#Listar-registros-con-marca-de-tiempo) \
[Listar registros de una fecha especifica](#Listar-registros-de-una-fecha-especifica) \
[Tecnologías utilizadas](#Tecnologías-utilizadas) \
[Personas o entidades contribuyentes en el Proyecto](#Personas-o-entidades-contribuyentes-en-el-Proyecto) \
[Desarrolladores del Proyecto](#Desarrolladores-del-Proyecto)

<h2>Como usar el programa</h2>
**Literalura**   <br/>
1. Buscar libro por título y grabar en BD.
2. Listar libros registrados BD.
3. Listar autores registrados BD.
4. Listar autores vivos en un determinado año BD.
5. Listar autores fallecidos BD.
6. Listar libros por idioma BD.
7. Libros mas populares en la API gutendex.
8. Buscar autor por nombre BD.
0. Salir.

Digite opción [1..8] o [0.Salir] 1
<h4>Explicación.</h4>
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
```
[Inicio](#Inicio)
<h2>Listar autores registrados BD</h2> 
Digite opcion [1..8] 0=Salir--->3</br>
Hibernate: SELECT nombre, year_born, year_dead FROM autores </br>
```
Autor{nombre='Cervantes Saavedra, Miguel de', year_born=1547, year_dead=1616}
Autor{nombre='Melville, Herman', year_born=1819, year_dead=1891}
Autor{nombre='Hugo, Victor', year_born=1802, year_dead=1885}
Autor{nombre='Shelley, Mary Wollstonecraft', year_born=1797, year_dead=1851}
Autor{nombre='Austen, Jane', year_born=1775, year_dead=1817}
Autor{nombre='Shakespeare, William', year_born=1564, year_dead=1616}
Autor{nombre='Eliot, George', year_born=1819, year_dead=1880}
Autor{nombre='Alcott, Louisa May', year_born=1832, year_dead=1888}
Cantidad de autores grabados 8
```
[Inicio](#Inicio)

<h2>Listar autores vivos en un determinado año BD</h2>
<h4>Al seleccionar opcion 1. Sale un listado asi:</h4>

1-(AED)=United Arab Emirates *|* 2-(AFN)=Afghanistan *|* 3-(ALL)=Albania *|* 4-(AMD)=Armenia *|* 5-(ANG)=Netherlands Antilles *|* _
6-(AOA)=Angola *|* 7-(ARS)=Argentina *|* 8-(AUD)=Australia *|* 9-(AWG)=Aruba *|* 10-(AZN)=Azerbaijan *|* _
11-(BAM)=Bosnia and Herzegovina *|* 12-(BBD)=Barbados *|* 13-(BDT)=Bangladesh *|* 14-(BGN)=Bulgaria *|* 15-(BHD)=Bahrain *|* _
16-(BIF)=Burundi *|* 17-(BMD)=Bermuda *|* 18-(BND)=Brunei *|* 19-(BOB)=Bolivia *|* 20-(BRL)=Brazil *|* _
21-(BSD)=Bahamas *|* 22-(BTN)=Bhutan *|* 23-(BWP)=Botswana *|* 24-(BYN)=Belarus *|* 25-(BZD)=Belize *|* _
26-(CAD)=Canada *|* 27-(CDF)=Democratic Republic of the Congo *|* 28-(CHF)=Switzerland *|* 29-(CLP)=Chile *|* 30-(CNY)=China *|* _
31-(COP)=Colombia *|* 32-(CRC)=Costa Rica *|* 33-(CUP)=Cuba *|* 34-(CVE)=Cape Verde *|* 35-(CZK)=Czech Republic *|* _ <br/>
asi.. hasta completar los paises, que maneja la API.<br/>
[link API-Exchangerate](https://www.exchangerate-api.com/docs/overview) </br>
[Inicio](#Inicio)


<h2>Conversión de monedas</h2>
<h4>opcion 2.</h4>
Digite opción [1..5] o [9.Salir] 2

Digite Pais Fuente :colombia <br/>
Pais{codeCurrency='COP', currencyName='Colombian Peso', country='Colombia'} <br/>
Codigo moneda :COP, pais :Colombia <br/>
Digite Pais Destino :estados unidos <br/>
Pais{codeCurrency='USD', currencyName='United States Dollar', country='Estados Unidos'} <br/>
A Codigo moneda :USD, pais :Estados Unidos <br/>
Valor a convertir, en COP :500000

Resultado.\
Result :Currency[base_code=COP, target_code=USD, conversion_rate=2.3622E-4] <br/>
Conversion 500000,00  COP   Colombian Peso son 118,11  USD United States Dollar <br/>
<h4>Explicación.</h4>
En la digitación o captura del pais, sea fuente o destino, se valida que el país, <br/>
este el la tabla de conversiones.<br/>
No puede colocar paises repetidos, o nombres de paises que no esten. <br/>
Ejemplo. Colombia, puede colocar colo, Colo, Colomb, col, Colombia, etc. <br/>
El programa le pasa todo el texto a minúscula y mayúscula a la primera letra.<br/>
Para el caso de Europa, donde hay 27 paises que utilizan el EURO, hay que digitar
"European Union" o "union", para que tome el EURO. </br>

[Inicio](#Inicio)

<h2>Listar paises con nombres similares</h2>
<h4>Opcion 3.</h4>

Dígite Pais con nombres similiares :pa

**Paises con nombres similares** <br/>
->Panama PAB <br/>
->Papua New Guinea PGK <br/>
->Pakistan PKR <br/>
->Paraguay PYG <br/>
<h4>Explicación.</h4>
Se puede digitar como minimo 2 caracteres del nombre del pais a BUSCAR <br/>

[Inicio](#Inicio)

<h2>Listar registros con marca de tiempo</h2>
<h4>Opcion 4.</h4>
Digite opción [1..5] o [9.Salir] 4 <br/>
Moneda{base='COP', target='USD', factor =2.3618E-4, valor a convertir=100000.0, valor conversion=23.618000000000002, fecha='2025-05-04 16:37:27'} <br/>
Moneda{base='COP', target='USD', factor =2.3502E-4, valor a convertir=10000.0, valor conversion=2.3502, fecha='2025-05-06 10:18:53'} <br/>
Moneda{base='EUR', target='USD', factor =1.1321, valor a convertir=10000.0, valor conversion=11321.000000000002, fecha='2025-05-06 10:40:16'} <br/>
Moneda{base='USD', target='AED', factor =3.6725, valor a convertir=10000.0, valor conversion=36725.0, fecha='2025-05-06 11:00:23'} <br/>
Lista todas las transacciones que se han realizado hasta el momento. <br/>

<h4>Explicación.</h4>
Con esta opcion usted vera todos los movimientos diarios, que estan en <br/>
en los registros grabados, cuando se hace una conversión. <br/>

[Inicio](#Inicio)

<h2>Listar registros de una fecha especifica</h2>
<h4>Opcion 5.</h4>
Digite opción [1..5] o [9.Salir] 5 </br>

Ingrese una fecha Inicial (yyyy-MM-dd): 2025-05-04 </br>
Ingrese una fecha Final (yyyy-MM-dd): 2025-05-30 </br>
Resultado: </br>
Listado de movimientos entre 2025-05-04 hasta 2025-05-30 </br>
Moneda{base='COP', target='USD', factor=2.3618E-4, valor convertir=100000.0, valor conversion=23.618000000000002, fecha='2025-05-04 16:37:27'} </br>
Moneda{base='COP', target='USD', factor=2.3502E-4, valor convertir=10000.0, valor conversion=2.3502, fecha='2025-05-06 10:18:53'} </br>
Moneda{base='EUR', target='USD', factor=1.1321, valor convertir=10000.0, valor conversion=11321.000000000002, fecha='2025-05-06 10:40:16'} </br>
Moneda{base='USD', target='AED', factor=3.6725, valor convertir=10000.0, valor conversion=36725.0, fecha='2025-05-06 11:00:23'} </br>
[Inicio](#Inicio)

<h2>Tecnologías utilizadas</h2>

- Java
- Manejo de API's
- Postman  (para hacer las pruebas de la API)
- Editor IDE, Intellij IDEA
- git, github y terminal.
- LURI, IA de ALURA-ONE, Sao Pablo, Brazil.
- API, Exchangerate API.
- Gson, Api de Java, desarrollada por Google.
- plugins de Intellij IDEA, para mostrar README.md
- Trello (planeador de actividades a seguir de un proyecto)

[Inicio](#Inicio)

<h2>Personas o entidades contribuyentes en el Proyecto</h2>
- Alura LATAM, ONE(Oracle Next Education)
- Profesora. Genesys Rondón </br>
- Profesor. Bruno Dario Fernández Ellerbach
- Profesor. Eric Monné Fraga de Oliveira.

<h2>Desarrolladores del Proyecto</h2>
- René Avila Alonso.
- Desarrollador BackEnd
- May, 2025. </br>

[Inicio](#Inicio)