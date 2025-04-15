package java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DateDifference {
	public static void main(String[] args) {
		String d1="13-01-2025",d2="29-05-2025";
		List<String> l1=Arrays.asList(d1.split("-"));
		List<String> l2=Arrays.asList(d2.split("-"));
		int day1 = Integer.parseInt(l1.get(0));
        int month1 = Integer.parseInt(l1.get(1));
        int year1 = Integer.parseInt(l1.get(2));

        int day2 = Integer.parseInt(l2.get(0));
        int month2 = Integer.parseInt(l2.get(1));
        int year2 = Integer.parseInt(l2.get(2));
        
        if(month1==month2 && year1==year2) {
        	System.out.println("days :"+Math.abs(day2-day1));
        } else {
        	int totalDays = 0;
        	 totalDays += getDaysInMonth(month1, year1) - day1;
             totalDays += day2;

             for (int i = month1 + 1; i < month2; i++) {
                 totalDays += getDaysInMonth(i, year1);
             }
        	System.out.println(totalDays);
        }
        
        
	}
	private static int getDaysInMonth(int month,int year) {
        switch (month) {
            case 1: // January
            case 3: // March
            case 5: // May
            case 7: // July
            case 8: // August
            case 10: // October
            case 12: // December
                return 31;

            case 4: // April
            case 6: // June
            case 9: // September
            case 11: // November
                return 30;

            case 2: // February
                return  28;

            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }
    }
}
