package com.alura.challenge.modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMonedas {

    public Monedas convertirMonedas(String monedaBase, String monedaConvertir, double cantidad) throws IOException, InterruptedException {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/d4ebb410a7361b27684a1ca8/pair/"+
                monedaBase+"/"+monedaConvertir+"/"+cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Monedas.class);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    
}
