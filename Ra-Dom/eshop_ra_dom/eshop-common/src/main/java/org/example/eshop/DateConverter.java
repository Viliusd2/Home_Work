package org.example.eshop;

import java.sql.Date;
import java.time.LocalDate;

public class DateConverter {

    public static Date localDateFormatToSql(LocalDate date) {
        return Date.valueOf(date);
    }

    public static LocalDate sqlDateFormatToLocal(Date date) {
        return date.toLocalDate();
    }
}
