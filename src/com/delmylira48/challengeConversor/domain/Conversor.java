package com.delmylira48.challengeConversor.domain;

import com.delmylira48.challengeConversor.modelos.Moneda;

import java.util.Map;

public class Conversor {
    private String monedaDestino;
    private Double valor;
    private Moneda claseMoneda;

    public Conversor(String monedaDestino, Double valor, Moneda claseMoneda) {
        this.monedaDestino= monedaDestino;
        this.valor = valor;
        this.claseMoneda = claseMoneda;
    }

    public String convertir(){
        Map<String, Double> listaConversiones= claseMoneda.getListaConversiones();
        Double resultado = null;

        Double valorMonedaDestino = listaConversiones.get(monedaDestino);

        if (valorMonedaDestino!=null){
            resultado = valorMonedaDestino * valor;
        }

        String conversion="Conversión de "+ valor +" " +claseMoneda.getNombre() + " a "+ monedaDestino +" es igual a " + resultado;
        System.out.println(conversion);
        return conversion;

    }


}
