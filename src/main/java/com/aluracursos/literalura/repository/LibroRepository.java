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

   @Query(value = """
    SELECT l.titulo AS titulo, a.nombre AS nombreAutor
    FROM libros l
    INNER JOIN autores a ON l.autor_id = a.id
    """, nativeQuery = true)
   List<Object[]> listarLibrosYAutores();


   @Query(value = """
    SELECT l.titulo, a.nombre, l.idioma FROM libros l INNER JOIN autores a ON l.autor_id = a.id  
    WHERE LOWER(l.idioma) LIKE LOWER(CONCAT('%',:language,'%')) 
    """, nativeQuery = true)
   List<Object[]> findLibrosPorIdiomaLike(@Param("language") String language);

   // buscar libros de un idioma
   //List<LibroDTO> findByIdiomaIgnoreCase(String idioma);

}
