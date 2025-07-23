package java8;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.JapaneseDate;

/**
 * The new java.time.ZoneId class is the replacement for the old java.util.TimeZone class which aims to better protect you
 * from the complexities related to time zones,such as dealing with DayLight Saving Time(DST).
 * ZoneId : it describes a time-zone identifier and provides rules for converting between an instant and a LocalDateTime.
 * ZoneOffset : it describes a time-zone offset, which is the amount of time(typically in hrs) by which a time zone differs from
 * UTC/Greenwich.
 * ZonedDateTime: describes a date time  with a time zone in the OSO-8601 calendar system.
 * OffsetDateTime: describes a date-time with an offset from UTC/Greenwich OSO-8601 calendar system.
 * Calendar Systems:  The  OSO-8601 calendar system is the default calendar system considered in java.But four additional Calendar systems
 *  are provided in java 8.Each of these has a dedicated date class: ThaiBuddhistDate,MinugoDate,JapaneeseDate, and HijrahDate(Islamic).3**/
public class TimeZoneAndCalenderExe {
	public static void main(String[] args) {
		ZoneId india = ZoneId.of("Asia/Kolkata");
		ZonedDateTime zonedDateTime = ZonedDateTime.now(india);
		ZonedDateTime parisDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("Europe/Paris"));
		ZonedDateTime parisDateTime1 = zonedDateTime.withZoneSameInstant(ZoneOffset.of("+05:30"));
		System.out.println("Time in India: "+zonedDateTime);
		System.out.println("parisDateTime :"+parisDateTime);
		System.out.println("parisDateTime1 :"+parisDateTime1);
		ZoneOffset zoneOffset = ZoneOffset.of("+05:30");
	    OffsetDateTime offsetDateTime = OffsetDateTime.now(zoneOffset);
	    System.out.println("Offset Time in India: "+offsetDateTime);
	    JapaneseDate japanDate = JapaneseDate.now();
	    System.out.println("japanDate :"+japanDate);
	}

}
