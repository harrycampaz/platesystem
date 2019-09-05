package com.dezzapps.sistemapicoyplaca.models;

import androidx.annotation.NonNull;

public class Vehicle {

    private String plate;
    private int contravencion;

    public Vehicle(String plate,int contravencion) {
        this.plate = plate;
        this.contravencion = contravencion;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getContravencion() {
        return contravencion;
    }

    public void setContravencion(int contravencion) {
        this.contravencion = contravencion;
    }

    @NonNull
    @Override
    public String toString() {
        return "Placa: "+ getPlate() + "contravencion" + getContravencion();
    }
}
