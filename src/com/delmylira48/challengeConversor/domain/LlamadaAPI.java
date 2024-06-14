package com.delmylira48.challengeConversor.domain;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LlamadaAPI {
    private String nombreMoneda;

    public LlamadaAPI(String moneda) {
        this.nombreMoneda =moneda;
    }

    public String llamada(){
        URI url = URI.create("https://v6.exchangerate-api.com/v6/9e1edbf9cbb6d9c3c3f43e7f/latest/"+ nombreMoneda);
        String contenidoJson = "";


        try{
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(url)
                    .build();

            HttpResponse<String> httpResponse = httpClient
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());

            contenidoJson = httpResponse.body();



        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }

        return contenidoJson;

    }
}
