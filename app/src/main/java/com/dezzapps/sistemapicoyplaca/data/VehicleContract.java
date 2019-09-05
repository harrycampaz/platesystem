package com.dezzapps.sistemapicoyplaca.data;

import android.provider.BaseColumns;

public class VehicleContract {

    public  static final class TypeEntry implements BaseColumns {
        public  static final String TABLE_NAME = "type";
        public static final String COLUMN_NAME_NAME = "name";
    }

    public  static final class VehiculoEntry implements BaseColumns{
        public static final String TABLE_NAME ="vehiculo";
        public static final String COLUMN_NAME_PLATE = "plate";
        public static final String COLUMN_NAME_ID_TYPE = "id_type";
        public static final String COLUMN_NAME_CONTRAVENCION = "contravencion";
    }

    public  static final class HistoryEntry implements BaseColumns{
        public static final String TABLE_NAME ="history";
        public static final String COLUMN_NAME_CREATE_AT = "create_at";
        public static final String COLUMN_NAME_DATA_IN = "datain";
        public static final String  COLUMN_NAME_DATA_OUT = "dataout";
    }
}
