package com.epam.lab5.parsing.comparing;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeCounting {

    private static Calendar CALENDAR = Calendar.getInstance();

    public static String elapsedTimeAmount(long startTime) {
        long totalTime = System.currentTimeMillis() - startTime;
        CALENDAR.setTimeInMillis(totalTime);
        SimpleDateFormat format = new SimpleDateFormat("mm:ss.SSS");
        return (String.format("Elapsed Time: %s", format.format(CALENDAR.getTime())));
    }
}
