package com.delmylira48.challengeConversor.modelos;

import com.delmylira48.challengeConversor.DTO.MonedaDTO;

import java.util.Map;

public class Moneda {
    private Map<String, Double> listaConversiones;
    private String nombre;
    private Double valorBase;

    public Moneda(MonedaDTO monedaDTO) {
        this.listaConversiones = monedaDTO.conversion_rates();
        this.nombre = monedaDTO.base_code();
    }

    public Moneda(Double valorBase) {
        this.valorBase = valorBase;
    }
}
