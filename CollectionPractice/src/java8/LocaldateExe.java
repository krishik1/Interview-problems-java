package java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;



public class LocaldateExe {
	/**java.time.LocalDate :
	 * 1.An instance of this class is an immutable object representing a plain date without the time of the day.In other words,
	 * it doesn't carry any information about the time/time Zone.
	 * 2.date can be created using multiple ways like now(),of(),parse().
	 * 3.As you can see we have many utility methods available to know the details about given date like DayOfMonth,
	 * DayOfWeek,isLeapYear etc.
	 * We can use this in the scenario where we care about only the date but not time.**/

	public static void main(String[] args) {
		LocalDate date =LocalDate.now();
		System.out.println("date :"+date);
		LocalDate date1 = LocalDate.of(1992, 8, 22);
		System.out.println("Month of Date1 :"+date1.getMonth());
		System.out.println("Day of Month of Date1 :"+date1.getDayOfMonth());
		System.out.println("Month of Date1 :"+date1.getMonthValue());
		System.out.println("Day of year of Date1 :"+date1.getDayOfYear());
		System.out.println("Is Leap Year :"+date1.isLeapYear());
		System.out.println("Length Month of Date1 :"+date1.lengthOfMonth());
	//	System.out.println("MOnth of Date1 :"+date1.get(ChronoField.YEAR));
		int i = date1.getYear();
		System.out.println("MOnth of Date1 :"+i);
		//Coverting any format into yyyy-mm-dd
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		LocalDate d =LocalDate.parse("31/12/2018",format);
		System.out.println("date :"+d);
		
		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd-mm-yyyy");
		LocalDateTime date4 = LocalDateTime.now();
		String d5 = date4.format(format1);
		System.out.println(d5);
	}
	

}
