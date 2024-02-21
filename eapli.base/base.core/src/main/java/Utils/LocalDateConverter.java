package Utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class LocalDateConverter {
    public static LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
        int month=dateToConvert.getMonth();
        if(month==12){
            month=1;
        }else{
            month=month+1;
        }
        System.out.println(LocalDate.of(dateToConvert.getYear(),month,dateToConvert.getDate()));
        return LocalDate.of(dateToConvert.getYear(),month,dateToConvert.getDate());
    }
}
