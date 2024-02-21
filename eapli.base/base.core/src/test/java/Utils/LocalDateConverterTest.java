package Utils;

import junit.framework.TestCase;
import net.bytebuddy.asm.Advice;

import java.time.LocalDate;
import java.util.Date;

public class LocalDateConverterTest extends TestCase
{

    public void testConvertToLocalDateViaMilisecond() {
        Date date = new Date(2001,11,28);
        System.out.println(date);
        LocalDate localDate=LocalDate.of(2001,12,28);
        assertEquals(localDate,LocalDateConverter.convertToLocalDateViaMilisecond(date));
    }
}