package com.aluracursos.literalura.dto;

public class LibroAutorDTO {
   private String titulo;
   private String nombreAutor;

   public LibroAutorDTO(String nombreAutor, String titulo) {
      this.nombreAutor = nombreAutor;
      this.titulo = titulo;
   }
   //getters and setters

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
      return "LibroAutor{" +
            "Titulo='" + titulo + '\'' +
            "Autor='" + nombreAutor + '\'' +
            '}';
   }
}
