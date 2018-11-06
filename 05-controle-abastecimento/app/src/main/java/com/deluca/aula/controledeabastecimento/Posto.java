package com.deluca.aula.controledeabastecimento;

class Posto {
    private int id;
    private double  kilometros;
    private double  litros;
    private String data;
    private String posto;

    public double  getKilometros() {
        return kilometros;
    }

    public void setKilometros(double kilometros) {
        this.kilometros = kilometros;
    }

    public double  getLitros() {
        return litros;
    }

    public void setLitros(double  litros) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
