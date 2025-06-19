package com.aluracursos.literalura.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumirAPI {
   public String obtenerDatos(String url) {
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request;
      request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();
      HttpResponse<String> response = null;
      try {
         response = client
               .send(request, HttpResponse.BodyHandlers.ofString());
      } catch (IOException | InterruptedException e) {
         throw new RuntimeException(e);
      }
      return response.body();

   }

   public JsonArray obtenerDatosResultsAsJson(String json) {
      return JsonParser.parseString(json).getAsJsonObject().get("results").getAsJsonArray();
   }
}
