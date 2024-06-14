package com.delmylira48.challengeConversor.principal;

import com.delmylira48.challengeConversor.domain.Conversor;
import com.delmylira48.challengeConversor.domain.LlamadaAPI;
import com.delmylira48.challengeConversor.domain.ManejoJson;

import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String monedaOrigen;
        String monedaDestino;
        Double valor;

        while (true) {

            System.out.println("Sea bienvenido/a al conversor de monedas\n" +
                    "Las monedas disponibles con las siguientes");

            //LLAMADA PARA CONSEGUIR LOS CODIGOS DE LAS MONEDAS
            LlamadaAPI llamadaAPI = new LlamadaAPI("USD");
            ManejoJson manejoJson = new ManejoJson(llamadaAPI.llamada());
            Set<String> listaDeMonedas = manejoJson.generarJson().getListaConversiones().keySet();

            //IMPRIMIR LOS CODIGOS
            int contador = 1;
            for (String codigo : listaDeMonedas) {
                if (contador % 20 == 0) {
                    System.out.println(codigo + "    ");
                } else {
                    System.out.print(codigo + "    ");
                }
                contador++;
            }
            System.out.println();
            System.out.println("Ingrese el código de la moneda base (De la que tiene conocimiento)");
            monedaOrigen = sc.nextLine().toUpperCase();

            System.out.println("Ingrese el código de la moneda a la que quiere convertir");
            monedaDestino = sc.nextLine().toUpperCase();

            if(!listaDeMonedas.contains(monedaOrigen) || !listaDeMonedas.contains(monedaDestino) ){
                System.out.println("Se ha encontrado un codigo invalido");
                System.out.println("Presione Enter para continuar...");
                sc.nextLine();
                continue;
            }

            try {
                System.out.println("Ingrese el valor que desea convertir");
                valor = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Formato invalido");
                System.out.println("Presione Enter para continuar...");
                sc.nextLine();
                continue;
            }

            llamadaAPI = new LlamadaAPI(monedaOrigen);
            manejoJson = new ManejoJson(llamadaAPI.llamada());
            Conversor conversor = new Conversor(monedaDestino, valor, manejoJson.generarJson());
            conversor.convertir();

            System.out.println("Presione Enter para continuar...");
            sc.nextLine();

            System.out.println("Desea continuar con otra conversión? (Y/N)");
            String continuar =sc.nextLine();
            if(continuar.equalsIgnoreCase("N")){
                break;
            } else if (!continuar.equalsIgnoreCase("Y")) {
                System.out.println("Respuesta inválida, el programa terminará");
                break;
            }
        }

    }
}
