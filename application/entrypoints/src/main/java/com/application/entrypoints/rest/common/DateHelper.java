package com.application.entrypoints.rest.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String toString(Date createdAt) {
        return DATE_FORMAT.format(createdAt);
    }
}
