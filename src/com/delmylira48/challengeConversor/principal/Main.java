package com.delmylira48.challengeConversor.principal;

import com.delmylira48.challengeConversor.domain.Conversor;
import com.delmylira48.challengeConversor.domain.LlamadaAPI;
import com.delmylira48.challengeConversor.domain.ManejoJson;

public class Main {
    public static void main(String[] args) {
        System.out.println("Sea bienvenido/a al conversor de monedas\n" +
                "1) Dolar --> Peso argentino\n" +
                "2) Peso argentino --> Dolar\n" +
                "3) Dolar --> Real brasileño\n" +
                "4) Real brasileño --> Dolar\n" +
                "5) Dolar --> Peso colombiano\n" +
                "6) Peso colombiano --> Dolar\n" +
                "7) Salir\n" +
                "Elija una opción");

        System.out.println("Ingrese el valor que desea convertir");

        System.out.println("El valor x [moneda] corresponde al valor final x [moneda]");

        LlamadaAPI llamadaAPI = new LlamadaAPI("USD");
        ManejoJson manejoJson= new ManejoJson(llamadaAPI.llamada());
        Conversor conversor= new Conversor("ARS", 1000.0, manejoJson.generarJson());
        conversor.convertir();
    }
}
