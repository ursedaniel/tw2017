package com.proiect.tw.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by JACK on 6/12/2017.
 */
public class DateUtils {

    public static String dateFormat = "dd.MM.yyyy";
    public static String dateTimeFormat = "dd.MM.yyyy HH:mm:ss";
    public static String timeFormat = "HH:mm:ss";
    public static String dateFormatter = "yyyy-MM-dd";

    public static Date getDate(String date) {
        if (date == null || date.isEmpty()) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormatter);
        return Date.from(LocalDate.parse(date, formatter).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date getStart(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormatter);

        Date start = new Date();

        if (date.length() == 10) {
            start = Date.from(LocalDate.parse(date, formatter).atStartOfDay(ZoneId.systemDefault()).toInstant());
        }

        if (date.length() == 7) {
            date = date.concat("-01");
            start = Date.from(LocalDate.parse(date, formatter).withDayOfMonth(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        }
        if (date.length() == 4) {
            date = date.concat("-01-01");
            start = Date.from(LocalDate.parse(date, formatter).withDayOfMonth(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        }

        return start;
    }

    public static Date getEnd(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Date end = new Date();

        if (date.length() == 10) {
            end = Date.from(LocalDate.parse(date, formatter).plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        }

        if (date.length() == 7) {
            date = date.concat("/01");
            end = Date.from(LocalDate.parse(date, formatter).withDayOfMonth(1).plusMonths(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        }
        if (date.length() == 4) {
            date = date.concat("/01/01");
            end = Date.from(LocalDate.parse(date, formatter).withDayOfYear(1).plusYears(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        }

        return end;
    }
}

