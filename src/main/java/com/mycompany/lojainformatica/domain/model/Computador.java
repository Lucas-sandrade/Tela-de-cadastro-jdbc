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
    private String marca;
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

    public void setIdComputador(int idComputador) {
        this.idComputador = idComputador;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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
