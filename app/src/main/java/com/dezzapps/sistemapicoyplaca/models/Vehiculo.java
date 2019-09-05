package com.dezzapps.sistemapicoyplaca.models;

import androidx.annotation.NonNull;

public class Vehiculo {

    private String placa;
    private String marca;
    private  String modelo;

    public Vehiculo(String placa, String marca, String modelo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @NonNull
    @Override
    public String toString() {
        return "Placa: "+ getPlaca() + "Marca" + getMarca();
    }
}