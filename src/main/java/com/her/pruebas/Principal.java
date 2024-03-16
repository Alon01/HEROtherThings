package com.her.pruebas;

import com.her.operationsher.HERComplit;
import com.her.operationsher.Tiempo;
import com.her.operationsher.TimeRex;
import com.her.operationsher.basics;
import java.time.LocalDate;

public class Principal {
    public static void main(String[] args) {
        TimeRex t = new TimeRex(17, 1, 1991);
        System.out.println("Total: " + t.cuenta());
//        Tiempo t = new Tiempo(17,1,1991);
//        System.out.println("Total de dias: " + t.everyDayCount());
    }
}