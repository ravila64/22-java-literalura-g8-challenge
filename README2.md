<h2>**18-challenge-conversor-monedas-alura**</h2>
<h3>Inicio</h3>
<em> TEMATICA </em>

[Como accesar la APIKEY](#como-accesar-la-apikey) 

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

<h2>Como accesar la APIKEY</h2>
En el modulo RutinasPais.java esta el acceso a la APIKEY <br/>
``
String api_key = System.getenv("API_KEY_EXCHANGERATE");
``<br/>
En la cual se utilizo con una variable del sistema (de entorno). <br/>
Ustedes para la prueba de funcionamiento asignan a la variable <br/>
``
String api_key="su_api_key"; 
``
que generarón. <br/>
El programa principal esta en el package main <br/> 


[Inicio](#Inicio)
<h2>Descripción proyecto</h2>
Construir tu propio Conversor de Monedas. <br/> 
Aprenderás a realizar solicitudes a una API de tasas de cambio, a manipular datos JSON y,
finalmente, a filtrar y mostrar las monedas de interés.<br/>

Los pasos para completar este desafío se detallo: <br/>
A) Configuración del Ambiente Java; <br/>
B) Creación del Proyecto; <br/>
C) Consumo de la API; <br/>
D) Análisis de la Respuesta JSON; <br/>
E) Filtro de Monedas; <br/>
F) Exibición de Resultados a los usuarios <br/>

[Inicio](#Inicio)

<h2>Como usar el programa</h2>
**Conversor de monedas**   <br/>
1. Listado paises incluidos para conversión <br/>
2. Conversión de monedas <br/>
3. Listar paises con nombres similares <br/>
4. Listar movimientos diarios <br/>
5. Listar movimientos de una fecha especifica </br>
9. Salir <br/>

Digite opción [1..5] o [9.Salir] 1
<h4>Explicación.</h4>
Aqui puede digitar la opcion, dentro del rango permitido, si hay error </br>
de digitación se devuelve a leer opción. </br>

[Inicio](#Inicio)

<h2>Listado paises incluidos para conversión</h2>
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


