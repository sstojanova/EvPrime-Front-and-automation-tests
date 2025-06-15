package util;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DataBuilder {

    public static String currentTime(){
        ZonedDateTime dateTime = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return dateTime.format(formatter);
    }
}
