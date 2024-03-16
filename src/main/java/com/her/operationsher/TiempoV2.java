package com.her.operationsher;

public class TiempoV2 {
    private long countDias, countMes, countAnio;
    private long diaInicial, diaFinal;
    private long mesInicial, mesFinal;
    private long anioInicial, anioFinal;
    boolean bisiesto = false;

    void anioRec(long anioInicial, long anioFinal){
        while (this.anioInicial < this.anioFinal){
            this.anioInicial++;
            mesRec(mesInicial, mesFinal);
            mesInicial++;
        }
        if (this.anioInicial == this.anioFinal){
            mesRec(mesInicial, mesFinal);
        }else
            System.out.println("Error en anio");
    }
    void mesRec(long mesInicial, long mesFinal){
        while (this.mesInicial<=this.mesFinal){
            if(mesInicial==1||mesInicial==3||mesInicial==5||mesInicial==7||mesInicial==8||mesInicial==10||mesInicial==12){
                segRec(1,31);
                mesInicial++;
            } else if (mesInicial==4||mesInicial==6||mesInicial==9||mesInicial==11) {
                    segRec(1,30);
            }else if(bisiesto){
                segRec(1,29);
            }else{
                segRec(1,28);
            }
        }
    }
    void segRec(long diaInicial, long diaFinal){
        while (this.diaInicial<=this.diaFinal){
            countDias++;
            this.diaInicial++;
        }
    }


}