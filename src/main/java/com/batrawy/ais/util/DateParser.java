package com.batrawy.ais.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateParser {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static Date getDateConverted(String date) throws ParseException {
        dateFormat.getTimeZone();
        dateFormat.setTimeZone(TimeZone.getTimeZone(TimeZone.getDefault().getDisplayName()));
        return dateFormat.parse(date);
    }

    public static Date getDateConverted(String date, String timezone) throws ParseException {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        return dateFormat.parse(date);
    }

    public static String getDateString(Date date, String timezone) {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        return dateFormat.format(date);
    }

    public static String getDateString(Date date) {
        return dateFormat.format(date);
    }
}
