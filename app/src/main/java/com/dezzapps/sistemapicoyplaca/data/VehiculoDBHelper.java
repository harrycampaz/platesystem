package com.dezzapps.sistemapicoyplaca.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.dezzapps.sistemapicoyplaca.models.Automovil;
import com.dezzapps.sistemapicoyplaca.models.History;
import com.dezzapps.sistemapicoyplaca.models.Moto;
import com.dezzapps.sistemapicoyplaca.models.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehiculoDBHelper extends SQLiteOpenHelper {

    private final String TAG = VehiculoDBHelper.class.getName();

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "vehicle.db";


    public VehiculoDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println(TAG +" - Inicializar OnCreate ");

        db.execSQL("CREATE TABLE " + VehicleContract.TypeEntry.TABLE_NAME + " ("
                + VehicleContract.TypeEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + VehicleContract.TypeEntry.COLUMN_NAME_NAME + " TEXT NOT NULL,"
                + "UNIQUE (" + VehicleContract.TypeEntry._ID + "))");

        db.execSQL("CREATE TABLE " + VehicleContract.VehiculoEntry.TABLE_NAME + " ("
                + VehicleContract.VehiculoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + VehicleContract.VehiculoEntry.COLUMN_NAME_PLATE + " TEXT NOT NULL,"
                + VehicleContract.VehiculoEntry.COLUMN_NAME_ID_TYPE + " INTEGER NOT NULL,"
                + VehicleContract.VehiculoEntry.COLUMN_NAME_CONTRAVENCION + " INTEGER NOT NULL,"
                + "UNIQUE (" + VehicleContract.VehiculoEntry._ID + "))");

        db.execSQL("CREATE TABLE " + VehicleContract.HistoryEntry.TABLE_NAME + " ("
                + VehicleContract.HistoryEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + VehicleContract.HistoryEntry.COLUMN_NAME_CREATE_AT + " INTEGER NOT NULL,"
                + VehicleContract.HistoryEntry.COLUMN_NAME_DATA_IN+ " INTEGER NOT NULL,"
                + VehicleContract.HistoryEntry.COLUMN_NAME_DATA_OUT + " INTEGER NOT NULL,"
                + "UNIQUE (" + VehicleContract.HistoryEntry._ID + "))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertVehicle(Vehicle v) {
        System.out.println(TAG +" - insertVehicle");
        SQLiteDatabase db = this.getReadableDatabase();

        if(v instanceof Automovil) {
            return db.insert(
                    VehicleContract.VehiculoEntry.TABLE_NAME,
                    null,
                    ((Automovil) v).toContentValues());
        }else {
            return db.insert(
                    VehicleContract.VehiculoEntry.TABLE_NAME,
                    null,
                    ((Moto) v).toContentValues());
        }
    }

    public long insertHistory(History history) {
        System.out.println(TAG +" - insertHistory");
        SQLiteDatabase db = this.getReadableDatabase();
            return db.insert(
                    VehicleContract.HistoryEntry.TABLE_NAME,
                    null,
                    history.toContentValues());
        }


    public List<History> gethistory(){
        List<History> histories = new ArrayList<>();


        String query = "select _id as id, create_at , datain , dataout from " + VehicleContract.HistoryEntry.TABLE_NAME;
        System.out.println(query);

        Cursor c = this.getReadableDatabase()
                .rawQuery(query, null);

        int id = c.getColumnIndex("id");
        int create_at = c.getColumnIndex("create_at");
        int datain = c.getColumnIndex("datain");
        int dataout = c.getColumnIndex("dataout");



        if (c.moveToFirst()) {

            do {

                History history = new History(c.getInt(id), c.getDouble(create_at), c.getString(datain), c.getString(dataout));
                histories.add(history);

            } while(c.moveToNext());
        }
        return histories;
    }

    public int checkMulta(String  plate){
        int amout = 0;
        String query = "select _id as id from " + VehicleContract.VehiculoEntry.TABLE_NAME +" where plate = '"+plate+"' and contravencion = 1";
        System.out.println(query);
        Cursor c = this.getReadableDatabase()
                .rawQuery(query, null);
        if (c.moveToFirst()) {

            do {

               amout ++;

            } while(c.moveToNext());
        }
        return  amout;
    }
}
