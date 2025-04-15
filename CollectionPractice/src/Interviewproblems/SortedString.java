package Interviewproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortedString {
	public static void main(String[] args) {
		//List<String> list = Arrays.asList("aa 20", "bb 50", "cc 10");
		List<String> list = Arrays.asList("aa 20", "bb 50", "cc 10", "cc 30 50 30");
		
		List<String> tempList = new ArrayList<>(); // Temporary list to collect changes

        for (String str : list) {
            if (str.split(" ").length > 2) {
                String[] strArr = str.split(" ");
                for (int j = 1; j < strArr.length; j++) {
                    String x = strArr[0] + " " + strArr[j];
                    tempList.add(x);
                }
            } else {
                tempList.add(str);
            }
        }

        list = tempList;
		list.forEach(val->System.out.print(val+" "));
		System.out.println();
		List<String> res = list.stream().sorted(
				(a,b)->{
					 String[] x =a.split(" ");
					 String[] y = b.split(" ");
					 int p=Integer.valueOf(x[1]);
					 int v=Integer.valueOf(y[1]);
					 return v-p;
				}).collect(Collectors.toList());
		
		res.forEach(val ->System.out.print(val+" "));
	}
}
