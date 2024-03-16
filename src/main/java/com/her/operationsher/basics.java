package com.her.operationsher;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class basics {
    public basics() {

    }
    
    public void imprime(LocalDate f){
        long uno = diasDeVida(f);
        int dos = diasDeVidaHER(f);
//        long tres = diasDeVidaHER2(f);
        System.out.println("Con el sistema:" + uno);
        System.out.println("Con mi primer código:" + dos);
//        System.out.println("Diferencia:" + (dos-uno) );
//        System.out.println("Con mi segundo código:" + tres);
//        System.out.println("Diferencia2:" + (tres-uno));
    }
    public long diasDeVida(LocalDate fechaNacimiento){
        LocalDate ahora = LocalDate.now();
        return fechaNacimiento.until(ahora, ChronoUnit.DAYS);
    }
    public int diasDeVidaHER(LocalDate fechaNacimiento){
        LocalDate ahora = LocalDate.now();
        int dias = 0;
        for (int i = fechaNacimiento.getYear(); i < ahora.getYear(); i++){
            if (HERComplit.esBisiesto(i)){
                dias = dias + 366;
            }else{
                dias = dias + 365;
            }
        }   //Años a dias by HER
        int mesContador = fechaNacimiento.getMonthValue();
        while (mesContador != ahora.getMonthValue()){
            if (mesContador == 1 ||mesContador == 3 ||mesContador == 5 ||mesContador == 7 ||mesContador == 8 ||mesContador == 10 ||mesContador == 12){
                dias = dias + 31;
            }if (mesContador == 4 ||mesContador == 6 ||mesContador == 9 ||mesContador == 11){
                dias = dias + 30;
            }if (HERComplit.esBisiesto(ahora.getYear())){
                dias = dias + 29;
            }else dias = dias + 28;
            if (mesContador == 12){
                mesContador=1;
            }else mesContador++;

        }   //Meses a dias by HER
        if (fechaNacimiento.getDayOfMonth() < ahora.getDayOfMonth())
            dias = dias + (ahora.getDayOfMonth() - fechaNacimiento.getDayOfMonth());
        return dias;
    }
    public long diasDeVidaHER2(LocalDate fechaNacimiento){
        LocalDate ahora = LocalDate.now();
        int dayBorn = fechaNacimiento.getDayOfMonth();
        int monthBorn = fechaNacimiento.getMonthValue();
        int yearBorn = fechaNacimiento.getYear();
        long cuentaDias = 0;
        while (yearBorn <= ahora.getYear()){
            boolean esBsiesto = HERComplit.esBisiesto(fechaNacimiento.getYear());
            while (monthBorn <= ahora.getMonthValue()){
                if((dayBorn == 1 || dayBorn == 3 || dayBorn == 5 || dayBorn == 7 || dayBorn == 8 || dayBorn == 10 || dayBorn == 12) && (monthBorn != ahora.getMonthValue())){
                    while (dayBorn < 31){
                        cuentaDias++;
                        dayBorn++;
                    }
                } else if (dayBorn == 2 || dayBorn == 4 || dayBorn == 6 || dayBorn == 9 || dayBorn == 11) {
                    while (dayBorn < 30 && dayBorn != ahora.getDayOfMonth()){
                        cuentaDias++;
                        dayBorn++;
                    }
                } else if (esBsiesto) {
                    while (dayBorn < 29 && dayBorn != ahora.getDayOfMonth()){
                        cuentaDias++;
                        dayBorn++;
                    }
                }else{
                    while (dayBorn <28 && dayBorn != ahora.getDayOfMonth()){
                        cuentaDias++;
                        dayBorn++;
                    }
                }
                cuentaDias++;
                dayBorn = 1;
                monthBorn++;
            }
            monthBorn = 1;
            yearBorn++;
        }
        return cuentaDias;
    }

}
