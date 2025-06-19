package com.aluracursos.literalura.dto;

import com.aluracursos.literalura.model.DatosLibro;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Datos(
      @JsonAlias("results") List<DatosLibro> results
) {
}
