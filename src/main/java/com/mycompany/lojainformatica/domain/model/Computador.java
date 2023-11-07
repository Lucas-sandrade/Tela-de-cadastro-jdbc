/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojainformatica.domain.model;

/**
 *
 * @author Lucas Andrade
 */
public class Computador {
    
    private int idComputador;
    private static String marca = "LucasSousaAndrade";
    private String HD;
    private String processador;
    
     public Computador(){
    }
     
     public Computador(String marca, String hd, String processador){
         this.marca = marca;
         this.HD = hd;
         this.processador = processador;
    }
     
      public Computador(int idcomputador, String marca, String hd, String processador){
         this.idComputador = idcomputador;
         this.marca = marca;
         this.HD = hd;
         this.processador = processador;
    }
     
     public int getIdComputador() {
        return idComputador;
    }

    public void setIdComputador(int idcomputador) {
        this.idComputador = idcomputador;
    }
    
    public static String getMarca() {
        return marca;
    }
    
     public static void setMarca(String aMarca) {
        marca = aMarca;
    }

    public String getHD() {
        return HD;
    }

    public void setHD(String HD) {
        this.HD = HD;
    }
    
    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

}
