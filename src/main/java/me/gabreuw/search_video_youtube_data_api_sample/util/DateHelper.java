package me.gabreuw.search_video_youtube_data_api_sample.util;

import lombok.SneakyThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateHelper {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("'PT'mm'M'ss'S'");

    @SneakyThrows(ParseException.class)
    public static String getVideoDurationFromDateFormatted(String date) {
        Date parsedDate = SIMPLE_DATE_FORMAT.parse(date);

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(parsedDate);
        calendar.setTimeZone(TimeZone.getDefault());

        return String.format(
                "%02d:%02d",
                calendar.get(Calendar.MINUTE),
                calendar.get(Calendar.SECOND)
        );
    }

}
