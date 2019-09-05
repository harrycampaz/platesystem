package com.dezzapps.sistemapicoyplaca.models;

import android.content.ContentValues;

import androidx.annotation.NonNull;

import com.dezzapps.sistemapicoyplaca.data.VehicleContract;

public class Automovil extends Vehicle {

    public Automovil(String plate, int contravencion) {
        super(plate, contravencion);
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(VehicleContract.VehiculoEntry.COLUMN_NAME_PLATE, this.getPlate());
        values.put(VehicleContract.VehiculoEntry.COLUMN_NAME_ID_TYPE, 1);
        values.put(VehicleContract.VehiculoEntry.COLUMN_NAME_CONTRAVENCION, this.getContravencion());
        return values;
    }
}
