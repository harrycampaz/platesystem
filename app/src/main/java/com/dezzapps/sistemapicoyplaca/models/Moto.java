package com.dezzapps.sistemapicoyplaca.models;

import android.content.ContentValues;

import com.dezzapps.sistemapicoyplaca.data.VehicleContract;

public class Moto extends Vehicle {


    public Moto(String plate, int contravencion) {
        super(plate, contravencion);
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(VehicleContract.VehiculoEntry.COLUMN_NAME_PLATE, this.getPlate());
        values.put(VehicleContract.VehiculoEntry.COLUMN_NAME_ID_TYPE, 2);
        values.put(VehicleContract.VehiculoEntry.COLUMN_NAME_CONTRAVENCION, getContravencion());
        return values;
    }
}
