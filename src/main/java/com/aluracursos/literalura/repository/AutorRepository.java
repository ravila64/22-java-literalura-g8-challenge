package com.aluracursos.literalura.repository;

import com.aluracursos.literalura.dto.AutorDTO;
import com.aluracursos.literalura.dto.LibroAutorDTO;
import com.aluracursos.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
   Optional<Autor> findByNombreContainsIgnoreCase(String nombre);

   // lista autores vivos
   @Query("SELECT a FROM Autor a WHERE a.yearBorn <= :year AND a.yearDead IS NULL")
   List<Autor> filtrarAutoresXAnioVivos(int year);

   // Queries nativos, lista todos los autores de la BD
   @Query(value = "SELECT nombre, year_born, year_dead FROM autores", nativeQuery = true)
   List<Object[]> listarAutoresBD();

   // Lista todos los autores fallecidos
   @Query(value = "SELECT nombre, year_born, year_dead FROM autores WHERE year_dead IS NOT NULL", nativeQuery = true)
   List<Object[]> listarAutoresFallecidos();

   // listar autores por nombre
   @Query(value = "SELECT nombre, year_born, year_dead FROM autores WHERE LOWER(nombre) LIKE LOWER(CONCAT('%',:nombreBuscar,'%')) ", nativeQuery = true)
   List<Object[]> buscarAutoresPorNombre(String nombreBuscar);

   // Esta busqueda tambien sirve
   @Query(value = "SELECT * FROM autores WHERE nombre LIKE CONCAT('%', :nombreBuscar, '%')", nativeQuery = true)
   List<Autor> buscarPorNombre(@Param("nombreBuscar") String nombreBuscar);

}
