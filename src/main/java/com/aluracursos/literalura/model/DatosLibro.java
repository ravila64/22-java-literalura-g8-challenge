package com.aluracursos.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
      @JsonAlias("title") String titulo,
      @JsonAlias("authors") List<DatosAutor> autores,
      @JsonAlias("languages") List<String> idiomas
) {
   @Override
   public String toString() {
      return "DLibro{" +
            "autores=" + autores +
            ", titulo='" + titulo + '\'' +
            ", idiomas=" + idiomas +
            '}';
   }
}
