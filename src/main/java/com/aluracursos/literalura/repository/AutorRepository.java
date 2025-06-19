package com.aluracursos.literalura.repository;

import com.aluracursos.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
   Optional<Autor> findByNombreContainsIgnoreCase(String name);

   @Query("SELECT a FROM Autor a WHERE a.year_born <= :year AND a.year_dead=0")
   List<Autor> filtrarAutoresXAnioVivos(int year);

   // Si no ha fallecido
   @Query("SELECT a FROM Autor a WHERE a.year_dead<>0")   // o a.year_dead=null
   List<Autor> filtrarAutoresFallecidos();

}
