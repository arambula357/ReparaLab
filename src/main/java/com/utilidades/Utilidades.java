package com.utilidades;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Diego Arambula
 */
public class Utilidades {

    public static String FechaActual(){
        String dia, mes, annio;

        LocalDateTime fechaActual = LocalDateTime.now();
        dia = String.valueOf(fechaActual.getDayOfMonth());
        mes = String.valueOf(fechaActual.getMonthValue());
        annio = String.valueOf(fechaActual.getYear());

        return dia + "/" + mes + "/" + annio;
    }

    public static String getDia(){
        LocalDateTime fechaActual = LocalDateTime.now();
        return String.valueOf(fechaActual.getDayOfMonth());
    }

    public static String getMes(){
        LocalDateTime fechaActual = LocalDateTime.now();
        return String.valueOf(fechaActual.getMonthValue());
    }

    public static String getAnnio(){
        LocalDateTime fechaActual = LocalDateTime.now();
        return String.valueOf(fechaActual.getYear());
    }

    public static String HoraActual() {
        LocalDateTime horaDia = LocalDateTime.now();
        String hora = Integer.toString(horaDia.getHour());
        String minuto = Integer.toString(horaDia.getMinute());
        String segundo = Integer.toString(horaDia.getSecond());

        return hora + ":" + minuto + ":" + segundo;
    }

    public static java.sql.Date fechaSQL() {
        Date date = new Date();

        java.sql.Date dateSQL = new java.sql.Date(date.getTime());

        return dateSQL;
    }

    public static void setUsuarioActivo(String usuario){
        Utilidades.usuario = usuario;
    }

    public static String getUsuarioActivo(){
        return usuario;
    }

    /*declaración de onjetos y variables de clase*/
    private static String usuario;
}
