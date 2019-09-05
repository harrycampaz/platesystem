package com.dezzapps.sistemapicoyplaca.models;

import androidx.annotation.NonNull;

public class Automovil extends Vehiculo {
    private int numeroPuertas;
    public Automovil(String placa, String marca, String modelo, int numeroPuertas) {
        super(placa, marca, modelo);
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
