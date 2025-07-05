package com.aluracursos.literalura.repository;

import com.aluracursos.literalura.dto.LibroDTO;
import com.aluracursos.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {
   Optional<Libro> findByTituloContainsIgnoreCase(String title);

//   @Query("SELECT l FROM Libro l WHERE l.idioma = :lang")
//   List<Libro> filtrarLibrosPorIdioma(String lang);
   //** Realiza una unión interna entre Libro y su relación autor,
   //** y usa FETCH para traer también los datos del autor en la misma consulta,
   //** evitando el lazy loading.
   //** @Query("SELECT l FROM Libro l JOIN FETCH l.autor")  //jpql
//   @Query(value = "SELECT * FROM libros l INNER JOIN autores a ON l.autor_id=a.id", nativeQuery = true ) //sql nativo
//   List<Libro> obtenerLibrosConAutores();

   @Query(value = """
    SELECT l.titulo AS titulo, a.nombre AS nombreAutor
    FROM libros l
    INNER JOIN autores a ON l.autor_id = a.id
    """, nativeQuery = true)
   List<Object[]> listarLibrosYAutores();

//   @Query(value = "SELECT * FROM libros l WHERE LOWER(l.idioma) LIKE LOWER(CONCAT('%',:lang,'%')); ", nativeQuery = true)
//   Optional<LibroDTO> buscarLibrosPorIdiomaLike(String lang);

   @Query(value = """
    SELECT l.titulo, a.nombre, l.idioma FROM libros l 
    INNER JOIN autores a ON l.autor_id = a.id 
    WHERE LOWER(l.idioma) LIKE LOWER(CONCAT('%',:language,'%')) 
    """, nativeQuery = true)
   List<Object[]> findLibrosPorIdiomaLike(@Param("language") String language);

   // buscar libros de un idioma
   List<LibroDTO> findByIdiomaIgnoreCase(String idioma);

//   @Query(value = "SELECT * FROM libros WHERE idioma IN (:idiomas)", nativeQuery = true)
//   List<Libro> findByIdiomaEnLista(@Param("idioma") List<String> idiomas);

}
