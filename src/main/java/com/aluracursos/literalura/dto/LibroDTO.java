package com.aluracursos.literalura.dto;

import com.aluracursos.literalura.model.Autor;

public class LibroDTO {
   private String titulo;
   private String idioma;
   private Autor autor;

   public LibroDTO(Autor autor, String idioma, String titulo) {
      this.autor = autor;
      this.idioma = idioma;
      this.titulo = titulo;
   }

   public Autor getAutor() {
      return autor;
   }

   public void setAutor(Autor autor) {
      this.autor = autor;
   }

   public String getIdioma() {
      return idioma;
   }

   public void setIdioma(String idioma) {
      this.idioma = idioma;
   }

   public String getTitulo() {
      return titulo;
   }

   public void setTitulo(String titulo) {
      this.titulo = titulo;
   }

   @Override
   public String toString() {
      return "LibroDTO{" +
            "idioma='" + idioma + '\'' +
            ", titulo='" + titulo + '\'' +
            ", autor=" + autor +
            '}';
   }

}
