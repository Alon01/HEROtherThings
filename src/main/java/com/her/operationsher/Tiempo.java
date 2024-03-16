package com.her.operationsher;

import java.time.LocalDate;

public class Tiempo {
    private long count = 0;
    private boolean yearComplete = false, monthComplete = false, dayComplete = false;
    private int dayNow, monthNow, yearNow;
    private int dayDate, monthDate, yearDate;
    public Tiempo(int day, int month, int year){
        this.dayDate = day;
        this.monthDate = month;
        this.yearDate = year;
        this.dayNow = LocalDate.now().getDayOfMonth();
        this.monthNow = LocalDate.now().getMonthValue();
        this.yearNow = LocalDate.now().getYear();
    }
    public long everyDayCount(){
        System.out.println("Inicia.");
        yearHerCount();
        return count;
    }
    private boolean verif(){
        if (yearComplete){
            if (monthComplete){
                return dayComplete;
            }else return false;
        }else return false;
    }
    private void yearHerCount(){
        System.out.println("Año.!!!!!!!!!!!!!!!!!");
        while (yearDate<=yearNow){
            if (yearDate<yearNow){
                System.out.println("Año menor: " + yearDate);
                montHerCount(yearComplete);
                yearDate++;
            } else if (yearDate==yearNow) {
                System.out.println("Año correcto: " + yearDate);
                yearComplete=true;
                montHerCount(yearComplete);
            }else System.out.println("El año es mayor.");
        }
        System.out.println("Fin while año.");
    }
    private void montHerCount(boolean ultimoAnio) {
        System.out.println("Mes: " + monthDate);
        if (ultimoAnio) {
            while (monthDate <= 12) {
                System.out.println("Meses del ultimo año.");
                if (monthDate < monthNow) {
                    dayHerComplete(monthComplete);
                    monthDate++;
                } else if (monthDate == monthNow) {
                    monthComplete = true;
                    dayHerComplete(monthComplete);
                }
            }
        }else{
            while (monthDate <= 12) {
                System.out.println("Contando meses.");
                if (monthDate < monthNow) {
                    dayHerComplete(monthComplete);
                    recoverDayMonth();
                } else if (monthDate == monthNow) {
                    dayHerComplete(monthComplete);
                } else System.out.println("El mes es mayor.");
            }
        }
        System.out.println("Fin mes.");
    }

    private void dayHerComplete(boolean ultimoMes){
        System.out.println("Día: " + dayDate);
        if (ultimoMes){
            System.out.println("Ultimos Días");
            while (dayDate<dayNow){
                count++;
                dayDate++;
            }
            dayComplete=true;
        }else{
            System.out.println("Contando Días.");
            while (dayDate<HERComplit.monthDays(monthDate, yearDate)){
                    dayDate++;
                    count++;
            }
            recoverDayMonth();
        }
        System.out.println("Fin Días.");
    }
    private void recoverDayMonth(){
        if (dayDate==HERComplit.monthDays(monthDate,yearDate)&&!monthComplete){
            count++;
            dayDate=1;
            monthDate++;
        }
    }
    private void recoverMonthYear(){
        if (monthDate==monthNow&&!yearComplete){
            count++;
            dayDate=1;
            monthDate=1;
            yearDate++;
        }
    }

}