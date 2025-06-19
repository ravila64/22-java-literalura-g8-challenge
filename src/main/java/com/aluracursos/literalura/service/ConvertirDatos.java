package com.aluracursos.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertirDatos implements InterfaceConvertirDatos {
   private ObjectMapper objectMapper = new ObjectMapper();

   @Override
   // se elimino JsonMappingException dado por el IDE
   public <T> T convertData(String json, Class<T> tClass) {
      try {
         return objectMapper.readValue(json, tClass);
      } catch (JsonProcessingException e) {
         throw new RuntimeException(e);
      }
   }

}
