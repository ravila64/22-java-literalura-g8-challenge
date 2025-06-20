package com.aluracursos.literalura.repository;

import com.aluracursos.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
   Optional<Autor> findByNombreContainsIgnoreCase(String nombre);

   @Query("SELECT a FROM Autor a WHERE a.yearBorn <= :year AND a.yearDead=null")
   List<Autor> filtrarAutoresXAnioVivos(int year);

   // Si no ha fallecido
   @Query("SELECT a FROM Autor a WHERE a.yearDead<>0")   // o a.year_dead=null
   List<Autor> filtrarAutoresFallecidos();

   // Queries nativos
   @Query(value = "SELECT nombre, year_born, year_dead FROM autores", nativeQuery = true)
   List<Object[]> listarAutoresBD();

}
