package com.dezzapps.sistemapicoyplaca;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import com.dezzapps.sistemapicoyplaca.data.VehiculoDBHelper;
import com.dezzapps.sistemapicoyplaca.models.Automovil;
import com.dezzapps.sistemapicoyplaca.models.History;
import com.dezzapps.sistemapicoyplaca.models.Vehicle;
import com.dezzapps.sistemapicoyplaca.utils.UtilsSearch;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {


    private static final String CERO = "0";
    private static final String DOS_PUNTOS = ":";
    private static final String BARRA = "/";

    //Calendario para obtener fecha & hora
    public final Calendar c = Calendar.getInstance();

    //Fecha
    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);
    final int anio = c.get(Calendar.YEAR);

    //Hora
    final int hora = c.get(Calendar.HOUR_OF_DAY);
    final int minuto = c.get(Calendar.MINUTE);

    //Widgets
    EditText etFecha, etHora, editTextPlate;
    ImageButton ibObtenerFecha, ibObtenerHora;

    //Dias y Hora
    int checkDia = -1;
    int checkHora = -1;
    int checkMinute = -1;

    private VehiculoDBHelper vehiculoDBHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        vehiculoDBHelper = new VehiculoDBHelper(this);

        setTitle("Buscar");


        etFecha =  findViewById(R.id.et_mostrar_fecha_picker);
        etHora =  findViewById(R.id.et_mostrar_hora_picker);
        editTextPlate = findViewById(R.id.editTextPlate);

        ibObtenerFecha = findViewById(R.id.ib_obtener_fecha);
        ibObtenerHora = findViewById(R.id.ib_obtener_hora);

        ibObtenerFecha.setOnClickListener(this);
        ibObtenerHora.setOnClickListener(this);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Esta esl la cabbs s "+ checkPlate(editTextPlate.getText().toString()));
                if(checkPlate(editTextPlate.getText().toString())){
                    if(checkDia > 0 && checkHora > 0){
                        String plate = editTextPlate.getText().toString();

                       // System.out.println("Dia: " + checkDia + " Hora: " + checkHora + "Minuto: "+ checkMinute + "Placa termina en: "+ plate.substring(plate.length() -1));

                        Automovil automovil;
                        History history;


                        if(UtilsSearch.checkPicoYPlaca(checkDia, checkHora, checkMinute, Integer.parseInt(plate.substring(plate.length() -1)))){

                            automovil = new Automovil(plate, 1);
                             history = new History(1,  System.currentTimeMillis(),
                                    "Placa: "+plate+ " Fecha: "+ etFecha.getText().toString() +" - "+ etHora.getText().toString()," Tenia Pico y placa" );

                            Toast.makeText(view.getContext(), "Tienes Pico y placa" , Toast.LENGTH_SHORT).show();


                        }else{

                            automovil = new Automovil(plate, 0);
                             history = new History(1,  System.currentTimeMillis(),
                                    "Placa: "+plate+ " Fecha: "+ etFecha.getText().toString() +" - "+ etHora.getText().toString()," No Tenia Pico y placa" );

                            Toast.makeText(view.getContext(), "No Tiene Pico y placa" , Toast.LENGTH_SHORT).show();


                        }

                        int contraV = vehiculoDBHelper.checkMulta(plate);
                        if(contraV > 0){
                            Snackbar.make(view, "Esta placa tienes contravenciones: " + contraV, Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }else {
                            Snackbar.make(view, "Esta placa NO tienes contravenciones", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }

                        System.out.println("Guardo vehicle: "+ vehiculoDBHelper.insertVehicle(automovil));
                        System.out.println("Guardo historial: "+ vehiculoDBHelper.insertHistory(history));


                    }else {
                        Snackbar.make(view, "Ingresa Fecha y hora, por favor", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                }else {
                    Snackbar.make(view, "Placa Ingresada no valida", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }


            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_obtener_fecha:
                obtenerFecha();
                break;
            case R.id.ib_obtener_hora:
                obtenerHora();
                break;
        }
    }

    private void obtenerFecha(){
        DatePickerDialog recogerFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                final int mesActual = month + 1;

                String diaFormateado = (dayOfMonth < 10)? CERO + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                String mesFormateado = (mesActual < 10)? CERO + String.valueOf(mesActual):String.valueOf(mesActual);

                etFecha.setText(diaFormateado + BARRA + mesFormateado + BARRA + year);

                c.set(year, month, dayOfMonth);

                checkDia = UtilsSearch.getDayDate(c);


            }
        },anio, mes, dia);


        recogerFecha.show();

    }

    private void obtenerHora(){
        TimePickerDialog recogerHora = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                String horaFormateada =  (hourOfDay < 9)? String.valueOf(CERO + hourOfDay) : String.valueOf(hourOfDay);
                String minutoFormateado = (minute < 9)? String.valueOf(CERO + minute):String.valueOf(minute);

                String AM_PM;
                if(hourOfDay < 12) {
                    AM_PM = "a.m.";
                } else {
                    AM_PM = "p.m.";
                }

                checkHora = hourOfDay;
                checkMinute = minute;

                etHora.setText(horaFormateada + DOS_PUNTOS + minutoFormateado + " " + AM_PM);
            }

        }, hora, minuto, false);

        recogerHora.show();
    }



    //Regular expression de placa reglamentacion en colombia: tres letras y tres numeros eje abc123
    public boolean checkPlate(String s){
        if(s.length() < 1){
            return false;
        }
        return s.matches("^[A-Za-z]{3}[0-9]{3}");
    }


}
