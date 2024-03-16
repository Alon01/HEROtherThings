package com.her.operationsher;

public class HERComplit {
    public HERComplit(){
        System.out.println("Inicia HERComplit");
    }
    public static boolean esBisiesto(int anio){
        if (anio%4==0){
          if (anio%100==0){
              return anio % 400 == 0;
          }else
              return true;
        }else
            return false;
    }
    public static int monthDays(int month, int year){         //Me dice cuantos dias tiene cada mes y si es bisiesto incrementa Febrero
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else if (esBisiesto(year)) {
            return 29;
        }else
            return 28;
    }

}
