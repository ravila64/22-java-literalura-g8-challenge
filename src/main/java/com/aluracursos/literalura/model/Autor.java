package com.aluracursos.literalura.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "autores")
public class Autor {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nombre;
   private Integer yearBorn;
   private Integer yearDead;
   @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   private List<Libro> libros;

   public Autor() {}

   public Autor(DatosAutor dA) {
      this.nombre = dA.nombre();
      this.yearBorn = dA.yearBorn();
      this.yearDead = dA.yearDead();
   }

   // getters and setters

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public List<Libro> getLibros() {
      return libros;
   }

   public void setLibros(List<Libro> libros) {
      this.libros = libros;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public Integer getYearBorn() {
      return yearBorn;
   }

   public void setYearBorn(Integer yearBorn) {
      this.yearBorn = yearBorn;
   }

   public Integer getYearDead() {
      return yearDead;
   }

   public void setYearDead(Integer yearDead) {
      this.yearDead = yearDead;
   }

// antes estaba el .stream() asi
//   List<String> autorLibros = libros.stream()
//         .map(l -> l.getTitulo())
//         .collect(Collectors.toList());
   @Override
   public String toString() {
      List<String> autorLibros = libros.stream()
            .map(Libro::getTitulo)
            .toList();
      return "Autor{" +
            ", nombre='" + nombre + '\'' +
            ", yearBorn=" + yearBorn +
            ", yearDead=" + yearDead +
            ", libros=" + libros +
            '}';
   }

}
