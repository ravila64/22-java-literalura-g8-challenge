package com.aluracursos.literalura.main;

import com.aluracursos.literalura.dto.*;
import com.aluracursos.literalura.model.Autor;
import com.aluracursos.literalura.model.DatosLibro;
import com.aluracursos.literalura.model.Libro;
import com.aluracursos.literalura.repository.AutorRepository;
import com.aluracursos.literalura.repository.LibroRepository;
import com.aluracursos.literalura.service.ConsumirAPI;
import com.aluracursos.literalura.service.ConvertirDatos;

import java.time.Year;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainLiterAlura {
   private final String URL_BASE = "https://gutendex.com/books/";
   private final String URL_FIND = "?search=";
   private final Scanner teclado = new Scanner(System.in);
   private LibroRepository libroRepository;
   private AutorRepository autorRepository;
   private ConvertirDatos convertirDatos = new ConvertirDatos();
   private ConsumirAPI consumirAPI = new ConsumirAPI();

   public MainLiterAlura(LibroRepository libroRepository, AutorRepository autorRepository) {
      this.libroRepository = libroRepository;
      this.autorRepository = autorRepository;
   }

   private int opcion = -1;

   public void menuPrincipal() {
      while (opcion != 0) {
         String OPC = """
               - - - - - - - - - - - - - - - - - - - - - -
               1. Buscar libro por título y grabar en BD.
               2. Listar libros registrados BD.
               3. Listar autores registrados BD.
               4. Listar autores vivos en un determinado año BD.
               5. Listar autores fallecidos BD.
               6. Listar libros por idioma BD.
               7. Libros mas populares en la API gutendex.
               8- Buscar autor por nombre BD.
               0- Salir.
               """;
         System.out.println(OPC);
         System.out.print("Digite opcion [1..8] 0=Salir--->");
         opcion = teclado.nextInt();
         teclado.nextLine();

         switch (opcion) {
            case 1:
               buscarLibroPorTituloYGrabarEnBD();
               break;
            case 2:
               obtenerTodosLosLibros();
               break;
            case 3:
               // lista todos los autores registrados
               obtenerTodosLosAutores(1);
               break;
            case 4:
               autoresVivosDadoUnAnio();
               break;
            case 5:
               // lista todos los Autores Fallecidos de la BD
               obtenerTodosLosAutores(2);
               break;
            case 6:
               //obtenerLibrosPorIdioma();
               obtenerLibrosAutoresIdioma();
               break;
            case 7:
               obtenerLibrosMasPopulares();
               break;
            case 8:
               // buscar autores x nombre en la BD
               obtenerTodosLosAutores(3);
               break;
            case 0:
               System.out.println("Cerrando la menuPrincipal...");
               break;
            default:
               System.out.println("Opción invalida");
               break;
         }
      } // end sw
   }

   public List<DatosLibro> getPopularDatosLibro() {
      // la API por default trae lo más populares; sin embargo añadimos la query..
      String json = consumirAPI.obtenerDatos(URL_BASE + "?sort=popular");
      //List<DatosLibro> libros = convertirDatos.convertData(json, Datos.class).results();
      return convertirDatos.convertData(json, Datos.class).results();
   }

   public Optional<DatosLibro> getDatosLibro(String tituloUsu) {
      String json = consumirAPI.obtenerDatos(URL_BASE + URL_FIND + tituloUsu.toLowerCase().replace(" ", "+"));
      //List<DatosLibro> libros = convertirDatos.convertData(json, Datos.class).results();
      List<DatosLibro> libros = convertirDatos.convertData(json, Datos.class).results();
      return libros.stream()
            .filter(l -> l.titulo().toLowerCase().contains(tituloUsu.toLowerCase()))
            .findFirst();
   }

   public void buscarLibroPorTituloYGrabarEnBD() {
      System.out.println("Ingresar titulo del libro a buscar: ");
      String tituloLib = teclado.nextLine();

      Optional<DatosLibro> libroEnAPI = getDatosLibro(tituloLib);
      //busqueda en la base de datos de libros
      Optional<Libro> dbLibro = libroRepository.findByTituloContainsIgnoreCase(tituloLib);
      if (dbLibro.isPresent()) {
         System.out.println("Libro ya existe en BD");
         System.out.println(dbLibro.get());
         // si encontramos el libro en la api...
      } else if (libroEnAPI.isPresent()) {
         // busqueda y grabacion autor nuevo
         List<Autor> listaAutores = libroEnAPI.get().autores().stream()
               .map(a -> autorRepository.findByNombreContainsIgnoreCase(a.nombre())
                     .orElseGet(() -> autorRepository.save(new Autor(a))))
               .collect(Collectors.toList());
         Libro nuevoLibroBD = new Libro(libroEnAPI.get(), listaAutores);
         libroRepository.save(nuevoLibroBD);
         System.out.println(nuevoLibroBD);
      } else {
         System.out.println("Libro no encontrado !!! ");
      }
   }

   public List<LibroAutorDTO> getLibroAutor() {
      List<Object[]> rawResults = libroRepository.listarLibrosYAutores();
      return rawResults.stream()
            .map(obj -> new LibroAutorDTO(
                  (String) obj[0],
                  (String) obj[1]
            ))
            .collect(Collectors.toList());
   }

   public void obtenerTodosLosLibros() {
      //List<Libro> dbLibros = libroRepository.findAll();
      List<LibroAutorDTO> librosAutores = this.getLibroAutor();
      if (!librosAutores.isEmpty()) {
         librosAutores.forEach(System.out::println);
         System.out.println("Cantidad de libros " + librosAutores.size());
      } else {
         System.out.println("No existen libros");
      }
   }

   public List<LibroAutorIdiomaDTO> getLibroAutorIdioma() {
      List<String> idiomas = List.of("es", "en", "it", "fr", "pt", "fi");
      String menuIdiomas = """
            [es] - Español       [en] - Inglés
            [it] - Italiano      [fr] - Francés
            [pt] - Portugués     [fi] - Filandés 
            """;
      System.out.println(menuIdiomas);
      System.out.print("Ingrese codigo del idioma a buscar: ej: es=español en=english---> ");
      String codigoIdioma = teclado.nextLine();
      // valida
      while (!idiomas.contains(codigoIdioma)) {
         System.out.println("Error, ingresar un idioma de la lista: ");
         codigoIdioma = teclado.nextLine();
      }

      //List<Object[]> rawResults = libroRepository.listarLibrosYAutores();
      List<Object[]> rawResults = libroRepository.findLibrosPorIdiomaLike(codigoIdioma);
      return rawResults.stream()
            .map(obj -> new LibroAutorIdiomaDTO(
                  (String) obj[0],
                  (String) obj[1],
                  (String) obj[2]
            ))
            .collect(Collectors.toList());
   }

   public void obtenerLibrosAutoresIdioma() {
      List<LibroAutorIdiomaDTO> librosAutores = this.getLibroAutorIdioma();
      if (!librosAutores.isEmpty()) {
         librosAutores.forEach(System.out::println);
         System.out.println("Cantidad de libros " + librosAutores.size());
      } else {
         System.out.println("No existen libros");
      }
   }

   public List<AutorDTO> obtenerAutoresDTO(int opc) {
      List<Object[]> resultados;
      if (opc == 1) {
         resultados = autorRepository.listarAutoresBD();
      }else if(opc==2) {
         resultados = autorRepository.listarAutoresFallecidos();
      }else {
         System.out.print("Digite nombre autor a buscar en BD : ");
         String nombreBuscar = teclado.nextLine();
         resultados = autorRepository.buscarAutoresPorNombre( nombreBuscar );
      }
      return resultados.stream()
            .map(obj -> new AutorDTO(
                  (String) obj[0],
                  (Integer) obj[1],
                  (Integer) obj[2]
            ))
            .collect(Collectors.toList());
   }

   // parametro 1 =lista todos los autores
   // parametro 2=autores con condiciom
   public void obtenerTodosLosAutores(int opcion) {
      List<AutorDTO> dbAutores;
      if (opcion == 1) {
         dbAutores = this.obtenerAutoresDTO(1);
      } else if(opcion == 2){
         dbAutores = this.obtenerAutoresDTO(2);
      }else{
         dbAutores = this.obtenerAutoresDTO(3);
      }
      if (!dbAutores.isEmpty()) {
         dbAutores.forEach(System.out::println);
         if(opcion!=3){
               System.out.println("Cantidad de autores grabados " + dbAutores.size());
         }
      } else {
         System.out.println("No hay autores grabados en BD");
      }
   }

   public void autoresVivosDadoUnAnio() {
      int anioActual = Year.now().getValue();
      boolean salir = false;
      int year = 0;
      while (!salir) {
         System.out.println("Ingresa el año para consultar los autores que vivieron alredor de ese año : ");
         year = teclado.nextInt();
         teclado.nextLine();
         if (year > (anioActual - 100)) {
            salir = true;
         } else {
            System.out.println("Digite un año del ultimo siglo, ya que son autores vivos");
         }
      }
      List<Autor> autoresBuscados = autorRepository.filtrarAutoresXAnioVivos(year);
      if (!autoresBuscados.isEmpty()) {
         autoresBuscados.forEach(System.out::println);
      } else {
         System.out.println("No hay autores vivos");
      }
   }

   public void obtenerLibrosPorIdioma() {
      List<String> idiomas = List.of("es", "en", "it", "fr", "pt", "fi");
      String menuIdiomas = """
            [es] - Español       [en] - Inglés
            [it] - Italiano      [fr] - Francés
            [pt] - Portugués     [fi] - Filandés 
            """;
      System.out.println(menuIdiomas);
      System.out.print("Ingrese codigo del idioma a buscar: ej: es=español en=english---> ");
      String codigoIdioma = teclado.nextLine();
      // valida
      while (!idiomas.contains(codigoIdioma)) {
         System.out.println("Error, ingresar un idioma de la lista: ");
         codigoIdioma = teclado.nextLine();
      }



      //List<LibroAutorDTO> dbLibros = libroRepository.buscarLibrosPorIdiomaLike(codigoIdioma);
      codigoIdioma = codigoIdioma.trim().toLowerCase();
      //Optional<LibroDTO> dbLibros = libroRepository.buscarLibrosPorIdiomaLike(codigoIdioma);
      List<Object[]> dbLibros = libroRepository.findLibrosPorIdiomaLike(codigoIdioma);
//      System.out.println("dblibros opcion 6, x idioma \n"+dbLibros);
//      if (!dbLibros.isEmpty()) {
//         List<LibroAutorIdiomaDTO> filtrados = dbLibros.stream()
//               .filter(libro -> idiomas.contains(libro.getIdioma()))
//               .toList();
//         filtrados.forEach(System.out::println);
//      } else {
//         System.out.println("No hay libros registrados del idioma : " + codigoIdioma);
//      }

   }

   public void obtenerLibrosMasPopulares() {
      List<DatosLibro> librosMasPopulares = getPopularDatosLibro().stream()
            .limit(10)
            .toList();
      // estaba collect(Collectors.toList())
      System.out.println("Libros mas populares");
      librosMasPopulares.forEach(b -> System.out.println(b.toString()));
   }
}
