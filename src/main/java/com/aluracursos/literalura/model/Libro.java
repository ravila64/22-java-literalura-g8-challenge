package com.aluracursos.literalura.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String titulo;
   private String idioma;
   @ManyToOne
   @JoinColumn(name = "autor_id")
   private Autor autor;

   public Libro() {}

   public Libro(DatosLibro dLibro, List<Autor> autorLista) {
      this.titulo = dLibro.titulo();
      this.idioma = dLibro.idiomas().get(0);
      this.autor = autorLista.get(0);
   }
   // getters and setters
   public Autor getAuthor() {
      return autor;
   }

   public void setAuthor(Autor autor) {
      this.autor = autor;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getLanguage() {
      return idioma;
   }

   public void setLanguage(String idioma) {
      this.idioma = idioma;
   }

   public String getTitulo() {
      return titulo;
   }

   public void setTitulo(String titulo) {
      this.titulo = titulo;
   }
   // toString

   @Override
   public String toString() {
      return "Libro{" +
            "autor=" + autor +
            ", titulo='" + titulo + '\'' +
            ", idioma='" + idioma + '\'' +
            '}';
   }
}
