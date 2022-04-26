package com.kundan.javapractice;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ZonedDateTimeExample {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss z";

    public static void main1(String[] args) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        
        
        
        //String dateInString = "22-1-2015 10:15:55 AM PST";
        //LocalDateTime ldt = LocalDateTime.parse(dateInString, DateTimeFormatter.ofPattern(DATE_FORMAT));
        
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("US/Pacific"));
        
        ZonedDateTime pstDateTime = ZonedDateTime.of(ldt,ZoneId.of("US/Pacific")); 
                
        System.out.println(formatter.format(pstDateTime));
        
        /*
        
        ZoneId singaporeZoneId = ZoneId.of("Asia/Calcutta");
        System.out.println("TimeZone : " + singaporeZoneId);

        //LocalDateTime + ZoneId = ZonedDateTime
        ZonedDateTime asiaZonedDateTime = ldt.atZone(singaporeZoneId);
        System.out.println("Date (Singapore) : " + asiaZonedDateTime);

        ZoneId newYokZoneId = ZoneId.of("US/Pacific");
        //ZoneId.of("America/Los_Angeles");
        System.out.println("TimeZone : " + newYokZoneId);

        ZonedDateTime nyDateTime = asiaZonedDateTime.withZoneSameInstant(newYokZoneId);
        System.out.println("Date (New York) : " + nyDateTime);

        System.out.println("\n---DateTimeFormatter---");
        System.out.println("Date (Singapore) : " + formatter.format(asiaZonedDateTime));
        System.out.println("Date (New York) : " + formatter.format(nyDateTime));

        String pdtTime = formatter.format(nyDateTime);
        
        SimpleDateFormat fmt = new SimpleDateFormat(new Date().toString());
        Date var = fmt.parse(pdtTime);
        System.out.println(var);*/
    }

}