package com.delmylira48.challengeConversor.domain;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ManejoArchivo {
    List<String> listaConversiones;

    public ManejoArchivo(List<String> listaConversiones) {
        this.listaConversiones = listaConversiones;
    }

    public void GenerarArchivo(){
        int indice =1;
        try{
            FileWriter fileWriter= new FileWriter("ListaDeConversiones.txt");
            fileWriter.write("Conversiones realizadas:\n");
            for(String conversion: listaConversiones){
                fileWriter.write(indice+ ". "+conversion +"\n");
                indice++;
            }
            fileWriter.close();
            System.out.println("Se generó un archivo con el registro de las conversiones realizadas");
        } catch (IOException e) {
            throw new RuntimeException("No se pudo generar el registro");
        }
    }
}
