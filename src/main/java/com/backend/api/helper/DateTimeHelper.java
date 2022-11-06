package com.backend.api.helper;


import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class DateTimeHelper {
    public final static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static LocalDateTime getCurrentUtcTime() {
        return LocalDateTime.now(ZoneOffset.UTC);
    }
}
