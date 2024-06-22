package java8;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class LocalDateTimeExe {
	public static void main(String[] args) {
		localTime();
		localDateTime();
		getInstantDurationPeriod();
		formatdate();
	}

	/**The new java.time.format package is introduced in java for all the formatting and parsing requirements while
	 * dealing with Date & Time.The most important class of this package is DateTimeFormater.
	 * in comparison with the old java.util.DateFormat class ,all the DateTimeFormatter instances are thread-afe.Therefore, you can create
	 * singleton formatters like the ones denied by the DateTimeFormatter constants and share them among multiple threads.
	 * You can metion a specific pattern and Locale as well using ofPatterrn() Overloaded methods.**/
	private static void formatdate() {
		LocalDate date =LocalDate.of(2008,6,16);
		String baseISO = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
		System.out.println(baseISO);
		LocalDate baseISODate = LocalDate.parse("20080616",DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println(baseISODate);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDateTime date1  = LocalDateTime.now();
		String formatedDate = date1.format(format);
		System.out.println("Date  Is :"+formatedDate);
	    DateTimeFormatter germaFormater = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ENGLISH);
	    LocalDate date2 = LocalDate.of(2008,6,18);
	    String formatGdate = date2.format(germaFormater);
	    System.out.println("German date :"+germaFormater);
 		
	}

	/**java.time.Instant : For humans we use date and time,but for machines the time is calculated based on number of seconds passed
	 * from the Unix epoch time, set by conversation to midnight of January 1,1970 Utc.so to represent them we have instant class.
	 * java.time.Duration : Duration can used to identify the duration of time between two instances, times and date times.The difference
	 *  will be given in terms of hours,minutes,seconds and nano seconds.i cannot used with LocalDate.
	 *  java.time.period : Since LocalDate will not have time associated in it,we use Period to find the number of days difference between
	 *  two local date objects.
	 *  Both Duration and Period has many helper methods to deal with the values inside them.**/
	private static void getInstantDurationPeriod() {
//		Instant instant = Instant.ofEpochSecond(6);
//		System.out.println(instant);
//		System.out.println(instant.ofEpochSecond(4, 1_000));
//		System.out.println(instant.ofEpochSecond(4,- 1_000));
//		Instant instantNow = Instant.now();
//		System.out.println(instantNow);
	//	Duration instantDuration = Duration.between(instant, instantNow);
		//System.out.println(instantDuration);
		LocalTime t1 = LocalTime.of(12,30,44);
		LocalTime t2 = LocalTime.of(15,20,23);
		Duration d1 = Duration.between(t1, t2);
		System.out.println(d1);
		LocalDate date1 = LocalDate.of(1997, 5, 29);
		LocalDate date2 = LocalDate.of(2000, 5, 11);
		Period period = Period.between(date1, date2);
		System.out.println(period);
	}

	/**java.time.LocalDateTime:
	 * The LocaldateTime is a composite class of both LocalDate and a LocalTime.it represents both a date and a time
	 * without a time zone and can be created directly or by combining date and time. 
	 * Note:This Method cannot Deal with time zones.**/
	private static void localDateTime() {
		LocalDate date = LocalDate.of(1986, 6, 16);
		LocalTime time = LocalTime.of(12,30,10);
		LocalDateTime dateTimeVal = LocalDateTime.of(date, time);
		LocalDateTime dateTime = LocalDateTime.of(1986, 6,16, 12, 30, 10);
		System.out.println("dateTime :"+dateTime);
		System.out.println("dateTimeVal :"+dateTimeVal);
		System.out.println(dateTime.getDayOfMonth());
		/**.plusHours is used to add hours same we can do for rest methods like plusMin,plusDays etc..Similar way we can use Minus operation
		 * for reducing time.
		 * **/
		System.out.println(dateTime.plusHours(2));
	}

	/**java.time.LocalTime:
	 * 1.if we have to deal with only time of the day ignoring Date value,then we can use LocalTime class.
	 * 2.Time can be created  using multiple ways like now(),of(),parse().**/
	private static void localTime() {
		LocalTime time = LocalTime.of(12, 30,10);
		System.out.println("Given Hours :" +time.getHour());
		System.out.println("Given Minutes :"+time.getMinute());
		System.out.println("Given seconds :"+time.getSecond());
		LocalTime t1 = LocalTime.now();
		System.out.println("Current Time is :"+t1);
		LocalTime t2 = LocalTime.parse("12:30:20");
		System.out.println("Parsed Time is :"+t2);
	}

}
