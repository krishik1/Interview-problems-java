package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Client {
	public static void main(String[] args) {
		List<Integer> ls = Arrays.asList(12, 14, 9, 4, 22, 13, 7, 19, 30, 6);
		Stream<Integer> stream= ls.stream().filter(val-> val%2!=0).map(x->x*x).sorted();
		/* collect to list */
		ls=stream.collect(Collectors.toList());
		/* getCount
		long c=stream.count(); */
		for(Integer val : ls) {
			System.out.println("Val is : "+val);
		}
		
		/* printing with out collecting to list / sorting the list
		 * ls.stream().sorted((a,b)->b-a).forEach(System.out::println);
		ls.stream().filter(val-> val%2!=0).map(x->x*x).forEach(System.out::println);  */
		/* System.out.println("Val is : "+c);*/
		
	}
	
	
}
