package com.dezzapps.sistemapicoyplaca.models;

import android.content.ContentValues;

import com.dezzapps.sistemapicoyplaca.data.VehicleContract;

public class History {

    private int id;
    private double create_at;
    private String dataIn;
    private String dataOut;

    public History(int id, double create_at, String dataIn, String dataOut) {
        this.id = id;
        this.create_at = create_at;
        this.dataIn = dataIn;
        this.dataOut = dataOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCreate_at() {
        return create_at;
    }

    public void setCreate_at(double create_at) {
        this.create_at = create_at;
    }

    public String getDataIn() {
        return dataIn;
    }

    public void setDataIn(String dataIn) {
        this.dataIn = dataIn;
    }

    public String getDataOut() {
        return dataOut;
    }

    public void setDataOut(String dataOut) {
        this.dataOut = dataOut;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(VehicleContract.HistoryEntry.COLUMN_NAME_CREATE_AT, this.getCreate_at());
        values.put(VehicleContract.HistoryEntry.COLUMN_NAME_DATA_IN, this.getDataIn());
        values.put(VehicleContract.HistoryEntry.COLUMN_NAME_DATA_OUT, this.getDataOut());
        return values;
    }
}
