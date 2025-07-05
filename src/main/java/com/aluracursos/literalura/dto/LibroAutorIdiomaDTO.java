package com.aluracursos.literalura.dto;

public class LibroAutorIdiomaDTO {
   private String idioma;
   private String nombreAutor;
   private String titulo;

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

   // revisar la posicion del elemento en el objeto
   @Override
   public String toString() {
      return "LibroAutorIdiomaDTO{" +
            "Titulo='" + idioma + '\'' +
            ", nombreAutor='" + nombreAutor + '\'' +
            ", idioma='" + titulo + '\'' +
            '}';
   }
}
