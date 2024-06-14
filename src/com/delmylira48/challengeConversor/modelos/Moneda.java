package com.delmylira48.challengeConversor.modelos;

import com.delmylira48.challengeConversor.DTO.MonedaDTO;

import java.util.Map;

public class Moneda {
    private Map<String, Double> listaConversiones;
    private String nombre;

    public Moneda(MonedaDTO monedaDTO) {
        this.listaConversiones = monedaDTO.conversion_rates();
        this.nombre = monedaDTO.base_code();
    }

    public Map<String, Double> getListaConversiones() {
        return listaConversiones;
    }

    public String getNombre() {
        return nombre;
    }
}
