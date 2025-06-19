package com.aluracursos.literalura.main;

import com.aluracursos.literalura.dto.Datos;
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
                    1. Buscar libro por título.
                    2. Listar libros registrados.
                    3. Listar autores registrados.
                    4. Listar autores vivos en un determinado año.
                    5. Listar autores fallecidos
                    6. Listar libros por idioma.
                    7. Libros mas populares en la API gutendex
                    8- Buscar autor por nombre.
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
               obtenerTodosLosAutores();
               break;
            case 4:
               autoresVivosDadoUnAnio();
               break;
            case 5:
               listaAutoresFallecidosBD();
               break;
            case 6:
               obtenerLibrosPorIdioma();
               break;
            case 7:
               obtenerLibrosMasPopulares();
               break;
            case 8:
               obtenerAutoresPorNombre();
               break;
            case 0:
               System.out.println("Cerrando la menuPrincipal...");
               break;
            default:
               System.out.println("Opción invalida");
               break;
         }
      }
   }

   public List<DatosLibro> getPopularDatosLibro() {
      // la API por default trae lo más populares; sin embargo añadimos la query..
      String json = consumirAPI.obtenerDatos(URL_BASE + "?sort=popular");
      //List<DatosLibro> libros = convertirDatos.convertData(json, Datos.class).results();
      return convertirDatos.convertData(json, Datos.class).results();
   }

   public Optional<DatosLibro> getDatosLibro(String tituloUsu) {
      String json = consumirAPI.obtenerDatos(URL_BASE + URL_FIND + tituloUsu.toLowerCase().replace(" ", "+"));
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
         Libro nuevoLibroBD = new Libro(libroEnAPI.get(),listaAutores);
         libroRepository.save(nuevoLibroBD);
         System.out.println(nuevoLibroBD);
      } else {
         System.out.println("Libro no encontrado :(");
      }
   }

   public void obtenerTodosLosLibros() {
      //List<Libro> dbLibros = libroRepository.findAll();
      List<Libro> dbLibros = libroRepository.obtenerLibrosConAutores();
      if (!dbLibros.isEmpty()){
         //dbLibros.forEach(libro -> System.out.println(libro));
         dbLibros.forEach(System.out::println);
         System.out.println("Cantidad de libros grabados "+dbLibros.size());
      }else{
         System.out.println("No existen libros");
      }
   }

   public void obtenerTodosLosAutores() {
      List<Autor> dbAutores = autorRepository.findAll();
      dbAutores.forEach(System.out::println);
      System.out.println("Cantidad de autores grabados "+dbAutores.size());
   }

   public void autoresVivosDadoUnAnio() {
      int anioActual = Year.now().getValue();
      boolean salir=false;
      int year=0;
      while (!salir){
         System.out.println("Ingresa el año para consultar los autores que vivieron alredor de ese año : ");
         year = teclado.nextInt();
         teclado.nextLine();
         if(year > (anioActual-100)){
            salir = true;
         }
         System.out.println("Digite un año del ultimo siglo, ya que son autores vivos");
      }
      List<Autor> autoresBuscados = autorRepository.filtrarAutoresXAnioVivos(year);
      if(!autoresBuscados.isEmpty()){
         autoresBuscados.forEach(System.out::println);
      }else{
         System.out.println("No hay autores vivos");
      }
   }

   public void listaAutoresFallecidosBD() {
      System.out.println("Autores fallecidos ");
      List<Autor> autoresFallecidos = autorRepository.filtrarAutoresFallecidos();
      autoresFallecidos.forEach(System.out::println);
   }

   public void obtenerLibrosPorIdioma() {
      List<String> idiomas = List.of("es", "en", "it", "fr", "pt", "fi");
      String menuIdiomas = """
                [es] - Español       [en] - Inglés
                [it] - Italiano      [fr] - Francés
                [pt] - Portugués     [fi] - Filandés 
                """;
      System.out.println(menuIdiomas);
      System.out.print("Ingrese codigo del idioma a buscar: ej: es en---> ");
      String codigoIdioma = teclado.nextLine();
      // valida
      while (!idiomas.contains(codigoIdioma)) {
         System.out.println("Error, ingresar un idioma de la lista: ");
         codigoIdioma = teclado.nextLine();
      }
      List<Libro> dbLibros = libroRepository.filtrarLibrosPorIdioma(codigoIdioma);

      if (dbLibros.isEmpty()) {
         System.out.println("No hay libros registrados del idioma : "+ codigoIdioma);
      } else {
         dbLibros.forEach(System.out::println);
      }
   }

   public void obtenerLibrosMasPopulares(){
      List<DatosLibro> librosMasPopulares = getPopularDatosLibro().stream()
            .limit(10)
            .toList();
            // estaba collect(Collectors.toList())
      System.out.println("Libros mas populares");
      librosMasPopulares.forEach(b -> System.out.println(b.toString()));
   }

   public void obtenerAutoresPorNombre() {
      System.out.println("Digite nombre autor: ");
      String nombreAut = teclado.nextLine();
      Optional<Autor> autorEnLaBD = autorRepository.findByNombreContainsIgnoreCase(nombreAut);

      if (autorEnLaBD.isPresent()) {
         System.out.println(autorEnLaBD.get());
      } else {
         System.out.println("Autor no registrado");
      }
   }
}
