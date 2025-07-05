package com.aluracursos.literalura.dto;

public class LibroAutorIdiomaDTO {
   private String titulo;
   private String idioma;
   private String nombreAutor;

   public LibroAutorIdiomaDTO(String idioma, String nombreAutor, String titulo) {
      this.idioma = idioma;
      this.nombreAutor = nombreAutor;
      this.titulo = titulo;
   }
   // getters and setters

   public String getIdioma() {
      return idioma;
   }

   public void setIdioma(String idioma) {
      this.idioma = idioma;
   }

   public String getNombreAutor() {
      return nombreAutor;
   }

   public void setNombreAutor(String nombreAutor) {
      this.nombreAutor = nombreAutor;
   }

   public String getTitulo() {
      return titulo;
   }

   public void setTitulo(String titulo) {
      this.titulo = titulo;
   }

   @Override
   public String toString() {
      return "LibroAutorIdiomaDTO{" +
            "idioma='" + idioma + '\'' +
            ", titulo='" + titulo + '\'' +
            ", nombreAutor='" + nombreAutor + '\'' +
            '}';
   }
}
