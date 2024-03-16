package com.her.operationsher;

import java.time.LocalDate;
import java.util.Date;

public class TimeRex {
    private long sum = 0;
    private int dia, mes, anio, fdia, fmes, fanio;
    private boolean diaLleno=false, mesLleno=false, nioLleno=false;
    public TimeRex(int dia, int mes, int anio){
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.fdia = LocalDate.now().getDayOfMonth();
        this.fmes = LocalDate.now().getMonthValue();
        this.fanio = LocalDate.now().getYear();
    }
    public long cuenta(){

        sumAnio();
        return sum;
    }

    private void sumAnio(){
        while (anio<=fanio){
            System.err.println("+++Año: " + anio);
            if (mesLleno){
                sum++;
                dia = 1;
                mes = 1;
                anio++;
                mesLleno=false;
            }else sumMes();
        }
    }
    private void sumMes(){
        while (mes<=12){
            System.err.println("==Mes: " + mes);
            if (diaLleno){
                sum++;
                dia = 1;
                mes++;
                diaLleno=false;
            }else sumDias();
        }
        mesLleno = true;
    }
    private void sumDias(){
        System.err.println("Días: " + HERComplit.monthDays(mes, anio));
        while (dia<HERComplit.monthDays(mes, anio)){
            sum++;
            dia++;
        }
        diaLleno=true;
    }
    public String cosa(boolean elije){
        if (elije){
            return "Si se pudo.";
        }else return null;
    }
    public void textito(String texto){
        System.out.println(texto);
    }
    public void textito(){
        System.out.println("vacio");
    }
}
