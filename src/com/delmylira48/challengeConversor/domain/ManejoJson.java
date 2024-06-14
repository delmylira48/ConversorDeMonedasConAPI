package com.delmylira48.challengeConversor.domain;

import com.delmylira48.challengeConversor.DTO.MonedaDTO;
import com.delmylira48.challengeConversor.modelos.Moneda;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ManejoJson {
    private String contenidoJson;

    public ManejoJson(String contenidoJson) {
        this.contenidoJson = contenidoJson;
    }

    public Moneda generarJson(){
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        MonedaDTO monedaDTO = gson.fromJson(contenidoJson, MonedaDTO.class);
        Moneda moneda= new Moneda(monedaDTO);
        return moneda;
    }
}
