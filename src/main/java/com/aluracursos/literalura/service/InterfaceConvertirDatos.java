package com.aluracursos.literalura.service;

public interface InterfaceConvertirDatos {
   public <T> T convertData(String json, Class<T> tClass);
}
