package com.dezzapps.sistemapicoyplaca.utils;

import java.util.Calendar;

public class UtilsSearch {


    static  public int getDayDate(Calendar c){

        switch (c.get(Calendar.DAY_OF_WEEK)){
            case Calendar.MONDAY:
                return 2;
            case Calendar.TUESDAY:
                return 3;
            case Calendar.WEDNESDAY:
                return 4;

            case Calendar.THURSDAY:
                return 5;
            case Calendar.FRIDAY:
                return 6;

            default:
                return 0;

        }

    }

    static  public boolean checkPicoYPlaca(int day, float hour, float minute, int lastCharPlate){
        System.out.println("minutos" +minute);
        System.out.println("hora" +hour);
        double horaAndMinute = hour + (minute * 0.01);
        System.out.println("Essta es la hora en decimal: " +horaAndMinute);

        boolean picoyplaca = false;

        if(lastCharPlate == 1 || lastCharPlate == 2){
            if(day == 2){
                if(horaAndMinute >= 7 && (horaAndMinute <= 9.30)){
                    picoyplaca = true;
                }else if(horaAndMinute >= 16 && (horaAndMinute <= 19.30)) {
                    picoyplaca = true;
                }
            }
        } else if(lastCharPlate == 3 || lastCharPlate == 4){
            if(day == 3){
                if(horaAndMinute >= 7 && (horaAndMinute <= 9.30)){
                    picoyplaca = true;
                }else if(horaAndMinute >= 16 && (horaAndMinute <= 19.30)) {
                    picoyplaca = true;
                }
            }
        } else if(lastCharPlate == 5 || lastCharPlate == 6){
            if(day == 4){
                if(horaAndMinute >= 7 && (horaAndMinute <= 9.30)){
                    picoyplaca = true;
                }else if(horaAndMinute >= 16 && (horaAndMinute <= 19.30)) {
                    picoyplaca = true;
                }
            }
        }else if(lastCharPlate == 7 || lastCharPlate == 8){
            if(day == 5){
                if(horaAndMinute >= 7 && (horaAndMinute <= 9.30)){
                    picoyplaca = true;
                }else if(horaAndMinute >= 16 && (horaAndMinute <= 19.30)) {
                    picoyplaca = true;
                }
            }
        } else if(lastCharPlate == 9 || lastCharPlate == 0){
            if(day == 6){
                if(horaAndMinute >= 7 && (horaAndMinute <= 9.30)){
                    picoyplaca = true;
                }else if(horaAndMinute >= 16 && (horaAndMinute <= 19.30)) {
                    picoyplaca = true;
                }
            }
        }

        return picoyplaca;
    }
}
