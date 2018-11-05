package com.deluca.aula.controledeabastecimento;

import java.io.Serializable;

public class Posto implements Serializable {
    private int id;
    private Double km;
    private Double litros;
    private String data;
    private String posto;

    public Posto(){
        this.setId(-1);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public Double getLitros() {
        return litros;
    }

    public void setLitros(Double litros) {
        this.litros = litros;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }
}
