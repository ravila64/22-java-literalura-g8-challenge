package com.aluracursos.literalura.dto;

public class AutorDTO {
   private String nombre;
   private Integer year_born;
   private Integer year_dead;

   public AutorDTO(String nombre, Integer year_born, Integer year_dead) {
      this.nombre = nombre;
      this.year_born = year_born;
      this.year_dead = year_dead;
   }
   // getters and setters

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public Integer getYear_born() {
      return year_born;
   }

   public void setYear_born(Integer year_born) {
      this.year_born = year_born;
   }

   public Integer getYear_dead() {
      return year_dead;
   }

   public void setYear_dead(Integer year_dead) {
      this.year_dead = year_dead;
   }

   @Override
   public String toString() {
      return "Autor{" +
            "nombre='" + nombre + '\'' +
            ", year_born=" + year_born +
            ", year_dead=" + year_dead +
            '}';
   }
}
